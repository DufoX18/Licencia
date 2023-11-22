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
    public int insertar(PruebasDTO obj) {
        
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("call insert pruebas values(null,?,?,?,?,?,?,?,?)");
            bd.set(1, obj.getFecha());
            bd.set(2, obj.getHora());
            bd.set(3, obj.getObservaciones());
            bd.set(4, obj.getNota());
            bd.set(5, obj.getEstado());
            bd.set(6, obj.getOficial());
            bd.set(7, obj.getId());
            bd.execute(false);
            if (bd.getData().next()) {
                int id = bd.getData().getInt(1);

                return id;
            }else{
                return -1;
            }
        }catch(SQLException ex){
            System.out.println("Error en "+ex.toString());
        }
        return 0;
        
    }

    @Override
    public PruebasDTO actulizar(PruebasDTO obj) {
        DaoBD bd= new DaoBD(); //Falta tryCatcht
        bd.createStatement("Update pruebas set Fecha=?, Hora=?,Observaciones=?, Nota=? Estado=? ,IdOficial=?,  WHERE IdPrueba=?");
        bd.set(1, obj.getFecha());
        bd.set(2, obj.getHora());
        bd.set(3, obj.getObservaciones());
        bd.set(4, obj.getNota());
        bd.set(5, obj.getEstado());
        bd.set(6, obj.getOficial());
        bd.execute(false);
        return obj;
        
    }

    @Override
    public PruebasDTO eliminar(PruebasDTO obj) {
        DaoBD bd = new DaoBD(); 
        bd.createStatement("call delete prueba (?,?)");
        bd.set(1, obj.getId());
        //bd.set(2, obj.getEstado());
        bd.execute(false);
        return obj;
    }

}
