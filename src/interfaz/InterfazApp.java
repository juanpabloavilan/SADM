/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Arrays;

/**
 *
 * @author AVILAN MORENO
 */
public class InterfazApp {
    public String r_placa(){
        String r_placa = "" +(char) randomNumber(65, 90) + (char) randomNumber(65, 90)+ (char) randomNumber(65, 90)+ (char) randomNumber(48, 57) +(char) randomNumber(48, 57)+  (char) randomNumber(48, 57);
        return r_placa;
    }
    
    private int randomNumber(int hi, int lo){
        return (int) (Math.random()*(hi-lo) + lo);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazApp i = new InterfazApp();
        System.out.println(i.r_placa());
    
    }  
}
