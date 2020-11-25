/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;
import util.EstampaTiempo;

/**
 *
 * @author AVILAN MORENO
 */
public class Multa {
   protected String codigo;
    protected String tipo;
    protected double valor;
    protected EstampaTiempo fecha;

    public Multa( String tipo, EstampaTiempo fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.tipo = tipo;
        
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EstampaTiempo getFecha() {
        return fecha;
    }

    public void setFecha(EstampaTiempo fecha) {
        this.fecha = fecha;
    } 

    @Override
    public String toString() {
        return "Multa\n" + "codigo: " + codigo + " \ntipo: " + tipo + " \nvalor: " + valor + " \nfecha: " + fecha + "\n";
    }
}
