/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SDAM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import mundo.*;
import util.BST;
import util.EstampaTiempo;
import util.Faker;
import util.QueueLL;

/**
 *
 * @author giova
 */
public class Sdam {

    private Scanner Marcas; 
    private Scanner Nombres;
    private Scanner Apellidos;
    private Scanner Servicio;
    private Scanner Colores;
    private Scanner Aseguradoras;
    private BST<String, Vehiculo> bst;
    private EstampaTiempo tiempo;
    private Faker faker;
    private QueueLL<Multa> listaMultas;

    public Sdam(int numVehiculos, EstampaTiempo tiempo) throws FileNotFoundException {
        this.Marcas = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\MARCAS.txt"));
        this.Nombres = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\nombres.txt"));
        this.Apellidos = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\APELLIDOS.txt"));
        this.Servicio = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\servicios.txt"));
        this.Colores = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\colores.txt"));
        this.Aseguradoras = new Scanner(new File("D:\\AVILAN MORENO\\Downloads\\ASEGURADORAS.txt"));
        this.bst = new BST();
        this.tiempo = tiempo;
        this.faker = new Faker(Marcas, Nombres, Apellidos, Servicio, Colores, Aseguradoras, tiempo);
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo vehiculo = faker.crearVehiculo();
            bst.put(vehiculo.getPlaca(), vehiculo);
        }

    }

    public Multa generarMultaPP(EstampaTiempo tiempo, String placa) {
        Vehiculo vehiculo = consultarVehiculo(placa);
        if (vehiculo != null) {
            char num = placa.charAt((placa.length()) - 1);
            int lastValue = Integer.parseInt(Character.toString(num));            
            boolean esDiaPar = tiempo.getDay() % 2 == 0 ;
            EstampaTiempo inicioPicoPlaca = new EstampaTiempo(6, 0);
            EstampaTiempo finPicoPlaca = new EstampaTiempo(8, 30);
            EstampaTiempo inicioPicoPlaca2 = new EstampaTiempo(3, 0);
            EstampaTiempo finPicoPlaca2 =  new  EstampaTiempo(7, 0);
            if ((!tiempo.less(inicioPicoPlaca.getTime()) && tiempo.less(finPicoPlaca.getTime()) || !tiempo.less(inicioPicoPlaca2.getTime()) && tiempo.less(finPicoPlaca2.getTime()) ) && !(tiempo.getDayOfWeek().equalsIgnoreCase("domingo")  || tiempo.getDayOfWeek().equalsIgnoreCase("sabado"))&& (esDiaPar && lastValue % 2 != 0 || !esDiaPar && lastValue % 2 == 0 )) {               
                Multa multaPicoPlaca = new MultaPP(placa, tiempo);
                listaMultas.enqueue(multaPicoPlaca);
                vehiculo.getMultas().enqueue(multaPicoPlaca);
                return multaPicoPlaca;
            } else {
                return null;
            }
        }
        return null;

    }

    public Multa generarMultaSoat(EstampaTiempo tiempo, String placa) {
        Vehiculo vehiculo = consultarVehiculo(placa);
        if(vehiculo != null){
            boolean soatVencido = !tiempo.less(vehiculo.getSoat().getFecha_vencimiento().getTime());  
            if(soatVencido){
                MultaSoat multaSoat = new MultaSoat(placa, tiempo);
                vehiculo.getMultas().enqueue(multaSoat);
                listaMultas.enqueue(multaSoat);
                return multaSoat;
            }else{
                return null;
            }
            
        }
        return null;

    }
    
    public String generarPlaca(){
        return faker.placa();
    }

    public Vehiculo consultarVehiculo(String placa) {
        if (bst.contains(placa)) {
            return bst.get(placa);
        }
        return null;
    }

    public void printInOrder() {
        bst.printInOrder();
    }
    
    public BST getBST(){
        return bst;
    }

    

}
