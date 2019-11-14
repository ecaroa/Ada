package ar.com.ada.api.inmobiliaria.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.excepciones.UsuarioNoAutorizadoException;
import ar.com.ada.api.inmobiliaria.models.response.LocatarioResponse;
import ar.com.ada.api.inmobiliaria.services.LocatarioService;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * LocatarioController
 */
@RestController
public class LocatarioController {

    @Autowired
    LocatarioService ls;
    @Autowired
    UsuarioService us;

    @GetMapping("/locatarios") // funciona!
    public List<Locatario> getLocatarios(Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            List<Locatario> locatarios = ls.listarLocatariosYUsuarios();

            return locatarios;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");

    }

    @GetMapping("/locatarios/{id}") // funciona!
    public Locatario getLocatarioById(@PathVariable int id, Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            Locatario l = ls.buscarPorId(id);

            return l;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

    @DeleteMapping("/locatarios/{id}")
    public LocatarioResponse bajaLocatario(@PathVariable int id, Principal principal)
            throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            LocatarioResponse r = new LocatarioResponse();

            Locatario l = ls.bajaLocatario(id);

            r.isOk = true;
            r.message = "Locatario " + l.getNombre() + " dado de baja.";
            r.locatarioId = l.getId();

            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

}