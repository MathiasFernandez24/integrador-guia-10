/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.ejercicio.integrador;

import java.util.concurrent.ThreadLocalRandom;
import pkg10.ejercicio.integrador.entidades.Armadura;
import pkg10.ejercicio.integrador.servicios.Jarvis;

/**
 *
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
public class EjercicioIntegrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jarvis js = new Jarvis();
        Armadura mark42 = new Armadura();

        js.caminar(mark42);
        js.estadoArmadura(mark42);
        js.revisandoDispositivo(mark42);
        js.estadoArmadura(mark42);
        System.out.println(js.calcularDistanciaRadar(1, 1, 1));
        System.out.println(ThreadLocalRandom.current().nextInt(-1, 2));
    }

}
