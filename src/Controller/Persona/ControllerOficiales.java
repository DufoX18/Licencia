/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Persona;

import Models.Personas.DAO.ClientesDAO;
import Models.Personas.DAO.OficialesDAO;
import Models.Personas.DTO.OficialesDTO;
import Models.Personas.Oficiales;
import View.InternalFrameOficiales;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControllerOficiales {

    InternalFrameOficiales vista;

    public ControllerOficiales(InternalFrameOficiales vista) {
        this.vista = vista;
    }

    public void insertar(Oficiales o) {
        OficialesDAO dao = new OficialesDAO();
        if (dao.buscar(o.getCedula(), o.getNombre(), o.getFechaNacimiento(), o.getTelefono(), o.getCorreo(), o.getSalario(), o.getContrasena()) == null) {
            OficialesDTO dto = new OficialesDTO(o.getId(), o.getCedula(), o.getNombre(), o.getFechaNacimiento(), o.getTelefono(), o.getCorreo(), o.getSalario(), o.getContrasena());
            int id = dao.insertar(dto);
            o.setId(id);
            vista.cargarDatos(o);
            vista.notificar("El oficial se guardó correctamente", JOptionPane.INFORMATION_MESSAGE);
            this.mostrarTodo();

        } else {
            vista.notificar("El oficial ya se encuentra registrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(Oficiales o) {
        OficialesDAO dao = new OficialesDAO();
        OficialesDTO dto = new OficialesDTO(o.getCedula(),o.getContrasena());
        boolean execute = dao.actulizar(dto);
        if (execute) {
            this.mostrarTodo();
            vista.notificar("Oficial modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("No se pudo actualizar el oficial", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar(String cedula) {
        OficialesDAO dao = new OficialesDAO();
        boolean execute = dao.eliminar(cedula);
        if (execute) {
            this.mostrarTodo();
            vista.notificar("Oficial eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al eliminar el oficial", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void mostrarTodo() {
        OficialesDAO dao = new OficialesDAO();
        ArrayList lista = dao.buscarTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }
}
