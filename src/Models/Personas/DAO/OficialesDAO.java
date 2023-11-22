/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DAO;

import DaoBD.DaoBD;
import Models.DAO.Dao;
import Models.Personas.DTO.OficialesDTO;
import java.sql.SQLException;
import java.util.List;

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
    public OficialesDTO actulizar(OficialesDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OficialesDTO eliminar(OficialesDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
