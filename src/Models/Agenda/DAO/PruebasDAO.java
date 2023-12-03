/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DAO;

import DaoBD.DaoBD;
import Models.Agenda.DTO.PruebasDTO;
import Models.DAO.Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PruebasDAO implements Dao<PruebasDTO> {

    @Override
    public int insertar(PruebasDTO p) {

        
            DaoBD bd = new DaoBD();
            bd.createStatement("insert into prueba (null,?,?,?,?,?,?)");
            bd.set(1, p.getFecha());
            bd.set(2, p.getHora());
            bd.set(3, p.getObservaciones());
            bd.set(4, p.getNota());
            bd.set(5, p.getEstado());
            bd.set(6, p.getCedulaOficial());
            bd.execute(false);
        
        return 0;
    }

    @Override
    public PruebasDTO actulizar(PruebasDTO p) {
        DaoBD bd = new DaoBD(); 
        bd.createStatement("update from pruebas(?,?,?,?)");
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
        
        bd.execute(false);
        return p;
    }
        public PruebasDTO buscar(int idprueba, Date fecha, String hora,String cedulaOficial,String observaciones,int nota, String estado, String cedulaCliente){
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from pruebas where id=?");
            bd.set(1,idprueba);
            bd.set(2, fecha);
            bd.set(3, hora);
            bd.set(4, cedulaOficial);
            bd.set(5, cedulaCliente);
            bd.set(6, observaciones);
            bd.set(7, nota);
            bd.set(8, estado);
            bd.execute(true);
            if (bd.getData().next()) {
            int idpruebaa = bd.getData().getInt(1);
            int idcita = bd.getData().getInt(2);
            Date fechaa = bd.getData().getDate(3);
            String horaa = bd.getData().getString(4);
            String cedulaOficiall = bd.getData().getString(5);
            String observacioness = bd.getData().getString(6);
            int notaa = bd.getData().getInt(7);
            String cedulaClientee = bd.getData().getString(8);
            String estadoo = bd.getData().getString(9);
            
            return new PruebasDTO(idpruebaa, cedulaOficiall, observacioness, notaa, estadoo, idcita, cedulaClientee, fechaa, horaa);
            }
        }catch(SQLException ex){
            System.out.println("Error en " +ex.toString());
        }
        return null;
     
    }
    public ArrayList buscarTodo(){
       try{
          DaoBD bd = new DaoBD(); 
          bd.createStatement("select * from pruebas");
          bd.execute(true);
          ArrayList<PruebasDTO> lista = new ArrayList<>();
          while(bd.getData().next()){
              int idpruebaa = bd.getData().getInt(1);
              Date fechaa = bd.getData().getDate(2);
              String horaa = bd.getData().getString(3);
              String cedulaOficiall = bd.getData().getString(4);
              String observacioness = bd.getData().getString(5);
              int notaa = bd.getData().getInt(6);
              String cedulaClientee = bd.getData().getString(7);
              String estadoo = bd.getData().getString(8);
              PruebasDTO dto = new PruebasDTO(idpruebaa, cedulaOficiall, observacioness, notaa, estadoo, notaa, cedulaClientee, fechaa, horaa);
              lista.add(dto);
          }
       }catch(SQLException ex){
           System.out.println("Error en " + ex.toString());
       }
        return null;
    }
       public PruebasDTO buscarPorId(int idprueba) {  
        try {
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * FROM citas WHERE id = ?");
        bd.set(1, idprueba);
        bd.execute(true);

        if (bd.getData().next()) {
            int idpruebaa = bd.getData().getInt(1);
            String cedulaOficiall = bd.getData().getString(2);
            String observacioness = bd.getData().getString(3);
            int nota = bd.getData().getInt(4);
            String estadoo = bd.getData().getString(5);
            int idcitaa = bd.getData().getInt(6);
            Date fechaa = bd.getData().getDate(7);
            String cedulaClientee = bd.getData().getString(8);
            String horaa = bd.getData().getString(9);
            

            return new PruebasDTO(idpruebaa, cedulaOficiall, observacioness, nota, estadoo, idcitaa, cedulaClientee, fechaa, horaa);
        }
    } catch (SQLException ex) {
        System.out.println("Error al buscar cita por ID: " + ex.toString());
    }

    return null;
    }
}
