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
    private Clientes cliente;
    private boolean activa;
    public Citas(int idC, Date fecha, String hora) {
        super(idC, fecha, hora);
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Citas(Clientes cliente, boolean activa, int idC, Date fecha, String hora) {
        super(idC, fecha, hora);
        this.cliente = cliente;
        this.activa = true;
    }
    
}
