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
    private String cedula;
    private boolean activa;
    public Citas(int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
    }
    public Citas(Date fecha, String hora){
        super(0,fecha, hora);
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Citas(String cedula, boolean activa, int idCita, Date fecha, String hora) {
        super(idCita, fecha, hora);
        this.cedula = cedula;
        this.activa = true;
    }

    public Citas(String cedula, boolean activa, Date fecha, String hora) {
        super(0,fecha, hora);
        this.cedula = cedula;
        this.activa = activa;
    }
    public Citas(String cedula,Date fecha, String hora){
        super(0,fecha, hora);
        this.cedula=cedula;
    }
}
