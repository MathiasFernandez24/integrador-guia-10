package pkg10.ejercicio.integrador.entidades;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
public class ObjetoVolador {

    Random rd = new Random();
    private boolean hostil;
    private int coordenadaX;
    private int coordenadaY;
    private int coordenadaZ;
    private float vida = 10.00f;

    public ObjetoVolador() {
        this.hostil = rd.nextBoolean();
        this.coordenadaX = ThreadLocalRandom.current().nextInt(-10, 11);
        this.coordenadaY = ThreadLocalRandom.current().nextInt(-10, 11);
        this.coordenadaZ = ThreadLocalRandom.current().nextInt(-9, 10);
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(int coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "ObjetoVolador{hostil=" + hostil + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", coordenadaZ=" + coordenadaZ + ", vida=" + vida + '}';
    }


}
