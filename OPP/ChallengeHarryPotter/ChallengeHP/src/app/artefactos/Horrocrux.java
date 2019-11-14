package app.artefactos;

import app.interfaces.IReliquiaMuerte;

/**
 * Horrocrux
 */
public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    public Horrocrux() {
        this.poder = null;
        this.amplificadorSalud = 1;
        this.amplificadorDanio = 0;
        this.nombre = "Horrocrux";
    }

    @Override
    public boolean esReliquiaMuerte() {
        return false;
    }

    
}