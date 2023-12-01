/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Personas.DTO;

import static Models.Personas.Clientes.calcularEdad;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ClientesDTO extends PersonaDTO{
    int edad;

    public int getEdad() {
        return edad;
    }
    
    public ClientesDTO(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
    }

    public ClientesDTO(int id, String nombre, String telefono, String correo) {
        super(id, nombre, telefono, correo);
    }

    public ClientesDTO(String cedula, String nombre, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    public ClientesDTO(String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
    }
    public ClientesDTO(int edad, int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
        this.edad = calcularEdad(fechaNacimiento);
    }

}
