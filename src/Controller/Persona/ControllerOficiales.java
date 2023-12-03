/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Persona;

import DaoBD.DaoBD;
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

    public void eliminar(String cedula) {
        OficialesDAO dao = new OficialesDAO();
        if (dao.contarOficiales() <= 1) {
            vista.notificar("No se puede eliminar el único oficial en la base de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
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

    public void actualizar2(OficialesDTO o, String antiguaContrasena, String nuevaContrasena, String confirmarContrasena) {
        OficialesDAO dao = new OficialesDAO();
        try {
            if (antiguaContrasena != null && !dao.verificarContrasena(o.getCedula(), antiguaContrasena)) {
                notificar("La antigua contraseña no coincide", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (nuevaContrasena != null && !nuevaContrasena.equals(confirmarContrasena)) {
                notificar("La nueva contraseña y la confirmación no coinciden", JOptionPane.ERROR_MESSAGE);
                return;
            }

            OficialesDTO of = new OficialesDTO(o.getCedula(), nuevaContrasena);
            boolean execute = dao.actulizar(of);
            notificarResultado(execute, "Oficial modificado correctamente", "No se pudo actualizar el oficial");

        } catch (Exception e) {
            notificar("Error al actualizar la información del oficial", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void notificarResultado(boolean execute, String successMessage, String errorMessage) {
        if (execute) {
            mostrarTodo();
            notificar(successMessage, JOptionPane.INFORMATION_MESSAGE);
        } else {
            notificar(errorMessage, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void notificar(String mensaje, int tipo) {
        if (v2 != null) {
            v2.notificar(mensaje, tipo);
        } else {
            System.out.println("Error: La instancia de v2 es null");
        }
    }

    public OficialesDTO obtenerOficialPorCedula(String cedula) {
        OficialesDAO dao = new OficialesDAO();

        try {
            return dao.buscarPorCedula(cedula);
        } catch (Exception e) {
            return null;
        }

    }
}
