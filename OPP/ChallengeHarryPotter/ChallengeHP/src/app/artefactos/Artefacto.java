package app.artefactos;

import app.hechizos.Poder;
import app.interfaces.IEsMagico;

/**
 * Artefacto
 */
public class Artefacto implements IEsMagico {

    public Poder poder;
    public double amplificadorDanio;
    public double amplificadorSalud;
	public String nombre;

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return true;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

    public double getAmplificadorDanio() {
        return amplificadorDanio;
    }

    public void setAmplificadorDanio(double amplificadorDanio) {
        this.amplificadorDanio = amplificadorDanio;
    }

    public double getAmplificadorSalud() {
        return amplificadorSalud;
    }

    public void setAmplificadorSalud(double amplificadorSalud) {
        this.amplificadorSalud = amplificadorSalud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Artefacto: \"" + nombre + "\"\n\t Amplificador de Danio: " + amplificadorDanio
                + ".\n\t Amplificador de Salud: " + amplificadorSalud + ".\n";
    }


   
}