package pkg10.ejercicio.integrador.servicios;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
import java.util.Scanner;
import pkg10.ejercicio.integrador.entidades.Armadura;
import pkg10.ejercicio.integrador.entidades.Bota;
import pkg10.ejercicio.integrador.entidades.Guante;

public class Jarvis {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void caminar(Armadura a) {
        System.out.print("tiempo caminando: ");
        int tiempo = sc.nextInt();
        float consumo = 2 * a.getbD().getBase() * tiempo;
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
    }

    public void correr(Armadura a) {
        System.out.print("tiempo corriendo: ");
        int tiempo = sc.nextInt();
        int consumo = 2 * a.getbD().getBase() * tiempo * 2;
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
    }

    public void propulsar(Armadura a) {
        System.out.print("tiempo propulsando: ");
        int tiempo = sc.nextInt();
        int consumo = 2 * a.getbD().getBase() * tiempo * 3;
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
    }

    public void volar(Armadura a) {
        System.out.print("tiempo volando: ");
        int tiempo = sc.nextInt();
        int consumo = (2 * a.getbD().getBase() * tiempo * 3) - (2 * a.getgD().getBase() * tiempo * 2);
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
        randomRotura(a.getgD());
        randomRotura(a.getgI());
    }

    public void disparar(Armadura a) {
        darComandoJarvis(a);
        System.out.print("cantidad disparos: ");
        int disparos = sc.nextInt();
        int consumo = 2 * a.getgD().getBase() * disparos * a.getgD().getTiempoDisparo() * 3;
        mostrarDatosConsumo(disparos, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getgD());
        randomRotura(a.getgI());
    }

    public void darComandoJarvis(Armadura a) {
        a.setBateria(a.getBateria() - 1);
    }

    public void mostrarDatosConsumo(int tiempo, float consumo) {
        System.out.println("\nTiempo de uso: " + tiempo);
        System.out.println("Consumo: " + consumo);
    }

    public void estadoArmadura(Armadura a) {
        System.out.println("\nESTADO ARMADURA:");
        float porcentaje = (((a.getBateria() / Float.MAX_VALUE)));
        System.out.printf("%s%.38f%s", "Bateria: ", porcentaje, "%");
        System.out.println("\nGuante Izquiedo: " + (a.getgI().isEstaRoto() ? "Roto" : "En condiciones optimas"));
        System.out.println("Guante Derecho: " + (a.getgD().isEstaRoto() ? "Roto" : "En condiciones optimas"));
        System.out.println("Bota Derecha:    " + (a.getbD().isEstaRoto() ? "Roto" : "En condiciones optimas"));
        System.out.println("Bota Izquierda:  " + (a.getbI().isEstaRoto() ? "Roto" : "En condiciones optimas"));
    }

    public void randomRotura(Bota b) {
        if (Math.floor(Math.random() * 100) < 30) {
            b.setEstaRoto(true);
        }
    }

    public void randomRotura(Guante g) {
        if (Math.floor(Math.random() * 100) < 30) {
            g.setEstaRoto(true);
        }
    }
}
