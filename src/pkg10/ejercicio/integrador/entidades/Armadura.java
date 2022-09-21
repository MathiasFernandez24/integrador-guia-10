package pkg10.ejercicio.integrador.entidades;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
public class Armadura {

    private Guante gI = new Guante();
    private Guante gD= new Guante();
    private Bota bI= new Bota();
    private Bota bD=new Bota();
    private float salud = 100;
    private Integer dureza;
    private float bateria = 10000;
    private int base = 1;

    public Armadura() {
    }

    public Armadura(Guante gI, Guante gD, Bota bI, Bota bD, Integer dureza, float bateria) {
        this.gI = gI;
        this.gD = gD;
        this.bI = bI;
        this.bD = bD;
        this.dureza = dureza;
        this.bateria = bateria;
    }

    public Guante getgI() {
        return gI;
    }

    public void setgI(Guante gI) {
        this.gI = gI;
    }

    public Guante getgD() {
        return gD;
    }

    public void setgD(Guante gD) {
        this.gD = gD;
    }

    public Bota getbI() {
        return bI;
    }

    public void setbI(Bota bI) {
        this.bI = bI;
    }

    public Bota getbD() {
        return bD;
    }

    public void setbD(Bota bD) {
        this.bD = bD;
    }

    public float getSalud() {
        return salud;
    }

    public void setSalud(float salud) {
        this.salud = salud;
    }

    public Integer getDureza() {
        return dureza;
    }

    public void setDureza(Integer dureza) {
        this.dureza = dureza;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Armadura{" + "gI=" + gI + ", gD=" + gD + ", bI=" + bI + ", bD=" + bD + ", salud=" + salud + ", dureza=" + dureza + ", bateria=" + bateria + ", base=" + base + '}';
    }



}
