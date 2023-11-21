/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DTO;

import Models.Personas.Oficiales;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PruebasDTO extends AgendaDTO{
    private Oficiales oficial;
    private String observaciones;
    private int nota;
    private String estado;
    public PruebasDTO(int id, Date fecha, String hora) {
        super(id, fecha, hora);
    }

    public Oficiales getOficial() {
        return oficial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getNota() {
        return nota;
    }

    public String getEstado() {
        return estado;
    }

    public PruebasDTO(Oficiales oficial, String observaciones, int nota, String estado, int id, Date fecha, String hora) {
        super(id, fecha, hora);
        this.oficial = oficial;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    
    
}
