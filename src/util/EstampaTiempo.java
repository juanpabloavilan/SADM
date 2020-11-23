/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author AVILAN MORENO
 */
public class EstampaTiempo {

    final private int year;
    final private int month;
    final private int day;
    final private int hour;
    final private int minute;
    final private int second;
    boolean isValid;

    public EstampaTiempo(int año, int mes, int dia, int hora, int minuto, int segundo) {
        this.year = año;
        this.month = mes;
        this.day = dia;
        this.hour = hora;
        this.minute = minuto;
        this.second = segundo;
    }

    public boolean isValid() {
        if (year > 1999 && month > 0 && day > 0 && hour > -1 && minute > -1 && second > -1) {
            if (year < 2021) {
                if (year % 2 == 2 && month == 2) { //Año bisiesto
                    if (day > 28) {
                        return false;
                    }
                }
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day < 32) {
                        if (hour < 24 && minute < 60 && second < 60) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                if (month < 13 && day < 31) {
                    if (hour < 24 && minute < 60 && second < 60) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        String monthP = Integer.toString(month);
        String dayP = Integer.toString(day);
        String hourP = Integer.toString(hour);
        String minuteP = Integer.toString(minute);
        String secondP = Integer.toString(second);
        if (month < 10) {
            monthP = String.format("%02d", month);
        }
        if (day < 10) {
            dayP = String.format("%02d", day);
        }
        if (hour < 10) {
            hourP = String.format("%02d", hour);
        }
        if (minute < 10) {
            minuteP = String.format("%02d", minute);
        }
        if (second < 10) {
            secondP = String.format("%02d", second);
        }
        return year + "/" + monthP + "/" + dayP + "-" + hourP + ":" + minuteP + ":" + secondP;
    }

}
