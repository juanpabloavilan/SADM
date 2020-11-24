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
public class Vehiculo implements Comparable<String> {

    private String placa;
    private String marca;
    private float cilindraje;
    private String color;
    private String servicio;
    private Propietario propietario;
    private Soat soat;
    private QueueLL<Multa> multas;
    //arraylist

    public Vehiculo(String placa, String marca, float cilindraje, String color, String servicio, Propietario propietario, Soat soat) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.servicio = servicio;
        this.propietario = propietario;
        this.soat = soat;
        this.multas = new QueueLL();
        
    }

    public String getPlaca() {
        return placa;
    }

    public QueueLL<Multa> getMultas() {
        return multas;
    }
    public Soat getSoat(){
        return this.soat;
    }
    public void setSoat(Soat soat){
        this.soat=soat;
    }
    
    

    
    @Override
    public int compareTo(String placa2) {
         
        for (int i = 0; i < placa2.length(); i++) {
            if (this.placa.charAt(i) > placa2.charAt(i)) {
                return 1;
            } else if (this.placa.charAt(i) < placa2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", cilindraje=" + cilindraje + ", color=" + color + ", servicio=" + servicio + ", propietario=" + propietario + ", soat=" + soat + ", multas=" + multas + '}';
    }

}
