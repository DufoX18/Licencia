/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Persona;

import Models.Personas.DAO.OficialesDAO;
import Models.Personas.DTO.OficialesDTO;
import Models.Personas.Oficiales;
import View.CambioContrasenaOficial;
import View.IniciarSesionOficial;
import View.InternalFrameOficiales;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControllerOficiales {

    InternalFrameOficiales vista;
    IniciarSesionOficial v;
    CambioContrasenaOficial v2;

    public ControllerOficiales(InternalFrameOficiales vista) {
        this.vista = vista;
    }

    public ControllerOficiales(IniciarSesionOficial v) {
        this.v = v;
    }

    public ControllerOficiales(CambioContrasenaOficial v2) {
        this.v2 = v2;
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
        OficialesDTO dto = new OficialesDTO(o.getCedula(), o.getContrasena());
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

    public OficialesDTO iniciarSesion(String cedula, String contrasena) {
        OficialesDAO dao = new OficialesDAO();
        return dao.buscarPorCedulaYContrasena(cedula, contrasena);
    }

    public void actualizarContrasena(String cedula, String antiguaContrasena, String nuevaContrasena, String confirmarContrasena) {
        OficialesDAO dao = new OficialesDAO();

        // Verifica si la cédula existe en el sistema
        if (!dao.existeOficial(cedula)) {
            v2.notificar("No existe un oficial con la cédula proporcionada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica si la antigua contraseña coincide con la almacenada en la base de datos
        if (!dao.verificarContrasena(cedula, antiguaContrasena)) {
            v2.notificar("La antigua contraseña no coincide", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica si la nueva contraseña y la confirmación coinciden
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            v2.notificar("La nueva contraseña y la confirmación no coinciden", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear la instancia de OficialesDTO después de las verificaciones
        OficialesDTO of = new OficialesDTO(cedula, nuevaContrasena);

        boolean execute = dao.actulizar(of);

        if (execute) {
            this.mostrarTodo();
            v2.notificar("Oficial modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            v2.notificar("No se pudo actualizar el oficial", JOptionPane.ERROR_MESSAGE);
        }
    }
}
