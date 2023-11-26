   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Agenda;

import Models.Personas.Clientes;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Citas extends Agenda {
    private int idcliente;
    private boolean activa;
    public Citas(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }

    public int getCliente() {
        return idcliente;
    }

    public void setCliente(int cliente) {
        this.idcliente = idcliente;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Citas(int cliente, boolean activa, int idC, Date fecha, String hora) {
        super(idC, fecha, hora);
        this.idcliente = idcliente;
        this.activa = true;
    }
    
}
