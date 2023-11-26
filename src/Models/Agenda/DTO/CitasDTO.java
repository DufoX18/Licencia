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
    private int idcliente;
    private boolean activa;
    public CitasDTO(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }

    public int getIdCliente() {
        return idcliente;
    }

    public boolean isActiva() {
        return activa;
    }

    public CitasDTO(int idcliente, boolean activa, int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.idcliente = idcliente;
        this.activa = activa;
    }
    
}
