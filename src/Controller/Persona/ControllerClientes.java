/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Persona;

import Models.Personas.Clientes;
import Models.Personas.DAO.ClientesDAO;
import Models.Personas.DTO.ClientesDTO;
import View.InternalFrameClientes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControllerClientes {

    InternalFrameClientes vista;

    public ControllerClientes(InternalFrameClientes vista) {
        this.vista = vista;
    }

    public void insertar(Clientes c) {
        ClientesDAO dao = new ClientesDAO();
        if (dao.buscar(c.getCedula(), c.getNombre(), c.getFechaNacimiento(), c.getTelefono(), c.getCorreo()) == null) {
            ClientesDTO dto = new ClientesDTO(c.getId(), c.getCedula(), c.getNombre(), c.getFechaNacimiento(), c.getTelefono(), c.getCorreo());
            int id = dao.insertar(dto);
            c.setId(id);
            vista.cargarDatos(c);
            vista.notificar("El cliente se guardó correctamente", JOptionPane.INFORMATION_MESSAGE);
            this.mostrarTodo();

        } else {
            vista.notificar("El cliente ya se encuentra registrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(Clientes c) {
        ClientesDAO dao = new ClientesDAO();
        ClientesDTO dto = new ClientesDTO(c.getCedula(), c.getNombre(), c.getTelefono(), c.getCorreo());
        boolean execute = dao.actulizarr(dto);
        if (execute) {
            this.mostrarTodo();
            vista.notificar("Cliente modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("No se pudo actualizar el cliente", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar(String cedula) {
        ClientesDAO dao = new ClientesDAO();
        boolean execute = dao.eliminarr(cedula);
        if (execute) {
            this.mostrarTodo();
            vista.notificar("Cliente eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al eliminar el cliente", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void mostrarTodo() {
        ClientesDAO dao = new ClientesDAO();
        ArrayList lista = dao.buscarTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }

    public int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNacimientoCalendar = Calendar.getInstance();
        fechaNacimientoCalendar.setTime(fechaNacimiento);

        Calendar fechaActual = Calendar.getInstance();

        int diferenciaAnios = fechaActual.get(Calendar.YEAR) - fechaNacimientoCalendar.get(Calendar.YEAR);

        // Ajuste si la fecha actual no ha alcanzado la fecha de nacimiento
        if (fechaActual.get(Calendar.MONTH) < fechaNacimientoCalendar.get(Calendar.MONTH)
                || (fechaActual.get(Calendar.MONTH) == fechaNacimientoCalendar.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCalendar.get(Calendar.DAY_OF_MONTH))) {
            diferenciaAnios--;
        }

        return diferenciaAnios;
    }
}
