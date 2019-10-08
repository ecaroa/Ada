package ar.com.ada.api.billeteravirtual.excepciones;

import ar.com.ada.api.billeteravirtual.entities.*;

/**
 * PersonaInfoException
 */
public class PersonaInfoException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -4495841187881507662L;
    private Persona persona;
    public PersonaInfoException(Persona p, String mensaje) {
        
        super(p.getNombre()+":"+ mensaje);
        this.persona = p;
    }
}
