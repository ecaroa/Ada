package ar.com.ada.api.inmobiliaria.excepciones;

/**
 * UsuarioNoAutorizadoException
 */
public class UsuarioNoAutorizadoException extends Exception {

    public UsuarioNoAutorizadoException(String mensaje){
        super(mensaje);
    }
}