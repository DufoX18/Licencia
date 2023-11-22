/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DAO;

import DaoBD.DaoBD;
import Models.DAO.Dao;
import Models.Personas.DTO.OficialesDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class OficialesDAO implements Dao<OficialesDTO> {

    @Override
    public int insertar(OficialesDTO c) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("call InsertarOficial (null,?,?,?,?,?,?)");
            bd.set(1, c.getCedula());
            bd.set(2, c.getNombre());
            bd.set(3, c.getFechaNacimiento());
            bd.set(4, c.getTelefono());
            bd.set(5, c.getCorreo());
            bd.set(6, c.getSalario());
            bd.execute(false);
            if (bd.getData().next()) {
                int id = bd.getData().getInt(1);

                return id;

            } else {
                return -1;
            }
        } catch (SQLException ex) {
            return -1;
        }
    }

    @Override
    public OficialesDTO actulizar(OficialesDTO o) {
        DaoBD bd = new DaoBD(); // Manejo de excepciones
        bd.createStatement("call ActualizarOficial (?, ?, ?, ?,?)");
        bd.set(1, o.getNombre());
        bd.set(2, o.getTelefono());
        bd.set(3, o.getCorreo());
        bd.set(4, o.getSalario());
        bd.set(5, o.getId());
        bd.execute(false);
        return o;
    }

    @Override
    public OficialesDTO eliminar(OficialesDTO o) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarOficial(?)");
        bd.set(1, o.getId());
        bd.execute(false);
        return o;
    }

    public OficialesDTO buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    public ArrayList buscarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
