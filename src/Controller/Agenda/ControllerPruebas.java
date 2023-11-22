/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Agenda;

import Controller.Controller;
import Mensajes.Msj;
import Models.Agenda.Pruebas;
import Models.DAO.Dao;

/**
 *
 * @author Usuario
 */
public class ControllerPruebas implements Controller<Pruebas> {

    private Dao dao;
    private Msj msj;

    public ControllerPruebas(Dao dao, Msj msj) {
        this.dao = dao;
        this.msj = msj;
    }

    @Override
    public int insertar(Pruebas obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pruebas actulizar(Pruebas obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pruebas eliminar(Pruebas obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
