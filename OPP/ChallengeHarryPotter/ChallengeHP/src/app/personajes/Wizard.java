package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.Escoba;
import app.artefactos.Artefacto;
import app.hechizos.Hechizo;
import app.hechizos.Poder;
import app.interfaces.IHacerMagia;

/**
 * Wizard
 */
public class Wizard extends Persona implements IHacerMagia {

    public Escoba escoba;
    public Poder poderInicial;
    public List<Artefacto> artefactos = new ArrayList<Artefacto>();
    public List<Hechizo> hechizos = new ArrayList<Hechizo>();
    public boolean magoOscuro;
    public int energiaMagica;

    @Override
    public Poder getPoderInicial() {
        return poderInicial;
    }

    @Override
    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    @Override
    public void aprender(Hechizo h) {
        this.hechizos.add(h);
    }

    @Override
    public Hechizo getHechizo(String n) {

        for (Hechizo h : this.hechizos) {
            if (h.nombre.equals(n)) {
                return h;
            }
        }
        return null;
    }

    // Este devuelve print si no existe:
    @Override
    public Hechizo buscarHechizo(String n) {
        for (int i = 0; i < this.hechizos.size(); i++) {
            if (this.hechizos.get(i).nombre.equals(n)) {
                return this.hechizos.get(i);
            }
        }
        System.out.println("El hechizo no existe.");
        return null;
    }

    @Override
    public void equipar(Artefacto a) {

        this.artefactos.add(a);
    }

    @Override
    public List<Artefacto> getArtefactos() {
        return artefactos;
    }

    @Override
    public Artefacto getArtefacto(String n) {

        for (Artefacto a : this.artefactos) {
            if (a.nombre.equals(n)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void atacar(Personaje enemigo, Hechizo hechizo) {
        int s = enemigo.salud;
        double d = hechizo.nivelDanio;
        double danioAdicional = 0;
        double curacion = 0;
        double danioTotal;
        double curacionTotal;
        IHacerMagia e;

        if (this.estaVivo && enemigo.estaVivo) {
            
        if (this.energiaMagica >= hechizo.nivelEnergia) {
            for (int i = 0; i < artefactos.size(); i++) {
                danioAdicional += (d * this.artefactos.get(i).amplificadorDanio);
            }

            if (enemigo instanceof IHacerMagia) {
                e = (IHacerMagia) enemigo;
                for (int i = 0; i < e.getArtefactos().size(); i++) {
                    curacion += (s * e.getArtefactos().get(i).amplificadorSalud);
                }
            }

            this.energiaMagica -= hechizo.nivelEnergia;

            danioTotal = d + danioAdicional;

            if (hechizo.esOscuro) {
                this.magoOscuro = true;
            }

            if (this.magoOscuro) {
                danioTotal *= 2;
            }

            curacionTotal = s + curacion;

            enemigo.salud = (int) (curacionTotal - danioTotal);

            if (enemigo.salud > 100) {
                enemigo.salud = 100;
            }
            if (enemigo.salud < 1) {
                enemigo.estaVivo = false;
                System.out.println(enemigo.nombre + " esta MUERTOO!");
                enemigo.salud = 0;
            }
            if (enemigo.estaVivo) {
                System.out.println(enemigo.nombre + " tiene " + enemigo.salud + " puntos de salud.");
            }

        } else {
            System.out.println(this.nombre + " no tiene energia magica suficiente para realizar este hechizo");
        }
    } else {
            System.out.println(this.nombre + " no puede atacar porque esta muerto.");
        }
    }

    @Override
    public void atacar(Personaje enemigo, String nombreHechizo) {

        Hechizo h = getHechizo(nombreHechizo);
        int s = enemigo.salud;
        double d = h.nivelDanio;
        double danioAdicional = 0;
        double curacion = 0;
        double danioTotal;
        double curacionTotal;
        IHacerMagia e;

        if (this.estaVivo && enemigo.estaVivo) {

            if (this.energiaMagica >= h.nivelEnergia) {
                for (int i = 0; i < artefactos.size(); i++) {
                    danioAdicional += (d * this.artefactos.get(i).amplificadorDanio);
                }

                if (enemigo instanceof IHacerMagia) {
                    e = (IHacerMagia) enemigo;
                    for (int i = 0; i < e.getArtefactos().size(); i++) {
                        curacion += (s * e.getArtefactos().get(i).amplificadorSalud);
                    }
                }

                this.energiaMagica -= h.nivelEnergia;

                danioTotal = d + danioAdicional;

                if (h.esOscuro) {
                    this.magoOscuro = true;
                }

                if (this.magoOscuro) {
                    danioTotal *= 2;
                }

                curacionTotal = s + curacion;

                enemigo.salud = (int) (curacionTotal - danioTotal);

                if (enemigo.salud > 100) {
                    enemigo.salud = 100;
                }
                if (enemigo.salud < 1) {
                    enemigo.estaVivo = false;
                    System.out.println(enemigo.nombre + " esta MUERTOO!");
                    enemigo.salud = 0;
                }
                if (enemigo.estaVivo) {
                    System.out.println(enemigo.nombre + " tiene " + enemigo.salud + " puntos de salud.");
                }
            } else {
                System.out.println(this.nombre + " no tiene energia magica suficiente para realizar este hechizo");
            }
        } else {
            System.out.println(this.nombre + " no puede atacar porque esta muerto.");
        }
    }

    @Override
    public String toStringFull() {
        return "\nEl personaje " + this.nombre + " esta vivo? " + this.estaVivo + ".\n\t-Tiene " + this.salud
                + " puntos de salud.\n\t-Tiene equipados los artefactos " + artefactos + ".\n\t-Le quedan " + energiaMagica
                + " puntos de Energia Magica.\n\t-Sabe los hechizos " + hechizos + ".\n\t-Es mago oscuro? " + magoOscuro
                + ".";
    }

    @Override
    public void listarHechizos() {
        for (int i = 0; i < this.hechizos.size(); i++) {
            System.out.println(this.hechizos.get(i));
        }

    }

    @Override
    public void listarArtefactos() {
        for (int i = 0; i < this.artefactos.size(); i++) {
            System.out.println(this.artefactos.get(i));
        }

    }
}