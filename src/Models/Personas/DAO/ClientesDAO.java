/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DAO;

import DaoBD.DaoBD;
import Models.DAO.Dao;
import Models.Personas.DTO.ClientesDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ClientesDAO implements Dao<ClientesDTO> {

    @Override
    public int insertar(ClientesDTO c) {
//        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("call InsertarCliente (null,?,?,?,?,?)");
            bd.set(1, c.getCedula());
            bd.set(2, c.getNombre());
            bd.set(3, c.getFechaNacimiento());
            bd.set(4, c.getTelefono());
            bd.set(5, c.getCorreo());
            bd.execute(false);
//            if (bd.getData().next()) {
//                int id = bd.getData().getInt(1);
//
//                return id;
//
//            } else {
//                return -1;
//            }
//        } catch (SQLException ex) {
//            return -1;
//        }
        return 0;
    }

    @Override
    public ClientesDTO actulizar(ClientesDTO c) {
        DaoBD bd = new DaoBD(); // Manejo de excepciones
        bd.createStatement("call ActualizarCliente (?, ?, ?, ?)");
        bd.set(1, c.getNombre());
        bd.set(2, c.getTelefono());
        bd.set(3, c.getCorreo());
        bd.set(4, c.getId());
        bd.execute(false);
        return c;
    }

    @Override
    public ClientesDTO eliminar(ClientesDTO c) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarCliente (?)");
        bd.set(1, c.getId());
        bd.execute(false);
        return c;
    }

    public ClientesDTO buscar(String cedula, String nombre, Date fecha, String telefono, String correo) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from clientes where cedula = ?");
            bd.set(1, cedula);
            bd.set(2, nombre);
            bd.set(3, fecha);
            bd.set(4, telefono);
            bd.set(5, correo);
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

    public ArrayList buscarTodo() {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from clientes");
            bd.execute(true);
            ArrayList<ClientesDTO> lista = new ArrayList<>();
            while (bd.getData().next()) {
                int id = bd.getData().getInt(1);
                String cedulaa = bd.getData().getString(2);
                String nombree = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String telefonoo = bd.getData().getString(5);
                String correoo = bd.getData().getString(6);
                ClientesDTO dto = new ClientesDTO(id, cedulaa, nombree, fechaa, telefonoo, correoo);;
                lista.add(dto);

            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

}
