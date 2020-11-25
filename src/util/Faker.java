/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Scanner;
import mundo.*;

/**
 *
 * @author AVILAN MORENO
 */
public class Faker {

    
    private ArrayList<String> listaMarcas;
    private ArrayList<String> listaNombres;
    private ArrayList<String> listaApellidos;
    private ArrayList<String> listaServicios;
    private ArrayList<String> listaColores;
    private ArrayList<String> listaAseguradoras;
    private EstampaTiempo fechaActual;

    public Faker(Scanner Marcas, Scanner Nombres, Scanner Apellidos, Scanner Servicio, Scanner Colores, Scanner Aseguradoras, EstampaTiempo fechaActual) {
        //bajar cada entrada de flujo al ArrayList
        listaMarcas = new ArrayList<String>();
        listaApellidos = new ArrayList<String>();
        listaNombres = new ArrayList<String>();
        listaServicios = new ArrayList<String>();
        listaAseguradoras = new ArrayList<String>();
        listaColores = new ArrayList<String>();
        
        
        
        while (Marcas.hasNext()) {            
            String marca = Marcas.next();
            listaMarcas.add(marca);
        }
        
        while (Nombres.hasNext()) {
            
            String nombre = Nombres.next();
            listaNombres.add(nombre);
        }
        while (Apellidos.hasNext()) {
            
            String apellido = Apellidos.next();
            listaApellidos.add(apellido);
        }
        while (Servicio.hasNext()) {
            String servicio = Servicio.next();
            listaServicios.add(servicio);
        }
        while (Colores.hasNext()) {
            String color = Colores.next();
            listaColores.add(color);
        }
        while (Aseguradoras.hasNext()) {
            String aseguradora = Aseguradoras.next();
            listaAseguradoras.add(aseguradora);
        }
        this.fechaActual = fechaActual;

    }


    public Vehiculo crearVehiculo() {
        Vehiculo vehiculo = new Vehiculo(this.placa(), this.marca(), this.cilindrada(), this.color(), this.servicio(), crearPropietario());
        return vehiculo;
    }

    public Propietario crearPropietario() {
        Propietario propietario = new Propietario(this.cedula(), this.nombre(), this.apellido(), this.direccion(), this.telefono());
        return propietario;
    }

    public Soat crearSoat(Vehiculo vehiculo) {
        Soat soat = new Soat(vehiculo, fecha_inicio(), aseguradora());
        return soat;
    }

    private EstampaTiempo fecha_inicio() {

        EstampaTiempo fechaInicio;
        do {
            fechaInicio = new EstampaTiempo(randomNumber(2000, fechaActual.getYear()), randomNumber(1, 12), randomNumber(1, 28), randomNumber(0, 23), randomNumber(0, 59));
        } while (!fechaInicio.lessOrEqual(fechaActual.getDate()));
        return fechaInicio;
    }

    private String aseguradora() {
        return listaAseguradoras.get(randomNumber(0, listaAseguradoras.size() - 1));
    }

    public String placa() {
        String r_placa = "" + (char) randomNumber(65, 90) + (char) randomNumber(65, 90) + (char) randomNumber(65, 90) + (char) randomNumber(48, 57) + (char) randomNumber(48, 57) + (char) randomNumber(48, 57);
        return r_placa;
    }

    private String marca() {
        return listaMarcas.get(randomNumber(0, listaMarcas.size() - 1));
        
    }

    private String nombre() {
        return listaNombres.get(randomNumber(0, listaNombres.size() - 1));
    }

    private String apellido() {
        return listaApellidos.get(randomNumber(0, listaApellidos.size() - 1));
    }

    private String direccion() {
        String direccion = "Carrera " + randomNumber(1, 255) + " " +(char) randomNumber(97, 118) + "Calle " + randomNumber(1, 255);
        return direccion;
    }

    private long telefono() {
        long telefono;
        telefono = (long) (Math.random() * 10000000 + 1);
        return telefono;
    }

    private long cedula() {
        long cc;
        cc = (long) (Math.random() * 1000000000 + 1);
        return cc;
    }

    private float cilindrada() {
        float num = (float) (Math.random() * (6.0 - 1) + 1);
        return (float) redondearDecimales(num, 1);
    }

    private int randomNumber(int hi, int lo) {
        return (int) (Math.random() * (hi - lo) + lo);
    }

    private String color() {
        return listaColores.get(randomNumber(0, listaColores.size() - 1));
    }

    private String servicio() {
        return listaServicios.get(randomNumber(0, listaServicios.size() - 1));
    }

    private double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

}
