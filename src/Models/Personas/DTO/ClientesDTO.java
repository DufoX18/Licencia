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
public class ClientesDTO extends PersonaDTO{
    
    public ClientesDTO(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, cedula, nombre, fechaNacimiento, telefono, correo);
    }
    
}
