package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.repo.AvisoRepository;

/**
 * AvisoService
 */
@Service
public class AvisoService {

    @Autowired
    AvisoRepository repo;
    @Autowired
    InmuebleService is;
    @Autowired
    LocadorService ls;
    @Autowired
    AlquilerService as;
    @Autowired
    VentaService vs;

    public void grabar(Aviso aviso) {
        this.repo.save(aviso);
    }

    public Aviso buscarPorId(int id) {
        Optional<Aviso> a = repo.findById(id);

        if (a.isPresent())
            return a.get();
        return null;

    }

    public Aviso crearAvisoAlquiler(int inmuebleId, String moneda, int plazoMeses, String tipoAlquiler, double valor) {
        Aviso a = new Aviso();
        Inmueble i = is.buscarPorId(inmuebleId);
        a.setInmueble(i);
        repo.save(a);
        Alquiler al = as.crearAlquiler(moneda, plazoMeses, tipoAlquiler, valor);
        al.setAviso(a);
        //a.setOperacionYTipo(al);
        a.setTipoOperacion(al.toString());
        a.setOperacion(al);
        as.grabar(al);
        repo.save(a);

        return a;

    }

    public Aviso crearAvisoVenta(int inmuebleId, String moneda, double valor) {
        Aviso a = new Aviso();
        Inmueble i = is.buscarPorId(inmuebleId);
        a.setInmueble(i);
        repo.save(a);
        Venta v = vs.crearVenta(moneda, valor);
        v.setAviso(a);
        //a.setOperacionYTipo(v);
        a.setTipoOperacion(v.toString());
        a.setOperacion(v);
        vs.grabar(v);
        repo.save(a);

        return a;
    }


    public List<Aviso> listarAvisos() {
        return repo.findAll();
    }

    public void eliminarAviso(int avisoId){ //conviene tenerlo así? o mejor baja lógica?
        Aviso a = this.buscarPorId(avisoId);
        repo.delete(a);
    }

}
