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
import java.util.Scanner;

/**
 *
 * @author AVILAN MORENO
 */
public class InterfazApp {
   
    
    private int randomNumber(int hi, int lo){
        return (int) (Math.random()*(hi-lo) + lo);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Sdam new1 = new Sdam();
        InterfazApp i = new InterfazApp();
        String fname =args[0]; 
        boolean k = false;
        Scanner in = new Scanner(System.in);
        File f = new File(fname); 
  
        Scanner nombres = new Scanner(new File("C:\\Users\\giova\\Downloads\\SDAM_VEHICULO\\nombres.txt"));
        Scanner apellidos = new Scanner(new File("C:\\Users\\giova\\Downloads\\SDAM_VEHICULO\\apellidos.txt"));
        Scanner marca = new Scanner(new File("C:\\Users\\giova\\Downloads\\SDAM_VEHICULO\\marcas.txt"));
        
        
        
       
    }  
}
