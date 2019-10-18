package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) {
        RegistrationResponse r = new RegistrationResponse();
        //aca creamos la persona y el usuario a travez del service.

        /*Persona persona = new Persona();
        persona.setNombre(req.nombre);
        persona.setDni(req.dni);
        persona.setEdad(req.edad);
        persona.setEmail(req.email);   */



        r.isOk = true;
        r.message = "Te registraste con exitoooo";
        return r;

    }

}