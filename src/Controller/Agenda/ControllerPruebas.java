/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Agenda;

import Mensajes.Msj;
import Models.Agenda.Pruebas;
import Models.DAO.Dao;
import Controller.ControllerDAO;
import Models.Agenda.DAO.PruebasDAO;
import Models.Agenda.DTO.PruebasDTO;
import View.InternalFrameFormPruebas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControllerPruebas implements ControllerDAO<Pruebas>{
    InternalFrameFormPruebas vista;


    public ControllerPruebas(InternalFrameFormPruebas vista) {
        this.vista=vista;
    }

    @Override
    public int insertar(Pruebas obj) {
        PruebasDAO dao= new PruebasDAO();
        if (dao.buscar(obj.getIdprueba(), obj.getFecha(), obj.getHora(), obj.getCedulaOficial(), obj.getObservaciones(), obj.getNota(), obj.getEstado(), obj.getCedulaCliente())==null) {
            PruebasDTO dto = new PruebasDTO(obj.getIdprueba(), obj.getCedulaOficial(), obj.getObservaciones(), obj.getNota(), obj.getEstado(), obj.getIdCita(), obj.getCedulaCliente(),obj.getFecha(), obj.getHora());
            int id = dao.insertar(dto);
            obj.setIdprueba(id);
            vista.cargardatos(obj);
            vista.notificar("Prueba guarda",JOptionPane.INFORMATION_MESSAGE);
            this.mostrarTodo();
        }else{
            vista.notificar("NO SE logro insertar", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    @Override
    public Pruebas actulizar(Pruebas obj) {
        PruebasDAO dao = new PruebasDAO();
        PruebasDTO existente = dao.buscarPorId(obj.getIdprueba());
        if (existente!=null) {
            dao.actulizar(existente);
            vista.notificar("Se ha actualizado correctamente", JOptionPane.INFORMATION_MESSAGE);
            this.mostrarTodo();
        }else{
            vista.notificar("Error no se pudo actualizar", JOptionPane.INFORMATION_MESSAGE);
            
        }
        return null;
    }

    @Override
    public Pruebas eliminar(Pruebas obj) {
        PruebasDAO dao = new PruebasDAO();
        PruebasDTO existente = dao.buscarPorId(obj.getIdprueba());
        if (existente != null) {
            dao.eliminar(existente);
            vista.notificar("La prueba se eliminó correctamente", JOptionPane.INFORMATION_MESSAGE);
            this.mostrarTodo();
        } else {
            vista.notificar("Prueba no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        return null;
        
    }
    public void mostrarTodo() {
        PruebasDAO dao = new PruebasDAO();
        ArrayList lista = dao.buscarTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }
}
