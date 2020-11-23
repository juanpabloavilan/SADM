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

    private Vehiculo r_Vehiculo;
    private Propietario r_propietario;
    private Soat r_soat;
    private ArrayList<String> listaMarcas;
    private ArrayList<String> listaModelos;
    private ArrayList<String> listaNombres;
    private ArrayList<String> listaApellidos;
    private ArrayList<String> listaServicios;
    private ArrayList<String> listaColores;
    private ArrayList<String> listaAseguradora;
    private ArrayList<String> listaCilindrada;

    public Faker(Scanner Marcas, Scanner Modelos, Scanner Nombres, Scanner Apellidos, Scanner Servicio, Scanner Colores, Scanner Aseguradoras, Scanner Cilindrada) {
        //bajar cada entrada de flujo al ArrayList
        while (Marcas.hasNextLine()) {
            String marca = Marcas.nextLine();
            listaMarcas.add(marca);
        }
        while (Modelos.hasNextLine()) {
            String modelo = Modelos.nextLine();
            listaMarcas.add(modelo);
        }
        while (Nombres.hasNextLine()) {
            String nombre = Nombres.nextLine();
            listaMarcas.add(nombre);
        }
        while (Apellidos.hasNextLine()) {
            String apellido = Apellidos.nextLine();
            listaMarcas.add(apellido);
        }
        while (Servicio.hasNextLine()) {
            String servicio = Servicio.nextLine();
            listaMarcas.add(servicio);
        }
        while (Colores.hasNextLine()) {
            String color = Colores.nextLine();
            listaMarcas.add(color);
        }
        while (Aseguradoras.hasNextLine()) {
            String aseguradora = Aseguradoras.nextLine();
            listaMarcas.add(aseguradora);
        }

    }

    public Vehiculo crearVehiculo() {
        Vehiculo vehiculo = new Vehiculo(this.placa(), this.marca(), this.cilindrada(), this.color(), this.servicio(), crearPropietario(), r_soat);
        return vehiculo;
    }

    public Propietario crearPropietario() {
        Propietario propietario = new Propietario(this.cedula(), this.nombre(), this.apellido(), this.direccion(), this.telefono());
        return propietario;
    }

    private String placa() {
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
        String direccion = "Carrera " + randomNumber(1, 255) + (char) randomNumber(97, 118) + "Calle " + randomNumber(1, 255);
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
