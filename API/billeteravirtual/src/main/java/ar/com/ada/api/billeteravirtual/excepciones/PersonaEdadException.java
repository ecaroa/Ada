package ar.com.ada.api.billeteravirtual.excepciones;

import ar.com.ada.api.billeteravirtual.entities.*;

/**
 * PersonaEdadException
 */
public class PersonaEdadException extends PersonaInfoException {

    /**
     *
     */
    private static final long serialVersionUID = 5304194117008334527L;

    public PersonaEdadException(Persona p, String mensaje) {
        super(p, mensaje);
        // TODO Auto-generated constructor stub
    }

    
}