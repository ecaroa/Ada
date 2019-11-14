package app;

import app.interfaces.IEsMagico;

/**
 * Escoba
 */
public class Escoba extends Transporte implements IEsMagico{

    public String nombre;

    public Escoba(String string) {
	}

	@Override
    public boolean esInvisibleAMuggles() {
        return false;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

    
}