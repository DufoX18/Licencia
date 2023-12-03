/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DAO;

import DaoBD.DaoBD;
import Models.Agenda.Citas;
import Models.Agenda.DTO.CitasDTO;
import Models.DAO.Dao;
import Models.Personas.Clientes;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class CitasDAO implements Dao<CitasDTO> {
    
    @Override
public int insertar(CitasDTO obj) {
    try {
        DaoBD bd = new DaoBD();
        bd.createStatement("insert into citas values(null,?,?,?,?)");
        bd.set(1, obj.getFecha());
        bd.set(2, obj.getHora());
        bd.set(3, obj.getCedula());
        bd.set(4, obj.isActiva() ? 1 : 0);
        bd.execute(false); 

        
        ResultSet generatedKeys = bd.getData();
        if (generatedKeys.next()) {
            int idcita = generatedKeys.getInt(1);
            return idcita;
        } else {
            return 0; 
        }
    } catch (SQLException ex) {
        System.out.println("Error al insertar cita  " + ex.toString());
        return 0;
    }
}
    @Override
    public CitasDTO actulizar(CitasDTO obj) {
//        DaoBD bd = new DaoBD();
//        bd.createStatement("UPDATE citas SET fecha = ?, hora = ?, activa = ? WHERE id = ?");
//        bd.set(1, obj.getFecha());
//        bd.set(2, obj.getHora());
//        bd.set(3, obj.isActiva());
//        bd.set(4, obj.getIdCita());
//        bd.execute(false);
//        return obj;
        return null;
    }
    
    public CitasDTO buscar(String cedula) {
        
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * from citas");
        bd.set(1, cedula);
        bd.execute(true);
        
       try {
        if (bd.getData().next()) {
            int idCITA = bd.getData().getInt(1);
            Date fechaa = bd.getData().getDate(2);
            String horaa = bd.getData().getString(3);
            String cedulaa = bd.getData().getString(4);
            boolean activaa = bd.getData().getBoolean(5);

            return new CitasDTO(cedulaa, activaa, idCITA, fechaa, horaa);
        } else {
            return null;
        }
    } catch (SQLException ex) {
        System.out.println("Problemas en buscar " + ex.toString());
        return null;
    } finally {

    }
}
    @Override
    public CitasDTO eliminar(CitasDTO obj) {
        DaoBD bd = new DaoBD();
        bd.createStatement("delete from citas where idcita=?");
        bd.set(1, obj.getIdCita());
        bd.execute(false);
        return obj;
    }
//    private boolean ValidarCita(CitasDTO cita){
//        if (false) { 
//            
//        }
//        return false;
//    }
    public ArrayList<CitasDTO> buscarTodo(){
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT * FROM citas ");
            bd.execute(true);
            ArrayList<CitasDTO> lista = new ArrayList<>();
            while(bd.getData().next()){
                int idcitaa = bd.getData().getInt(1);
                boolean activaa = bd.getData().absolute(2);
                String cedulaa = bd.getData().getString(3);
                Date fechaa = bd.getData().getDate(4);
                String horaa= bd.getData().getString(5);
                CitasDTO dto= new CitasDTO(cedulaa, activaa, idcitaa, fechaa, horaa);
                lista.add(dto);
            }
            return lista;
        }catch(SQLException ex){
            System.out.println("Problemas en "+ex.toString());
        return null;
        }
    }
    
    public Clientes obtenerClientes(String cedula) {
     try {
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * FROM clientes WHERE cedula = ?");
        bd.set(1, cedula);
        bd.execute(true);
        
        if (bd.getData().next()) {
            int idd = bd.getData().getInt(1);
            String cedulaa = bd.getData().getString(2);
            String nombree = bd.getData().getString(3);
            Date fechaNacimientoo = bd.getData().getDate(4);
            String telefonoo = bd.getData().getString(5);
            String correoo = bd.getData().getString(6);
            
            return new Clientes(idd, cedulaa, nombree, fechaNacimientoo, telefonoo, correoo);
        }
       } catch (SQLException ex) {
        System.out.println("Error al obtener cliente desde la base de datos  " + ex.toString());
    }
    return null;
 }
    public CitasDTO buscarPorID(int idCita) {  
     try {
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * FROM citas WHERE id = ?");
        bd.set(1, idCita);
        bd.execute(true);

        if (bd.getData().next()) {
            String cedulaa = bd.getData().getString(1);
            Date fechaa = bd.getData().getDate(2);
            String horaa = bd.getData().getString(3);
            int idcitaa = bd.getData().getInt(4);
            boolean activaa = bd.getData().getBoolean(5);

            return new CitasDTO(cedulaa, activaa, idcitaa, fechaa, horaa);
        }
    } catch (SQLException ex) {
        System.out.println("Error al buscar cita por ID: " + ex.toString());
    }

    return null;
    }
    public boolean CitasActivas(String cedula) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT COUNT(*) FROM citas WHERE cedula = ? AND activa = true");
            bd.set(1, cedula);
            bd.execute(true);

            if (bd.getData().next()) {
                int count = bd.getData().getInt(1);
                return count > 0;
            }

        } catch (SQLException ex) {
            System.out.println("Error al verificar si el cliente tiene citas activas " + ex.toString());
        }
        return false;
    }
        public boolean CitasEnFechayHora(Date fecha, String hora) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("SELECT COUNT(DISTINCT idCliente) FROM citas WHERE fecha = ? AND hora = ?");
            bd.set(1, fecha);
            bd.set(2, hora);
            bd.execute(true);

            if (bd.getData().next()) {
                int count = bd.getData().getInt(1);
                return count >= 4;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar si hay mas de 4 citas en la misma hora con el mismo cliente " + ex.toString());
        }
        return false;
    }
}
