/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Persona;

import Mensajes.Msj;
import Models.DAO.Dao;
import Models.Personas.Oficiales;
import READ.Read;
import java.util.List;
import Controller.ControllerDAO;

/**
 *
 * @author Usuario
 */
public class ControllerOficiales implements ControllerDAO<Oficiales> {

    private Dao dao;
    private Msj msj;

    public ControllerOficiales(Dao dao, Msj msj) {
        this.dao = dao;
        this.msj = msj;
    }

    @Override
    public int insertar(Oficiales obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Oficiales actulizar(Oficiales obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Oficiales eliminar(Oficiales obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
