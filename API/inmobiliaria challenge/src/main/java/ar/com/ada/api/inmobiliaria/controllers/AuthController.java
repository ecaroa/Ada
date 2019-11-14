package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.excepciones.TipoUsuarioException;
import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;
import ar.com.ada.api.inmobiliaria.models.request.InmobiliariaRequest;
import ar.com.ada.api.inmobiliaria.models.request.LocatarioRequest;
import ar.com.ada.api.inmobiliaria.models.request.LoginRequest;
import ar.com.ada.api.inmobiliaria.models.request.RegistrationRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmobiliariaResponse;
import ar.com.ada.api.inmobiliaria.models.response.JwtResponse;
import ar.com.ada.api.inmobiliaria.models.response.LocatarioResponse;
import ar.com.ada.api.inmobiliaria.models.response.RegistrationResponse;
import ar.com.ada.api.inmobiliaria.security.JWTTokenUtil;
import ar.com.ada.api.inmobiliaria.services.InmobiliariaService;
import ar.com.ada.api.inmobiliaria.services.JWTUserDetailsService;
import ar.com.ada.api.inmobiliaria.services.LocatarioService;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InmobiliariaService is;

    @Autowired
    LocatarioService ls;

    /*
     * @Autowired private AuthenticationManager authenticationManager;
     */
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;
    
    @PostMapping("/auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) throws TipoUsuarioException {
        RegistrationResponse r = new RegistrationResponse();

        ITieneUsuario tieneUsuario;

        if (req.tipoUsuario.equals("Inmobiliaria")) {
            tieneUsuario = is.crearInmobiliaria(req.cuit, req.nombre, req.email, req.password);
        } else {
            if (req.tipoUsuario.equals("Locatario")) {
                tieneUsuario = ls.crearLocatario(req.nombre, req.dni, req.edad, req.email, req.password);
            } else {
                throw new TipoUsuarioException("El tipo de usuario no existe");
            }
        }

        r.isOk = true;
        r.message = "Usuario tipo " + req.tipoUsuario + " registrado con éxito.";
        r.usuarioId = tieneUsuario.getUsuario().getUsuarioId();
        r.tipoId = tieneUsuario.getId();
        return r;
    }

    @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}