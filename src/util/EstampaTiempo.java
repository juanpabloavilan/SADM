/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
/**
 *
 * @author AVILAN MORENO
 */
public class EstampaTiempo {
    
    private LocalDate fecha;
    private LocalTime hora;
    
    public EstampaTiempo(int año, int mes, int dia, int hora,int minuto){
        this.fecha = LocalDate.of(año, mes, dia);
        this.hora = LocalTime.of(hora, minuto, 0);
    }

     public EstampaTiempo(int año, int mes, int dia) {
        if (año == 0 && mes == 0) {
            fecha = LocalDate.now();
            return;
        }
        fecha = LocalDate.of(año, mes, dia);
    }

    public EstampaTiempo(int hora,int minuto){
        if (hora == -1 || minuto == -1) {
            this.hora = LocalTime.now();
            return;
        }
        this.hora = LocalTime.of(hora,minuto,0);
    }   
    

    public int getYear() {
        return fecha.getYear();
    }

    public int getMonth() {
        return fecha.getMonthValue();
    }

    public int getDay() {
        return fecha.getDayOfMonth();
    }

    public String getDayOfWeek() {
        return fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-ES"));
    }

    public int getHour() {
        return hora.getHour();
    }

    public int getMinute() {
        return hora.getMinute();
    }

    public int getSecond() {
        return hora.getSecond();
    }
    
    public LocalTime getTime(){
        return hora;
    }
    public LocalDate getDate(){
        return fecha;
    }

   

    public boolean less(LocalTime otra){
        return this.hora.compareTo(otra) <= 0;
    }
    
    public boolean lessOrEqual(LocalDate otra){
        return this.fecha.compareTo(otra) <= 0;
    }
    
    

    @Override
    public String toString() {
        return " " + fecha.toString() +" " + hora.toString();
    }

    
}
