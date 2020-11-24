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

    private Vehiculo vehiculoAsegurado;
    private EstampaTiempo fecha_inicio;
    private EstampaTiempo fecha_vencimiento;
    private String aseguradora;

    public Soat(Vehiculo vehiculoAsegurado, EstampaTiempo fecha_inicio, EstampaTiempo fecha_vencimiento, String aseguradora) {
        this.vehiculoAsegurado = vehiculoAsegurado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_vencimiento = fecha_vencimiento;
        this.aseguradora = aseguradora;
    }

}
