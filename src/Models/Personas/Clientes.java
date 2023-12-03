/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Clientes extends Persona {

    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Clientes(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
    }

    public Clientes(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
    }

    public Clientes(String cedula, String nombre, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    public Clientes(String cedula) {
        super(cedula);
    }

    public Clientes(String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
    }

    public Clientes(int edad, int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.edad = calcularEdad(fechaNacimiento);
    }

    public static int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNacimientoCalendar = Calendar.getInstance();
        fechaNacimientoCalendar.setTime(fechaNacimiento);

        Calendar fechaActual = Calendar.getInstance();

        int diferenciaAnios = fechaActual.get(Calendar.YEAR) - fechaNacimientoCalendar.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.MONTH) < fechaNacimientoCalendar.get(Calendar.MONTH)
                || (fechaActual.get(Calendar.MONTH) == fechaNacimientoCalendar.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCalendar.get(Calendar.DAY_OF_MONTH))) {
            diferenciaAnios--;
        }

        return diferenciaAnios;
    }
}
