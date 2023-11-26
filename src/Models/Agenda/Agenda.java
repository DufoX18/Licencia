/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public abstract class Agenda {
    private int idCita;
    private Date fecha;
    private String hora;

    public int getIdCita() {
        return idCita;
    }

    public void setId(int idCita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Agenda(int idCita, Date fecha, String hora) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
    }
    
}
