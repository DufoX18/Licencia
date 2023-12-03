/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Agenda;
/**
 *
 * @author Usuario
 */
import Mensajes.Msj;
import Models.Agenda.Citas;
import Models.DAO.Dao;
import Controller.ControllerDAO;
import Models.Agenda.DAO.CitasDAO;
import Models.Agenda.DTO.CitasDTO;
import Models.Personas.Clientes;
import View.InternalFrameCita;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author Usuario
 */
public class ControllerCitas{

    InternalFrameCita vista;


    public ControllerCitas(InternalFrameCita vista) {
        this.vista=vista;
    }

    
        public void insertar(Citas c) {
          CitasDAO dao = new CitasDAO();
           if (dao.buscar(c.getCedula())== null) {
            CitasDTO dto = new CitasDTO(c.getCedula(), c.isActiva(), c.getIdCita(), c.getFecha(), c.getHora());
            int id = dao.insertar(dto);
            c.setId(id);
            vista.cargarDatos(c);
            this.mostrartodo();
            vista.notificar("Se agrrego exitosamente", JOptionPane.INFORMATION_MESSAGE);
 
        } else {
            vista.notificar("La cita ya existe", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrartodo(){
        CitasDAO dao = new CitasDAO();
        ArrayList listaa = dao.buscarTodo();
        if (listaa != null) {
          vista.mostrarTodo(listaa);
        }
    }
    
        public void eliminar(int idCita) {
        CitasDAO dao = new CitasDAO();
        CitasDTO existente = dao.buscarPorID(idCita);

        if (existente != null) {
        dao.eliminar(existente);
        vista.notificar("La cita se eliminó correctamente", JOptionPane.INFORMATION_MESSAGE);
        this.mostrartodo();
        } else {
        vista.notificar("Cita no encontrada", JOptionPane.ERROR_MESSAGE);
       }
    
      }
//    public CitasDTO buscar(CitasDTO obj) {
//        CitasDAO dao = new CitasDAO();
//        return dao.buscar(obj.getIdCita(), obj.getFecha(), obj.getHora(), obj.getCedula(), obj.isActiva());
//    }
    //o0cqw3zgych7wienxpmaxl1i
}
