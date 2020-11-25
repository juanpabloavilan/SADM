/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Arrays;
import SDAM.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.*;
import util.EstampaTiempo;
import util.QueueLL;

/**
 *
 * @author AVILAN MORENO
 */
public class InterfazApp {
    
    public static int randomNumber(int hi, int lo) {
        return (int) (Math.random() * (hi - lo) + lo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Sdam Sistema;
        EstampaTiempo tiempo;
        System.out.println("SISTEMA AUTOMATICO DE DETECCION DE MULTAS");
        System.out.println("Bienvenido, digite el numero de vehiculos que desea simular: ");
        int nVehiculos = in.nextInt();
        System.out.print("Año: ");
        int año = in.nextInt();
        System.out.print("Mes: ");
        int mes = in.nextInt();
        System.out.print("día: ");
        int dia = in.nextInt();
        System.out.print("Hora: ");
        int hora = in.nextInt();
        System.out.print("Minuto: ");
        int minuto = in.nextInt();
        

        tiempo = new EstampaTiempo(año, mes, dia, hora, minuto);
        Sistema = new Sdam(nVehiculos, tiempo);
        ArrayList<String> placas= (ArrayList<String>) Sistema.getBST().keys();
        while (true) {
            System.out.println("**********************************************");
            System.out.println("SISTEMA AUTOMATICO DE DETECCION DE MULTAS");
            System.out.println("  \n1. Generar placa aleatoria"
                    + "  \n2. Imprimir vehiculos (in-order)"
                    + "  \n3. Buscar vehiculo con placa"
            );
            int op = in.nextInt();

            switch (op) {
                case 1:
                    
                    String placa = placas.get(randomNumber(0, placas.size()-1));
                    Vehiculo vehiculo = (Vehiculo) Sistema.getBST().get(placa);
                    System.out.print("Placa: " + placa);
                    System.out.println("\nImprimiendo información relacionada: \n");
                    System.out.println(vehiculo);
                    
                    System.out.println("SISTEMA AUTOMATICO DE DETECCION DE MULTAS");
                    System.out.println("  \n1. Generar multas"
                            + "  \n2. Salir");
                    op = in.nextInt();
                    
                    switch(op){
                        case 1: 
                            System.out.println("Generando multas.... \n");
                            MultaPP multaPP = (MultaPP) Sistema.generarMultaPP(tiempo, placa);
                            MultaSoat multaSoat = (MultaSoat) Sistema.generarMultaSoat(tiempo, placa);
                            if ( multaPP != null) {
                                System.out.println(multaPP);
                            }else{
                                System.out.println("No aplica para multa por pico y placa ");
                            }
                            System.out.println("**********************************************");
                            if (multaSoat != null) {
                                System.out.println(multaSoat);
                            }else{
                                System.out.println("No aplica para multa por Soat ");
                            }
                            System.out.println("**********************************************");
                        default:
                            break;                        
                    }
                    break;
                case 2:
                    System.out.println(Sistema.getBST().size());
                    System.out.println("Imprimiendo vehiculos in-order: ");
                    Sistema.getBST().printInOrder();
                    break;
                case 3:
                    System.out.println("");
                    break;
                default:
            }

        }

    }
}
