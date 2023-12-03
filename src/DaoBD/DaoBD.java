/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DaoBD {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    
    public DaoBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
        }
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/licenciasproyecto", "java", "123");
        } catch (SQLException ex) {
            System.out.println("Error al conectar" + ex.toString());
        }
    }

    public void createStatement(String sql) {
        try {
            this.statement = this.connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Error al preparar la sentencia" + ex.toString());
        }
    }
    
    public void set(int index, Object param) {
        try {
            this.statement.setObject(index, param);
        } catch (SQLException ex) {
            System.out.println("Error al agregar parametro" + ex.toString());
        }
    }

    public boolean execute(boolean result) {
        if (result) {
            try {
                this.resultset = this.statement.executeQuery();
                return true;
            } catch (SQLException ex) {
                System.out.println("error al ejecutar" + ex.toString());
                return false;
            }
        } else {
            try {
                return this.statement.executeUpdate() > 0;
            } catch (SQLException ex) {
                System.out.println("error al ejecutar" + ex.toString());
                return false;
            }
        }
    }

    public ResultSet getData() {
        return this.resultset;
    }
}
