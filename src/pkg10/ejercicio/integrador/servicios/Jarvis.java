package pkg10.ejercicio.integrador.servicios;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import pkg10.ejercicio.integrador.entidades.Armadura;
import pkg10.ejercicio.integrador.entidades.Bota;
import pkg10.ejercicio.integrador.entidades.Guante;
import pkg10.ejercicio.integrador.entidades.ObjetoVolador;

public class Jarvis {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void caminar(Armadura a) {
        System.out.println("");
        if (!a.getbD().isEstaRoto() && !a.getbI().isEstaRoto()) {
            System.out.print("tiempo caminando: ");
            float tiempo = sc.nextInt();
            float consumo = 2 * a.getbD().getBase() * tiempo;
            mostrarDatosConsumo(tiempo, consumo);
            float x = a.getBateria() - consumo;
            a.setBateria(x);
            randomRotura(a.getbD());
            randomRotura(a.getbI());
        } else {
            System.out.println("ERROR: No se puede caminar, hay daños en al menos 1 bota");
        }

    }

    public void correr(Armadura a) {
        System.out.print("tiempo corriendo: ");
        float tiempo = sc.nextInt();
        float consumo = 2 * a.getbD().getBase() * tiempo * 2;
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
    }

    public void propulsar(Armadura a) {
        System.out.print("tiempo propulsando: ");
        float tiempo = sc.nextInt();
        float consumo = 2 * a.getbD().getBase() * tiempo * 3;
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
    }

    public void volar(Armadura a) {
        System.out.print("tiempo volando: ");
        float tiempo = sc.nextInt();
        float consumo = (2 * a.getbD().getBase() * tiempo * 3) - (2 * a.getgD().getBase() * tiempo * 2);
        mostrarDatosConsumo(tiempo, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getbD());
        randomRotura(a.getbI());
        randomRotura(a.getgD());
        randomRotura(a.getgI());
    }

    public void disparar(Armadura a) {
        darComandoJarvis(a);
        float consumo = 2 * a.getgD().getBase() * a.getgD().getTiempoDisparo() * 3;
        mostrarDatosConsumo(1, consumo);
        a.setBateria(a.getBateria() - consumo);
        randomRotura(a.getgD());
        randomRotura(a.getgI());
    }

    public void darComandoJarvis(Armadura a) {
        a.setBateria(a.getBateria() - 1);
    }

    public void mostrarDatosConsumo(float tiempo, float consumo) {
        System.out.println("\nTiempo de uso: " + tiempo);
        System.out.println("Consumo: " + consumo);
    }

