/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;
import util.*;

/**
 *
 * @author AVILAN MORENO
 */
public class Soat {

  
    private EstampaTiempo fecha_inicio;
    private EstampaTiempo fecha_vencimiento;
    private String aseguradora;

    public Soat(EstampaTiempo fecha_inicio, String aseguradora) {
     
        this.fecha_inicio = fecha_inicio;
        this.fecha_vencimiento = new EstampaTiempo(this.fecha_inicio.getYear()+1, this.fecha_inicio.getMonth(), this.fecha_inicio.getDay(), this.fecha_inicio.getHour(), this.fecha_inicio.getMinute());
        this.aseguradora = aseguradora;
    }

    

    public EstampaTiempo getFecha_inicio() {
        return fecha_inicio;
    }

    public EstampaTiempo getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    @Override
    public String toString() {
        return "Soat{" + "fecha_inicio=" + fecha_inicio + ", fecha_vencimiento=" + fecha_vencimiento + ", aseguradora=" + aseguradora + '}';
    }

    
    

}
