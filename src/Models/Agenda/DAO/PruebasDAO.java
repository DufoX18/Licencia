/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DAO;

import DaoBD.DaoBD;
import Models.Agenda.DTO.PruebasDTO;
import Models.DAO.Dao;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class PruebasDAO implements Dao<PruebasDTO> {

    @Override
    public int insertar(PruebasDTO p) {

        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("call InsertarPrueba (null,?,?,?,?,?,?)");
            bd.set(1, p.getFecha());
            bd.set(2, p.getHora());
            bd.set(3, p.getObservaciones());
            bd.set(4, p.getNota());
            bd.set(5, p.getEstado());
            bd.set(6, p.getOficial().getId());
            bd.execute(false);
            if (bd.getData().next()) {
                int id = bd.getData().getInt(1);

                return id;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            System.out.println("Error en " + ex.toString());
        }
        return 0;

    }

    @Override
    public PruebasDTO actulizar(PruebasDTO p) {
        DaoBD bd = new DaoBD(); //Falta tryCatcht
        bd.createStatement("call ActualizarPrueba(?,?,?,?)");
        bd.set(1, p.getEstado());
        bd.set(2, p.getNota());
        bd.set(3, p.getObservaciones());
        bd.set(4, p.getId());
        bd.execute(false);
        return p;

    }

    @Override
    public PruebasDTO eliminar(PruebasDTO p) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarPrueba(?)");
        bd.set(1, p.getId());
        //bd.set(2, obj.getEstado());
        bd.execute(false);
        return p;
    }

}
