/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DAO;

import DaoBD.DaoBD;
import Models.Personas.DTO.ClientesDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ClientesDAO {

    public int insertar(ClientesDTO c) {

        DaoBD bd = new DaoBD();
        bd.createStatement("insert into clientes values(?,?,?,?,?)");
        bd.set(1, c.getCedula());
        bd.set(2, c.getNombre());
        bd.set(3, c.getFechaNacimiento());
        bd.set(4, c.getTelefono());
        bd.set(5, c.getCorreo());
        bd.execute(false);

        return 0;
    }

    public boolean actulizarr(ClientesDTO c) {
        DaoBD bd = new DaoBD(); // Manejo de excepciones
        bd.createStatement("UPDATE clientes SET nombre = ?, telefono = ?, correo = ? WHERE cedula = ?");
        bd.set(1, c.getNombre());
        bd.set(2, c.getTelefono());
        bd.set(3, c.getCorreo());
        bd.set(4, c.getCedula());
        return bd.execute(false);

    }

    public boolean eliminarr(String c) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarCliente (?)");
        bd.set(1, c);
        return bd.execute(false);

    }

    public ClientesDTO buscar(String cedula, String nombre, Date fecha, String telefono, String correo) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from clientes where cedula = ?");
            bd.set(1, cedula);
            bd.execute(true);
            if (bd.getData().next()) {
                int idd = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                return new ClientesDTO(idd, cedulaa, nombree, fechaa, telefonoo, correoo);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<ClientesDTO> buscarTodo() {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT * FROM clientes");
            bd.execute(true);
            ArrayList<ClientesDTO> lista = new ArrayList<>();
            while (bd.getData().next()) {
                int id = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                ClientesDTO dto = new ClientesDTO(id, cedulaa, nombree, fechaa, telefonoo, correoo);
                lista.add(dto);

            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
