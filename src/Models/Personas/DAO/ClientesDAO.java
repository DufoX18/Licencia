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

/**
 *
 * @author Usuario
 */
public class ClientesDAO implements Dao<ClientesDTO> {

    @Override
    public int insertar(ClientesDTO c) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("call InsertarCliente (null,?,?,?,?,?)");
            bd.set(1, c.getCedula());
            bd.set(2, c.getNombre());
            bd.set(3, c.getFechaNacimiento());
            bd.set(4, c.getTelefono());
            bd.set(5, c.getCorreo());
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
    public ClientesDTO actulizar(ClientesDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClientesDTO eliminar(ClientesDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
