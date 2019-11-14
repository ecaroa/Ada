package ar.com.ada.api.inmobiliaria.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.excepciones.UsuarioNoAutorizadoException;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService us;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {

            List<Usuario> usuarios = us.listarUsuarios();

            return usuarios;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");

    }

}