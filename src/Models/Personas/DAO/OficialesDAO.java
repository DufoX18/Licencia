/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DAO;

import DaoBD.DaoBD;
import Models.Personas.DTO.OficialesDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class OficialesDAO {

    public int insertar(OficialesDTO c) {

        DaoBD bd = new DaoBD();
        bd.createStatement("INSERT INTO oficiales VALUES (null,?,?,?,?,?,?)");
        bd.set(1, c.getCedula());
        bd.set(2, c.getNombre());
        bd.set(3, c.getFechaNacimiento());
        bd.set(4, c.getTelefono());
        bd.set(5, c.getCorreo());
        bd.set(6, c.getContrasena());
        bd.execute(false);

        return 0;
    }

    public boolean actulizar(OficialesDTO o) {
        DaoBD bd = new DaoBD();
        try {
            bd.createStatement("UPDATE oficiales SET contrasena = ? WHERE cedula = ?");
            bd.set(1, o.getContrasena());
            bd.set(2, o.getCedula());
            return bd.execute(false);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean eliminar(String cedula) {
        DaoBD bd = new DaoBD();
        bd.createStatement("DELETE FROM oficiales WHERE cedula = ?");
        bd.set(1, cedula);
        return bd.execute(false);

    }

    public OficialesDTO buscar(String cedula, String nombre, Date fecha, String telefono, String correo, double salario, String contrasena) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from oficiales where cedula = ?");
            bd.set(1, cedula);
            bd.execute(true);
            if (bd.getData().next()) {
                int idd = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                double salarioo = bd.getData().getFloat(7);
                String contrasenaa = bd.getData().getString(8);
                return new OficialesDTO(idd, cedulaa, nombree, fechaa, telefonoo, correoo, salarioo, contrasenaa);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<OficialesDTO> buscarTodo() {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from oficiales");
            bd.execute(true);
            ArrayList<OficialesDTO> lista = new ArrayList<>();
            while (bd.getData().next()) {
                int id = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                double salarioo = bd.getData().getFloat(7);
                String contrasenaa = bd.getData().getString(8);
                OficialesDTO dto = new OficialesDTO(cedulaa, nombree, fechaa, telefonoo, correoo, salarioo, contrasenaa);
                lista.add(dto);

            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    public OficialesDTO buscarPorCedulaYContrasena(String cedula, String contrasena) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT * FROM oficiales WHERE cedula = ? AND contrasena = ?");
            bd.set(1, cedula);
            bd.set(2, contrasena);
            bd.execute(true);
            if (bd.getData().next()) {
                int id = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                String contrasenaa = bd.getData().getString(7);

                return new OficialesDTO(id, cedulaa, nombree, fechaa, telefonoo, correoo, contrasenaa);
            }

        } catch (SQLException ex) {
        }

        return null;
    }

    public boolean verificarContrasena(String cedula, String contrasena) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT 1 FROM oficiales WHERE cedula = ? AND contrasena = ?");
            bd.set(1, cedula);
            bd.set(2, contrasena);
            bd.execute(true);
            return bd.getData().next();
        } catch (SQLException ex) {
            return false;
        }
    }

    public OficialesDTO buscarPorCedula(String cedula) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT * FROM oficiales WHERE cedula = ?");
            bd.set(1, cedula);
            bd.execute(true);

            if (bd.getData().next()) {
                int id = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                String contrasenaa = bd.getData().getString(7);

                return new OficialesDTO(id, cedulaa, nombree, fechaa, telefonoo, correoo, contrasenaa);
            }

        } catch (SQLException ex) {
        }

        return null;
    }

    public int contarOficiales() {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT COUNT(*) FROM oficiales");
            bd.execute(true);

            if (bd.getData().next()) {
                return bd.getData().getInt(1);  // Devuelve la cantidad de oficiales en la tabla
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;  
 }
}
