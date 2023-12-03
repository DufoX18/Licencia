/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda.DTO;

import Models.Personas.Clientes;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class CitasDTO extends AgendaDTO {
    private String cedula;
    private boolean activa;
    public CitasDTO(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }
    
    public String getCedula() {
        return cedula;
    }

    public boolean isActiva() {
        return activa;
    }

    public CitasDTO(String cedula, boolean activa, int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.cedula = cedula;
        this.activa = activa;
    }

    public CitasDTO(String cedula, boolean activa, Date fecha, String hora) {
        super(0,fecha, hora);
        this.cedula = cedula;
        this.activa = activa;
    }
   
}
