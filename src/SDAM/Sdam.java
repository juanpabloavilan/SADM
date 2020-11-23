/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SDAM;

import java.util.Scanner;
import mundo.*;
import util.BST;
import util.EstampaTiempo;
import util.Faker;


/**
 *
 * @author giova
 */
public class Sdam {
   private Vehiculo placa;
   private BST<String, Vehiculo> bst;
   private EstampaTiempo tiempo;

   private Faker fakerR;
   
   public Sdam(int numVehiculos, EstampaTiempo tiempo){
       this.bst = new BST();
       
       
   }
   
   
   public void generarMultaPP(EstampaTiempo tiempo, String placa){
    
      
     this.placa.getMultas().enqueue(new MultaPP( "pp", tiempo));
     
   }
   public void generarMultaSoat(EstampaTiempo tiempo, String placa){
       this.placa.getMultas().enqueue(new MultaSoat("Soat" , tiempo));
   
   }
   public Vehiculo consultarVehiculo(String placa){
       if (bst.contains(placa) ) {
           return bst.get(placa);
       }
        return null;
   }
   public void ordenxd(){
     bst.printInOrder();
   }
   
   
   
   
    
}
