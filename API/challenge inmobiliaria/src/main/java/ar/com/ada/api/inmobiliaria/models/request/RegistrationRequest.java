package ar.com.ada.api.inmobiliaria.models.request;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

/**
 * RegistrationRequest
 */
public class RegistrationRequest {

	public String tipoUsuario;
	public String cuit;
    public String nombre;
    public String email;
    public String password;
    public String dni;
    public int edad;
    
}