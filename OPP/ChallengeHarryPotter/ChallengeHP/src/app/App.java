package app;

import java.util.Scanner;

import app.artefactos.Artefacto;
import app.hechizos.Hechizo;
import app.interfaces.IHacerMagia;
import app.personajes.*;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        JuegoHarryPotter.InicializarJuego();

        Personaje p1 = new Personaje();
        p1 = configurarPersonaje1();
        Personaje p2 = new Personaje();
        p2 = configurarPersonaje2(p1);
        pelear(p1, p2);

    }

    public static void pelear(Personaje p1, Personaje p2) {
        while (p1.estaVivo() && p2.estaVivo()) {
            if (!p1.estaVivo()) {
                System.out.println("El personaje " + p1.nombre + " no puede atacar porque esta muerto.");
            } else {
                if (p1 instanceof IHacerMagia) {
                    elegirHechizoYAtacar(p1, p2);
                } else {
                    System.out.println("El personaje " + p1.nombre + " no puede atacar porque no hace magia.");
                }
            }
            if (!p2.estaVivo()) {
                System.out.println("El personaje " + p2.nombre + " no puede atacar porque esta muerto.");
            } else {
                if (p2 instanceof IHacerMagia) {
                    if (p2.estaVivo) {
                        elegirHechizoYAtacar(p2, p1);
                    } else {
                        System.out.println("El personaje " + p2.nombre + " no puede atacar porque esta muerto.");
                    }
                } else {
                    System.out.println("El personaje " + p2.nombre + " no puede atacar porque no hace magia.");
                }
            }

        }

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }

    public static Personaje configurarPersonaje1() {
        System.out.println("Elegi el personaje 1 ingresando su Nombre.");
        JuegoHarryPotter.listarPersonajes();
        String p1 = Teclado.nextLine();
        Personaje personaje1 = JuegoHarryPotter.buscarPersonaje(p1);

        siHaceMagiaConfig(personaje1);

        if (personaje1 == null) {
            System.out.println("\nEl personaje no existe. Por favor, intente de nuevo.\n");
            configurarPersonaje1();
        }
        return personaje1;
    }

    public static Personaje configurarPersonaje2(Personaje personaje1) {
        System.out.println("\nElegi el personaje 2 ingresando su Nombre.");
        JuegoHarryPotter.listarPersonajes();
        String p2 = Teclado.nextLine();
        Personaje personaje2 = JuegoHarryPotter.buscarPersonaje(p2);
        if (JuegoHarryPotter.buscarPersonaje(p2) != null) {
            if (!personaje2.equals(personaje1)) {

                siHaceMagiaConfig(personaje2);

                if (personaje2 == null) {
                    System.out.println("\nEl personaje no existe. Por favor, intente de nuevo.\n");
                    configurarPersonaje2(personaje1);
                }
                return personaje2;
            } else {
                System.out.println("\n" + personaje1.nombre + " ya fue seleccionado. Por favor, elija otro.\n");
                configurarPersonaje2(personaje1);
            }
        } else {
            System.out.println("El personaje no existe. Por favor, intente de nuevo.");
            configurarPersonaje2(personaje1);
        }
        return null;
    }

    public static void siHaceMagiaConfig(Personaje p) {
        if (p instanceof IHacerMagia) {
            IHacerMagia m = (IHacerMagia) p;
            System.out.println("\nElegi que hechizos aprender ingresando su Nombre. Para terminar, ingresa 0.\n");
            JuegoHarryPotter.listarHechizos();
            String hechizo = Teclado.nextLine();
            Hechizo h = new Hechizo();
            while (!hechizo.equals("0")) {
                h = JuegoHarryPotter.buscarHechizo(hechizo);
                if (JuegoHarryPotter.buscarHechizo(hechizo) != null) {
                    if (m.getHechizo(h.nombre) == null) {
                        m.aprender(h);
                        System.out.println("\n\t\"El hechizo " + h.nombre + " fue aprendido!\"");
                    } else {
                        System.out.println("\nEse hechizo ya fue aprendido.");
                    }
                } else {
                    System.out.println("\nEse hechizo no existe, elija otro.");
                }
                System.out.println("\nElegi que hechizos aprender ingresando su Nombre. Para terminar, ingresa 0.\n");
                JuegoHarryPotter.listarHechizos();
                hechizo = Teclado.nextLine();
                h = new Hechizo();
            }

            System.out.println("\nElegi que artefactos equipar ingresando su Nombre. Para terminar, ingresa 0.\n");
            JuegoHarryPotter.listarArtefactos();
            String a1 = Teclado.nextLine();
            Artefacto a = new Artefacto();
            while (!a1.equals("0")) {
                a = JuegoHarryPotter.buscarArtefacto(a1);
                if (JuegoHarryPotter.buscarArtefacto(a1) != null) {
                    if (m.getArtefacto(a.nombre) == null) {
                        m.equipar(a);
                        System.out.println("\n\t\"El artefacto " + a.nombre + " fue equipado!\"\n");
                    } else {
                        System.out.println("\nEse artefacto ya fue equipado.\n");
                    }
                } else {
                    System.out.println("\nEse Artefacto no existe, elija otro.\n");
                }
                System.out.println("\nElegi que artefactos equipar ingresando su Nombre. Para terminar, ingresa 0.\n");
                JuegoHarryPotter.listarArtefactos();
                a1 = Teclado.nextLine();
                a = new Artefacto();
            }
            System.out.println(m.toStringFull());
            p = (Personaje) m;
        }
    }

    public static void elegirHechizoYAtacar(Personaje atacante, Personaje atacado) {
        IHacerMagia p = (IHacerMagia) atacante;
        System.out.println("\nElegi con que hechizo ataca " + atacante.nombre + " ingresando su nombre");
        p.listarHechizos();
        String h1 = Teclado.nextLine();
        while (!h1.equals("0")) {
            if (p.getHechizo(h1) != null) {
                System.out.println(
                        atacante.nombre + " ataca a " + atacado.nombre + " con el hechizo " + p.getHechizo(h1).nombre);
                p.atacar(atacado, p.getHechizo(h1)); // aca el parametro de atacar() es objeto.
                break;
            } else {
                System.out.println("\nEse hechizo no existe, elija otro.");
            }
            System.out.println("Elegi con que hechizo ataca " + atacante.nombre + " ingresando su nombre.");
            p.listarHechizos();
            h1 = Teclado.nextLine();
        }
    }
}