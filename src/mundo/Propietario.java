/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author AVILAN MORENO
 */
public class Propietario {
    final private long cedula;
    final private String nombres;
    final private String apellidos;
    final private String direccion;
    final private long telefono;
    final private String correo;
    
    public Propietario(long cedula, String nombres, String apellidos, String direccion, long telefono){
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = nombres + apellidos + "@gmail.com";
    }

    public long getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Cedula:" + cedula + ", Nombres:" + nombres + ", Apellidos:" + apellidos + ", Direccion:" + direccion + ", Telefono:" + telefono + ", Correo:" + correo;
    }
}
