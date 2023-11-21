/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DTO;

import Models.Personas.Oficiales;
import java.util.Date;

/**
 *
 * @author UTN
 */
public abstract class AgendaDTO {
    private int id;
    private Date fecha;
    private String hora;

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public AgendaDTO(int id, Date fecha, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }
    
}
