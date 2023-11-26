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
    private int idprueba;
    private int idoficial;
    private String observaciones;
    private int nota;
    private String estado;
    public PruebasDTO(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }
    
    public int getIdoficial() {
        return idoficial;
    }

    public int getIdprueba() {
        return idprueba;
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

    public PruebasDTO(int idprueba, int idoficial, String observaciones, int nota, String estado, int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.idprueba = idprueba;
        this.idoficial = idoficial;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    
    
}
