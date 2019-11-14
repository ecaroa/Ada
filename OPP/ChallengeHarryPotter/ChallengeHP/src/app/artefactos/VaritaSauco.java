package app.artefactos;

import app.interfaces.IReliquiaMuerte;

/**
 * VaritaSauco
 */
public class VaritaSauco extends Varita implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    public VaritaSauco() {
        this.poder = null;
        this.amplificadorDanio = 0.6;
        this.amplificadorSalud = 0;
        this.nombre = "Varita de Sauco";
    }

    
}