    public void estadoArmadura(Armadura a) {
        System.out.println("\nESTADO ARMADURA:");
        float porcentaje = a.getBateria() / 100;
        System.out.printf("%s%.2f%%\n", "Bateria: ", porcentaje);
        estadoReactorV2(a);
        System.out.println("Guante Izquiedo: " + (a.getgI().isEstaDestruido() ? "Destruido" : (a.getgI().isEstaRoto() ? "Roto" : "En condiciones optimas")));
        System.out.println("Guante Derecho:  " + (a.getgD().isEstaDestruido() ? "Destruido" : (a.getgD().isEstaRoto() ? "Roto" : "En condiciones optimas")));
        System.out.println("Bota Izquierda:  " + (a.getbI().isEstaDestruido() ? "Destruido" : (a.getbI().isEstaRoto() ? "Roto" : "En condiciones optimas")));
        System.out.println("Bota Derecha:    " + (a.getbD().isEstaDestruido() ? "Destruido" : (a.getbD().isEstaRoto() ? "Roto" : "En condiciones optimas")));
        System.out.println("");
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

    public void randomReparacion(Bota b) {
        if (Math.floor(Math.random() * 100) < 40) {
            b.setEstaRoto(false);
            System.out.println("La Bota ha sido reparada");
        }
    }

    public void randomReparacion(Guante g) {
        if (Math.floor(Math.random() * 100) < 40) {
            g.setEstaRoto(false);
            System.out.println("El Guante ha sido reparado");
        }
    }

    public void estadoReactorV2(Armadura a) {
        System.out.print("Bateria: ");
        if (a.getBateria() <= 2500) {
            System.out.println("|---");

        } else if (a.getBateria() <= 5000) {
            System.out.println("||--");
        } else if (a.getBateria() <= 7500) {
            System.out.println("|||-");
        } else if (a.getBateria() <= 10000) {
            System.out.println("||||");
        }
    }

    public void revisandoDispositivo(Armadura a) {
        System.out.println("-----------Inicio sitema deAutoreparacion-----------");
        //Guante izquierdo
        do {
            if (a.getgI().isEstaRoto()) {
                if (Math.floor(Math.random() * 100) < 30) {
                    a.getgI().setEstaDestruido(true);
                    System.out.println("La Guante inquierdo se ha destruido");
                    break;
                } else {
                    System.out.println("Intentando reparar guante izquierdo");
                    randomReparacion(a.getgI());
                }
            }
        } while (a.getgI().isEstaRoto());
        //Guante derecho
        do {
            if (a.getgD().isEstaRoto()) {
                if (Math.floor(Math.random() * 100) < 30) {
                    a.getgD().setEstaDestruido(true);
                    System.out.println("El Guante Derecho se ha destruido");
                    break;
                } else {
                    System.out.println("Intentando reparar guante derecho");
                    randomReparacion(a.getgD());
                }
            }
        } while (a.getgD().isEstaRoto());
        //Bota izquierda
        do {
            if (a.getbI().isEstaRoto()) {
                if (Math.floor(Math.random() * 100) < 30) {
                    a.getbI().setEstaDestruido(true);
                    System.out.println("La Bota Izquierda se ha destruido");
                    break;
                } else {
                    System.out.println("Intentando reparar bota izquierda");
                    randomReparacion(a.getbI());
                }
            }
        } while (a.getbI().isEstaRoto());
        //Bota derecha
        do {
            if (a.getbD().isEstaRoto()) {
                if (Math.floor(Math.random() * 100) < 30) {
                    a.getbD().setEstaDestruido(true);
                    System.out.println("La Bota Derecha se ha destruido");
                    break;
                } else {
                    System.out.println("Intentando reparar bota derecha");
                    randomReparacion(a.getbD());
                }
            }
        } while (a.getbD().isEstaRoto());
        System.out.println("-----------FIN sitema deAutoreparacion-----------");
    }

    public float calcularDistanciaRadar(float x, float y, float z) {
        return (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public void mostrarRadar(ObjetoVolador[] ovnis) {
        boolean marcadorOvniEncontrado = false;

        System.out.println("\n<----------------------------RADAR----------------------------->");
        System.out.println("Referencia: ");
        System.out.println("OO = Objeto no hostil");
        System.out.println("MM = Armadura (eje X=0, Y=0, Z=0)");
        System.out.println("numero = Enemigo (el numero indica la altura (eje Y))");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 10; i > -11; i--) {
            for (int j = -10; j < 11; j++) {
                System.out.print("|");
                if (i == 0 && j == 0) {
                    System.out.print("MM");
                    continue;

                }
                for (ObjetoVolador ovni : ovnis) {
                    if (ovni.getCoordenadaY() == i) {
                        if (ovni.getCoordenadaX() == j) {
                            if (ovni.isHostil()) {
                                if (ovni.getCoordenadaZ() >= 0) {
                                    System.out.print(" " + ovni.getCoordenadaZ());
                                } else {
                                    System.out.print(ovni.getCoordenadaZ());
                                }
                            } else {
                                System.out.print("OO");
                            }
                            marcadorOvniEncontrado = true;
                        }
                    }
                }
                if (!marcadorOvniEncontrado) {
                    System.out.print("  ");
                } else {
                    marcadorOvniEncontrado = false;
                }

            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("DETALLE:");
        for (ObjetoVolador ovni : ovnis) {
            System.out.println(ovni);
        }
        System.out.println("-------------------------------FIN RADAR-------------------------------");
    }

    public void atacar(Armadura a, ObjetoVolador[] ovnis) {

        ArrayList<ObjetoVolador> listaEnemigos = new ArrayList();
        for (ObjetoVolador ovni : ovnis) {
            if (ovni.isHostil()) {
                float distancia = calcularDistanciaRadar(ovni.getCoordenadaX(), ovni.getCoordenadaY(), ovni.getCoordenadaZ());
                if (distancia <= 10) {
                    listaEnemigos.add(ovni);
                }

//                float distancia = calcularDistanciaRadar(ovni.getCoordenadaX(), ovni.getCoordenadaY(), ovni.getCoordenadaZ());
//               
//                    contador++;
//                    System.out.println("OBJETIVO: " + contador + " distancia->" + distancia);
//                    disparar(a);
//                    ovni.setHostil(false);
//                    do {
//                        
//                    } while (true);
//                    
//                }
            }
        }

        while (true) {
            int contador = 0;
            Iterator<ObjetoVolador> it = listaEnemigos.iterator();
            if (listaEnemigos.isEmpty()) {
                break;
            }
            while (it.hasNext()) {
                ObjetoVolador enemigo = it.next();
                contador++;
                float distancia = calcularDistanciaRadar(enemigo.getCoordenadaX(), enemigo.getCoordenadaY(), enemigo.getCoordenadaZ());
                System.out.println("OBJETIVO: " + contador + " distancia->" + distancia);
                disparar(a);
                enemigo.setVida(enemigo.getVida() - (10 - distancia));

                if (enemigo.getVida() <= 0) {
                    enemigo.setHostil(false);
                    it.remove();
                }
            }
        }
    }
    
    public void maniobrasEvasivas(Armadura a){
        if (true) {
            
        }
    }
}
