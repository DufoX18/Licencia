/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Oficiales extends Persona {

    private double salario;
    public String contrasena;


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Oficiales(double salario, String contrasena, int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
        this.contrasena = contrasena;
    }

    public Oficiales(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, String contrasena) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.contrasena = contrasena;
    }

}
