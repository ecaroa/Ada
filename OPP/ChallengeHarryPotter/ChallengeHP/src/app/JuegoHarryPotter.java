package app;

import java.util.ArrayList;
import java.util.List;

import app.artefactos.*;
import app.hechizos.*;
import app.personajes.*;

/**
 * JuegoHarryPotter
 */
public class JuegoHarryPotter {

    public static List<Personaje> Personajes = new ArrayList<Personaje>();
    public static List<Hechizo> Hechizos = new ArrayList<Hechizo>();
    public static List<Artefacto> Artefactos = new ArrayList<Artefacto>();

    public static void InicializarJuego() {
        agregarPersonajes();
        agregarHechizos();
        agregarArtefactos();
    }

    public static void agregarPersonajes() {
        Wizard harry = new Wizard();
        harry.nombre = "Harry Potter";
        harry.salud = 100;
        harry.estaVivo = true;
        harry.edad = 30;
        harry.energiaMagica = 1000;
        Poder parsel = new Parseltongue();
        harry.setPoderInicial(parsel);

        JuegoHarryPotter.Personajes.add(harry);

        Elfo dobby = new Elfo();
        dobby.nombre = "Dobby";
        dobby.salud = 100;
        dobby.estaVivo = true;
        dobby.edad = 45;

        JuegoHarryPotter.Personajes.add(dobby);

        Elfo kreacher = new Elfo();
        kreacher.nombre = "Kreacher";
        kreacher.salud = 100;
        kreacher.estaVivo = true;
        kreacher.edad = 55;

        JuegoHarryPotter.Personajes.add(kreacher);

        Wizard snape = new Wizard();
        snape.nombre = "Severus Snape";
        snape.salud = 100;
        snape.estaVivo = true;
        snape.edad = 65;
        snape.energiaMagica = 1000;

        JuegoHarryPotter.Personajes.add(snape);

        Wizard albus = new Wizard();
        albus.nombre = "Albus Dumbledore";
        albus.salud = 100;
        albus.estaVivo = true;
        albus.edad = 180;
        albus.energiaMagica = 5000;

        JuegoHarryPotter.Personajes.add(albus);

        Muggle petunia = new Muggle();
        petunia.nombre = "Petunia Dursley";
        petunia.salud = 100;
        petunia.estaVivo = true;
        petunia.edad = 65;

        JuegoHarryPotter.Personajes.add(petunia);

    }

    public static void agregarHechizos() {

        Hechizo ava = new AvadaKedavra();
        JuegoHarryPotter.Hechizos.add(ava);
        Hechizo ci = new CaveInimicum();
        JuegoHarryPotter.Hechizos.add(ci);
        Hechizo pe = new PetrificusTotalus();
        JuegoHarryPotter.Hechizos.add(pe);
        Hechizo pro = new Protego();
        JuegoHarryPotter.Hechizos.add(pro);
        Hechizo re = new Reparifors();
        JuegoHarryPotter.Hechizos.add(re);
        Hechizo rs = new RictusSempra();
        JuegoHarryPotter.Hechizos.add(rs);
        Hechizo se = new Sectumsempra();
        JuegoHarryPotter.Hechizos.add(se);
        Hechizo vs = new VulneraSanentur();
        JuegoHarryPotter.Hechizos.add(vs);
        Hechizo wl = new WingardiumLeviosa();
        JuegoHarryPotter.Hechizos.add(wl);

    }

    public static void agregarArtefactos() {
        Artefacto capa = new CapaInvisibilidad();
        JuegoHarryPotter.Artefactos.add(capa);
        Artefacto horro = new Horrocrux();
        JuegoHarryPotter.Artefactos.add(horro);
        Artefacto piedraR = new PiedraResurrecion();
        JuegoHarryPotter.Artefactos.add(piedraR);
        Artefacto varita = new Varita();
        JuegoHarryPotter.Artefactos.add(varita);
        Artefacto sauco = new VaritaSauco();
        JuegoHarryPotter.Artefactos.add(sauco);
    }

    public static void listarPersonajes() {
        for (int i = 0; i < JuegoHarryPotter.Personajes.size(); i++) {
            Personaje p = JuegoHarryPotter.Personajes.get(i);
            System.out.println(p.toStringNombre());
        }
    }

    public static void listarHechizos() {
        for (int i = 0; i < JuegoHarryPotter.Hechizos.size(); i++) {
            System.out.println(JuegoHarryPotter.Hechizos.get(i));
        }
    }

    public static void listarArtefactos() {
        for (int i = 0; i < JuegoHarryPotter.Artefactos.size(); i++) {
            System.out.println(JuegoHarryPotter.Artefactos.get(i));
        }
    }

    public static Personaje buscarPersonaje(String n) {
        for (Personaje p : JuegoHarryPotter.Personajes) {
            if (n.equals(p.nombre)) {
                return p;
            }
        }
        return null;
    }

    public static Hechizo buscarHechizo(String n){
        for (Hechizo h : JuegoHarryPotter.Hechizos) {
            if (n.equals(h.nombre)) {
                return h;
            }
        }
        return null;
    }
    
    public static Artefacto buscarArtefacto(String n){
        for (Artefacto a : JuegoHarryPotter.Artefactos) {
            if (n.equals(a.nombre)) {
                return a;
            }
        }
        return null;
    }

}