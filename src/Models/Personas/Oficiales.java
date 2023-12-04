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
        this.salario = calcularSalarioNeto(salario);
    }

    public Oficiales(double salario, String contrasena, int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = calcularSalarioNeto(salario);
        this.contrasena = contrasena;
    }

    public Oficiales(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, String contrasena) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.contrasena = contrasena;
    }

    private double calcularSalarioNeto(double salario) {
        double enfermedadMaternidad = 0.055 * salario;
        double invalidezMuerte = 0.0384 * salario;
        double aporteTrabajador = 0.01 * salario;
        double aporteSolidarista = 0.033 * salario;
        double ingresoGravable = salario - enfermedadMaternidad - invalidezMuerte - aporteTrabajador - aporteSolidarista;

        double retencionISR = 0.0;

        if (ingresoGravable <= 817000) {
            retencionISR = 0.0;
        } else if (ingresoGravable <= 1226000) {
            retencionISR = 0.1 * (ingresoGravable - 817000);
        } else {
            retencionISR = 0.15 * (ingresoGravable - 1226000);
        }
        double salarioNeto = salario - enfermedadMaternidad - invalidezMuerte - aporteTrabajador - aporteSolidarista - retencionISR;

        return salarioNeto;
    }
}
