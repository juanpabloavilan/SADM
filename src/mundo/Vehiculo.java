/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author AVILAN MORENO
 */
public class Vehiculo implements Comparable<Vehiculo> {

    private String placa;
    private String marca;
    private float cilindraje;
    private String color;
    private String servicio;
    private Propietario propietario;
    private Soat soat;
    //arraylist

    public Vehiculo(String placa, String marca, float cilindraje, String color, String servicio, Propietario propietario, Soat soat) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.servicio = servicio;
        this.propietario = propietario;
        this.soat = soat;
    }

    @Override
    public int compareTo(Vehiculo o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
