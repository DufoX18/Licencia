/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda;

import Models.Personas.Oficiales;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Pruebas extends Agenda{
    private Oficiales oficial;
    private String observaciones;
    private int nota;
    private String estado;
    
    public Pruebas(int idC, Date fecha, String hora) {
        super(idC, fecha, hora);
    }
    public Oficiales getOficial() {
        return oficial;
    }

    public void setOficial(Oficiales oficial) {
        this.oficial = oficial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pruebas(Oficiales oficial, String observaciones, int nota, String estado, int idC, Date fecha, String hora) {
        super(idC, fecha, hora);
        this.oficial = oficial;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }

    
}
