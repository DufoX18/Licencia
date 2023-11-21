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
    private Clientes cliente;
    private boolean activa;
    public CitasDTO(int id, Date fecha, String hora) {
        super(id, fecha, hora);
    }

    public Clientes getCliente() {
        return cliente;
    }

    public boolean isActiva() {
        return activa;
    }

    public CitasDTO(Clientes cliente, boolean activa, int id, Date fecha, String hora) {
        super(id, fecha, hora);
        this.cliente = cliente;
        this.activa = activa;
    }
    
}
