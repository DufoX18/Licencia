/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Agenda;

import Mensajes.Msj;
import Models.Agenda.Citas;
import Models.DAO.Dao;
import Controller.ControllerDAO;
import Models.Agenda.DAO.CitasDAO;
import Models.Agenda.DTO.CitasDTO;
import View.InternalFrameCitas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class ControllerCitas{
    InternalFrameCitas vista;
    private Dao dao;
    private Msj msj;

    public ControllerCitas(Dao dao, Msj msj) {
        this.dao = dao;
        this.msj = msj;
    }

    
    public void insertar(Citas obj) {
    CitasDAO dao = new CitasDAO();
    if (dao.buscar(obj) == null) {
        
    } else {
        vista.notificar("La cita no se pudo guardar", JOptionPane.ERROR_MESSAGE);
    }
}

    public void mostrartodo(){
        CitasDAO dao = new CitasDAO();
        ArrayList lista = dao.buscarTodo();
        if (lista!=null) {
          vista.mostrartodo(); 
        }
    }

    //verificar si se puede actualizar citas
    public void actualizar(Citas obj) {
        CitasDAO dao = new CitasDAO();
        CitasDTO existente = dao.buscarPorId(obj.getIdCita());
        
        if (existente != null) {
        dao.actulizar(existente);
        vista.notificar("La cita se actualizó correctamente", JOptionPane.INFORMATION_MESSAGE);
        this.mostrartodo();
    } else {
        vista.notificar("Cita no encontrada", JOptionPane.ERROR_MESSAGE);
   }
}
    
    public void eliminar(int idCita) {
    CitasDAO dao = new CitasDAO();
    CitasDTO existente = dao.buscarPorId(idCita);

    if (existente != null) {
        dao.eliminar(existente);
        vista.notificar("La cita se eliminó correctamente", JOptionPane.INFORMATION_MESSAGE);
        this.mostrartodo();
    } else {
        vista.notificar("Cita no encontrada", JOptionPane.ERROR_MESSAGE);
    }
    
  }
}
