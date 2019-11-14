package app;

import app.interfaces.IEsMagico;

/**
 * Transporte
 */
public class Transporte implements IEsMagico{

    @Override
    public boolean esInvisibleAMuggles() {
        return false;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

    
}