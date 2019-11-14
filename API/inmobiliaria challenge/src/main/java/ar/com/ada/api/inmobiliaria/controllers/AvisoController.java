package ar.com.ada.api.inmobiliaria.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.excepciones.UsuarioNoAutorizadoException;
import ar.com.ada.api.inmobiliaria.models.request.AvisoAlquilerRequest;
import ar.com.ada.api.inmobiliaria.models.request.AvisoVentaRequest;
import ar.com.ada.api.inmobiliaria.models.response.AvisoAlquilerResponse;
import ar.com.ada.api.inmobiliaria.models.response.AvisoVentaResponse;

import ar.com.ada.api.inmobiliaria.services.AlquilerService;
import ar.com.ada.api.inmobiliaria.services.AvisoService;
import ar.com.ada.api.inmobiliaria.services.InmuebleService;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;
import ar.com.ada.api.inmobiliaria.services.VentaService;

/**
 * AvisoController
 */
@RestController
public class AvisoController {

    @Autowired
    AvisoService as;
    @Autowired
    AlquilerService als;
    @Autowired
    VentaService vs;
    @Autowired
    InmuebleService is;
    @Autowired
    UsuarioService us;

    @PostMapping("/avisos/alquileres") // funciona!
    public AvisoAlquilerResponse postAvisoAlquiler(@RequestBody AvisoAlquilerRequest req, Principal principal)
            throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            AvisoAlquilerResponse r = new AvisoAlquilerResponse();

            Aviso a = as.crearAvisoAlquiler(req.inmuebleId, req.moneda, req.plazoMeses, req.tipoAlquiler, req.valor);

            r.isOk = true;
            r.message = "Aviso de Alquiler creado con éxito.";
            r.avisoid = a.getAvisoId();
            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

    @PostMapping("/avisos/ventas") // funciona!
    public AvisoVentaResponse postAvisoVenta(@RequestBody AvisoVentaRequest req, Principal principal)
            throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            AvisoVentaResponse r = new AvisoVentaResponse();

            Aviso a = as.crearAvisoVenta(req.inmuebleId, req.moneda, req.valor);

            r.isOk = true;
            r.message = "Aviso de Venta creado con éxito.";
            r.avisoid = a.getAvisoId();
            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

    @GetMapping("/avisos") // No funciona :(
    public List<Aviso> getAvisos() {
        List<Aviso> av = as.listarAvisos();

        return av;
    }

    /**
     * No funciona xq hay un problema con el Inmueble Id 1 More than one row with
     * the given identifier was found: 1, for class:
     * ar.com.ada.api.inmobiliaria.entities.Inmueble; nested exception is
     * org.hibernate.HibernateException: More than one row with the given identifier
     * was found: 1, for class: ar.com.ada.api.inmobiliaria.entities.Inmueble
     */

    @GetMapping("/avisos/{id}") // No funciona :(
    public Aviso getAvisoById(@PathVariable int id) {
        Aviso av = as.buscarPorId(id);

        return av;
    }

    /**
     * DICE PARA AVISOS IDs 1 Y 2: More than one row with the given identifier was
     * found: 1, for class: ar.com.ada.api.inmobiliaria.entities.Aviso; nested
     * exception is org.hibernate.HibernateException: More than one row with the
     * given identifier was found: 1, for class:
     * ar.com.ada.api.inmobiliaria.entities.Aviso
     */

    @PutMapping("/avisos/alquileres/{id}") // funciona
    public AvisoAlquilerResponse actualizarAvisoAlquiler(@PathVariable int id, @RequestBody AvisoAlquilerRequest req,
            Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            AvisoAlquilerResponse r = new AvisoAlquilerResponse();

            Aviso a = as.buscarPorId(id);
            a.setInmueble(is.buscarPorId(req.inmuebleId));
            Alquiler al = a.getAlquiler();
            al.setMoneda(req.moneda);
            al.setPlazoMeses(req.plazoMeses);
            al.setTipoAlquiler(req.tipoAlquiler);
            al.setValor(req.valor);
            als.grabar(al);
            a.setOperacionYTipo(al);
            as.grabar(a);

            r.isOk = true;
            r.message = "Aviso actualizado con éxito.";
            r.avisoid = a.getAvisoId();
            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

    @PutMapping("/avisos/ventas/{id}") // funciona
    public AvisoVentaResponse actualizarAvisoVenta(@PathVariable int id, @RequestBody AvisoVentaRequest req,
            Principal principal) throws UsuarioNoAutorizadoException {
        Usuario u = us.buscarPorUsername(principal.getName());

        if (u.getTipoUsuario().equals("Inmobiliaria")) {
            AvisoVentaResponse r = new AvisoVentaResponse();

            Aviso a = as.buscarPorId(id);
            a.setInmueble(is.buscarPorId(req.inmuebleId));
            Venta v = a.getVenta();
            v.setMoneda(req.moneda);
            v.setValor(req.valor);
            vs.grabar(v);
            as.grabar(a);

            r.isOk = true;
            r.message = "Aviso actualizado con éxito.";
            r.avisoid = a.getAvisoId();
            return r;
        }
        throw new UsuarioNoAutorizadoException("El usuario no posee autorización para realizar esta acción.");
    }

    /*
     * @GetMapping("/avisos/alquileres") /** funciona! public List<Alquiler>
     * getAlquileres() { List<Alquiler> al = als.listarAlquileres();
     * 
     * return al; }
     * 
     * @GetMapping("/avisos/alquileres/{id}")
     * 
     * public Alquiler getAlquilerById(@PathVariable int id) { Alquiler al =
     * als.buscarPorId(id);
     * 
     * return al; }
     * 
     * @GetMapping("/avisos/ventas") /** funciona!
     * 
     * public List<Venta> getVentas() { List<Venta> v = vs.listarVentas();
     * 
     * return v; }
     * 
     * @GetMapping("/avisos/ventas/{id}")
     * 
     * public Venta getVentaById(@PathVariable int id) { Venta v =
     * vs.buscarPorId(id);
     * 
     * return v; }
     */

    /**
     * usamos las querys para filtrar por tipo de operacion
     */

}