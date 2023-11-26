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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Usuario
 */
public class CitasDAO implements Dao<CitasDTO> {

    @Override
    public int insertar(CitasDTO obj) {
        try{
           DaoBD bd = new DaoBD(); 
           bd.createStatement("call insert citas(null,?,?,?,?,?)");
           
           bd.set(1, obj.getFecha());
           bd.set(2, obj.getHora());
           bd.set(3, obj.getIdCliente());
           bd.set(4, obj.isActiva());
           bd.execute(false);
           if (bd.getData().next()) {
                int id = bd.getData().getInt(1);

                return id;

            }else{
               return -1;
           }
        }catch(SQLException ex){
            
        }
        return 0;
    }

    @Override
    public CitasDTO actulizar(CitasDTO obj) {
        DaoBD bd = new DaoBD(); // Manejo de excepciones
        bd.createStatement("call ActualizarCitas (?, ?, ?)");
        bd.set(1, obj.getFecha());
        bd.set(2, obj.getHora());
        bd.set(3, obj.isActiva());
        bd.execute(false);
        return obj;
    }
    public CitasDTO buscar(Citas obj){
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from citas where id=?");
            bd.set(1, obj.getIdCita());
            bd.execute(true);
            if (bd.getData().next()) {
                int idCITA = bd.getData().getInt(1);
                Date fechaa = bd.getData().getDate(2);
                String horaa= bd.getData().getString(3);
                int clientes = bd.getData().getInt(4);
                boolean activaa = bd.getData().absolute(5);
                return new CitasDTO(idCITA, activaa, clientes, fechaa, horaa);
                
            }else{
                return null;
            }
        }catch(SQLException ex){
            System.out.println("Problema en "+ex.toString());
        }
        return null;
        
    }
    @Override
    public CitasDTO eliminar(CitasDTO obj) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call EliminarCitas (?)");
        bd.set(1, obj.getIdCita());
        bd.execute(false);
        return obj;
    }
    private boolean ValidarCita(CitasDTO cita){
        if (false) { //falta codificarlo
            
        }
        return false;
    }
    public ArrayList buscarTodo(){
        try{
            DaoBD bd = new DaoBD();
            bd.createStatement("select * from citas");
            bd.execute(true);
            ArrayList<CitasDTO> lista = new ArrayList<>();
            while(bd.getData().next()){
                int clientes = bd.getData().getInt(1);
                boolean activaa = bd.getData().absolute(2);
                int idCI = bd.getData().getInt(3);
                Date fechaa = bd.getData().getDate(2);
                String horaa= bd.getData().getString(3);
                CitasDTO dto= new CitasDTO(idCI, activaa, clientes, fechaa, horaa);
                lista.add(dto);
            }
        }catch(SQLException ex){
            System.out.println("Problemas en "+ex.toString());
        }
        return null;
    }
    
    public Clientes obtenerClienteDesdeBD(int idCliente) {
     try {
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * FROM clientes WHERE id = ?");
        bd.set(1, idCliente);
        bd.execute(true);

        if (bd.getData().next()) {
            int id = bd.getData().getInt(1);
            String cedula = bd.getData().getString(2);
            String nombre = bd.getData().getString(3);
            Date fechaNacimiento = bd.getData().getDate(4);
            String telefono = bd.getData().getString(5);
            String correo = bd.getData().getString(6);
            
            return new Clientes(id, cedula, nombre, fechaNacimiento, telefono, correo);
        }
       } catch (SQLException ex) {
        System.out.println("Error al obtener cliente desde la base de datos  " + ex.toString());
    }
    return null;
 }
        public CitasDTO buscarPorId(int idCita) {  
        try {
        DaoBD bd = new DaoBD();
        bd.createStatement("SELECT * FROM citas WHERE id = ?");
        bd.set(1, idCita);
        bd.execute(true);

        if (bd.getData().next()) {
            int id = bd.getData().getInt("");
            Date fecha = bd.getData().getDate("");
            String hora = bd.getData().getString("");
            int idCliente = bd.getData().getInt("");
            boolean activa = bd.getData().getBoolean("");

            return new CitasDTO(id, activa, idCliente, fecha, hora);
        }
    } catch (SQLException ex) {
        System.out.println("Error al buscar cita por ID: " + ex.toString());
    }

    return null;
    }
}
