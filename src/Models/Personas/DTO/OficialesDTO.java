/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DTO;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class OficialesDTO extends PersonaDTO {

    private double salario;
    private String contrasena;

    public OficialesDTO(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, double salario, String contrasena) {
        this(id, cedula, nombre, fechaNacimiento, telefono, correo, contrasena);
    }

    public OficialesDTO(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, String contrasena) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
        this.contrasena = contrasena;
    }

    public OficialesDTO(double salario, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, double s) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = s;
    }

    public String getContrasena() {
        return contrasena;
    }

    public double getSalario() {
        return salario;
    }

    public OficialesDTO(double salario, String contrasena, int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
        this.contrasena = contrasena;
    }

    public OficialesDTO(String contrasena, String cedula) {
        super(cedula);
        this.contrasena = contrasena;
    }

    

  
}
