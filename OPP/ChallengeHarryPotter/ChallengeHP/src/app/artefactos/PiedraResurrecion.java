package app.artefactos;

import app.interfaces.IReliquiaMuerte;

/**
 * PiedraResurrecion
 */
public class PiedraResurrecion extends Artefacto implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    public PiedraResurrecion() {
        this.poder = null;
        this.amplificadorDanio = 0;
        this.amplificadorSalud = 1;
        this.nombre = "Piedra Resurrecion";
    }
    

    
}