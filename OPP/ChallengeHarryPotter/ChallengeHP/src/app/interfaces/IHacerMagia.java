package app.interfaces;

import java.util.List;

import app.artefactos.Artefacto;
import app.hechizos.Hechizo;
import app.hechizos.Poder;
import app.personajes.Personaje;

/**
 * IHacerMagia
 */
public interface IHacerMagia {

    void atacar(Personaje enemigo, Hechizo hechizo);
    void atacar(Personaje p, String nombreHechizo);
    Poder getPoderInicial();
    void setPoderInicial(Poder poderInicial);
    void aprender(Hechizo h);
    List<Artefacto> getArtefactos();
    Hechizo getHechizo(String nombre);
    Hechizo buscarHechizo(String nombre);
    Artefacto getArtefacto(String nombre);
    void equipar(Artefacto a);
    String toStringFull();
    void listarHechizos();
    void listarArtefactos();
    


}