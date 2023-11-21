/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models.Personas.DTO;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public abstract class PersonaDTO {

    private int id;
    private String cedula;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public PersonaDTO(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

}
