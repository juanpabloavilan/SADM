/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;
import util.*;
/**
 *
 * @author giova
 */
public class MultaSoat extends Multa {

    public MultaSoat( String tipo, EstampaTiempo fecha) {
        super( tipo, fecha);
        this.tipo = "Multa SOAT";
        this.codigo = "200" + (int) (Math.random() * 1000000 + 1); //200 identificador del tipo de multa SOAT
        this.valor = 877800;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
