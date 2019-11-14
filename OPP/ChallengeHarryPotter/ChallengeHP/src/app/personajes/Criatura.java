package app.personajes;

import app.interfaces.IEsMagico;

/**
 * Criatura
 */
public class Criatura extends Personaje implements IEsMagico {

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

    public Criatura() {
    }

    
}