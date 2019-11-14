package app.artefactos;

import app.hechizos.Invisibilidad;
import app.interfaces.IReliquiaMuerte;

/**
 * CapaInvisibilidad
 */
public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte {

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    public CapaInvisibilidad() {
        this.poder = new Invisibilidad();
        this.amplificadorDanio = 0;
        this.amplificadorSalud = 0.3;
        this.nombre = "Capa Invisibilidad";
    }

    @Override
    public boolean esInvisible() {
        return super.esInvisible();
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return super.esInvisibleAMuggles();
    }


  
    
}