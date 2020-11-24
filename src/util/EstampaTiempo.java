/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
/**
 *
 * @author AVILAN MORENO
 */
public class EstampaTiempo {
    
    final private LocalDateTime fecha;

    public EstampaTiempo(int año, int mes, int dia, int hora, int minuto, int segundo) {
        fecha = LocalDateTime.of(año, mes, dia, hora, minuto, segundo);
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
        return fecha.getHour();
    }

    public int getMinute() {
        return fecha.getMinute();
    }

    public int getSecond() {
        return fecha.getSecond();
    }

    public boolean isFuturo() {
        if (fecha.compareTo(LocalDateTime.now()) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String formato = "EEEE, dd/MM/yyyy HH:mm:ss";
        return fecha.format(DateTimeFormatter.ofPattern(formato, Locale.forLanguageTag("es-ES")));
    }
}
