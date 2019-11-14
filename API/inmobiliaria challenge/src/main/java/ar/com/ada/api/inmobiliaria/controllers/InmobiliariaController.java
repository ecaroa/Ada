package ar.com.ada.api.inmobiliaria.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.excepciones.UsuarioNoAutorizadoException;
import ar.com.ada.api.inmobiliaria.models.request.LocadorRequest;
import ar.com.ada.api.inmobiliaria.models.response.LocadorResponse;
import ar.com.ada.api.inmobiliaria.services.InmobiliariaService;
import ar.com.ada.api.inmobiliaria.services.LocadorService;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService is;
    @Autowired
    LocadorService ls;
    @Autowired
    UsuarioService us;

    @PostMapping("/locadores") // funciona!
    public LocadorResponse postRegisterLocador(Principal principal, @RequestBody LocadorRequest req)
            throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            LocadorResponse r = new LocadorResponse();
            Locador l = is.crearLocador(req.nombre, req.dni, req.edad, req.email);

            r.isOk = true;
            r.message = "Locador generado con éxito.";
            r.locadorId = l.getLocadorId();
            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");

    }

    @GetMapping("/locadores") // funciona!
    public List<Locador> getLocadores(Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            List<Locador> locadores = ls.listarLocadores();

            return locadores;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");

    }

    @GetMapping("/locadores/{id}") // funciona!
    public Locador getLocador(@PathVariable int id, Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            Locador l = ls.buscarPorId(id);

            return l;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");

    }

}