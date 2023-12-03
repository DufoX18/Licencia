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
    private String cedulaOficial;
    private String cedulaCliente;
    private String observaciones;
    private int nota;
    private String estado;
    
    public Pruebas(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }
    public Pruebas(Date fecha, String hora){
        super(0,fecha, hora);
    }
    public String getCedulaCliente() {
        return cedulaCliente;
    }
    
    public int getIdprueba() {
        return idprueba;
    }

    public void setIdprueba(int idprueba) {
        this.idprueba = idprueba;
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

    public String getCedulaOficial() {
        return cedulaOficial;
    }

    public void setCedulaOficial(String cedulaOficial) {
        this.cedulaOficial = cedulaOficial;
    }

    public Pruebas(int idprueba, String cedulaOficial, String observaciones, int nota, String estado, int idCita, Date fecha, String hora, String cedulaCliente) {
        super(idCita, fecha, hora);
        this.idprueba = idprueba;
        this.cedulaOficial = cedulaOficial;
        this.cedulaCliente=cedulaCliente;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }

    public Pruebas(int idprueba, String cedulaOficial, String cedulaCliente, String observaciones, int nota, String estado, Date fecha, String hora) {
        super(fecha, hora);
        this.idprueba = idprueba;
        this.cedulaOficial = cedulaOficial;
        this.cedulaCliente = cedulaCliente;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    
    
    
}
