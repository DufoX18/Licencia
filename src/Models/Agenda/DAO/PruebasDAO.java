/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DAO;

import DaoBD.DaoBD;
import Models.Agenda.DTO.PruebasDTO;
import Models.DAO.Dao;
import java.sql.SQLException;
import java.util.Date;

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
            bd.set(6, p.getIdoficial());
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
        bd.execute(false);
        return p;

    }

    @Override
    public PruebasDTO eliminar(PruebasDTO p) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarPrueba(?)");
        bd.set(1, p.getIdprueba());
        //bd.set(2, obj.getEstado());
        bd.execute(false);
        return p;
    }
        public PruebasDTO buscar(PruebasDTO p){
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from pruebas where id=?");
            bd.set(1,p.getIdprueba());
            bd.execute(true);
            if (bd.getData().next()) {
            int idpruebaa = bd.getData().getInt(1);
            int idcita = bd.getData().getInt(2);
            Date fechaa = bd.getData().getDate(3);
            String horaa = bd.getData().getString(4);
            int idOficiall = bd.getData().getInt(5);
            String observacioness = bd.getData().getString(6);
            int notaa = bd.getData().getInt(7);
            String estadoo = bd.getData().getString(8);
            
            return new PruebasDTO(idpruebaa,idOficiall, observacioness, notaa, estadoo, idcita, fechaa, horaa);
            }
        }catch(SQLException ex){
            System.out.println("Error en " +ex.toString());
        }
        return null;
    }
}
