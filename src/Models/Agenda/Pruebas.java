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
    private int idprueba;
    private int idoficial;
    private String observaciones;
    private int nota;
    private String estado;
    
    public Pruebas(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }

    public int getIdprueba() {
        return idprueba;
    }

    public void setIdprueba(int idprueba) {
        this.idprueba = idprueba;
    }
    
    public int getOficial() {
        return idoficial;
    }

    public void setOficial(int oficial) {
        this.idoficial = idoficial;
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

    public int getIdoficial() {
        return idoficial;
    }

    public void setIdoficial(int idoficial) {
        this.idoficial = idoficial;
    }

    public Pruebas(int idprueba, int idoficial, String observaciones, int nota, String estado, int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.idprueba = idprueba;
        this.idoficial = idoficial;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    
    
}
