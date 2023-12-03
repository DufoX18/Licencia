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
    private String cedulaCliente;
    private String cedulaOficial;
    private String observaciones;
    private int nota;
    private String estado;
    public PruebasDTO(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }
    
    public PruebasDTO(Date fecha, String hora){
        super(fecha, hora);
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }
    
    public String getCedulaOficial() {
        return cedulaOficial;
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

    public PruebasDTO(int idprueba, String cedulaOficial, String observaciones, int nota, String estado, int idCita, String cedulaCliente, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.idprueba = idprueba;
        this.cedulaOficial = cedulaOficial;
        this.cedulaCliente=cedulaCliente;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    
        public PruebasDTO(int idprueba, String cedulaOficial, String cedulaCliente, String observaciones, int nota, String estado, Date fecha, String hora) {
       super(0,fecha, hora);
        this.idprueba = idprueba;
        this.cedulaOficial = cedulaOficial;
        this.cedulaCliente = cedulaCliente;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
}
