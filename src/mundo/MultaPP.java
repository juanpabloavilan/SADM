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
public class MultaPP extends Multa{

    private String codigo;
    private String tipo;
    private EstampaTiempo fecha;

    public MultaPP( String tipo, EstampaTiempo fecha) {
        super(tipo, fecha);
        this.tipo = "Multa Pico y Placa";
        this.codigo = "100" + (int) (Math.random() * 1000000 + 1);
        this.valor = 438.900;
        this.fecha =fecha;

    }

}
