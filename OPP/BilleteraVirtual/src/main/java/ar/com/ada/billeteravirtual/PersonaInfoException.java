package ar.com.ada.billeteravirtual;

/**
 * PersonaInfoException
 */
public class PersonaInfoException extends Exception {

    private Persona persona;
    PersonaInfoException(Persona p, String mensaje){
        super(p.getNombre()+":"+mensaje);
        this.persona = p;
    }

    
}