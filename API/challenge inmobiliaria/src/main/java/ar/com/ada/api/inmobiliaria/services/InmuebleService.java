package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.entities.Reserva;
import ar.com.ada.api.inmobiliaria.repo.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {
    @Autowired
    InmuebleRepository repo;

    @Autowired
    InmobiliariaService is;

    @Autowired
    LocadorService ls;

    @Autowired
    ReservaService rs;

    @Autowired
    AvisoService as;

    @Autowired
    LocatarioService locats;

    public Inmueble crearInmueble(int locadorId, String tipoInmueble, int cantAmb, String direccion, int superficie,
            int cantDormitorio, char aptoProf, String disposicion, int cantBanios, int antiguedadAnios) {

        Locador loc = ls.buscarPorId(locadorId);
        Inmueble i = new Inmueble();

        i.setTipoInmueble(tipoInmueble);
        i.setCantAmb(cantAmb);
        i.setDireccion(direccion);
        i.setSuperficie(superficie);
        i.setCantDormitorio(cantDormitorio);
        i.setAptoProf(aptoProf);
        i.setDisposicion(disposicion);
        i.setCantBanios(cantBanios);
        i.setAntiguedadAnios(antiguedadAnios);

        loc.agregarInmueble(i);
        repo.save(i);
        return i;

    }

    public List<Inmueble> getInmuebles() {
        return repo.findAll();

    }

    public Inmueble buscarPorId(int id) {

        Optional<Inmueble> in = repo.findById(id);

        if (in.isPresent())
            return in.get();
        return null;
    }

    public Inmueble reservarInmueble(int avisoId, int locatarioId) {
        Aviso a = as.buscarPorId(avisoId);
        Inmueble i = buscarPorId(a.getInmueble().getInmuebleId());
        Locatario l = locats.buscarPorId(locatarioId); //no encuentra el locatario, no entiendo por qué si en Get Locatario By Id funciona
        Reserva r = rs.crearReserva(a, i, l);

        i.setReserva(r);
        i.setReservado('s');

        repo.save(i);
        return i;
    }

    public Inmueble modificarReserva(int avisoId) {
        Aviso a = as.buscarPorId(avisoId);
        Inmueble i = buscarPorId(a.getInmueble().getInmuebleId());

        i.setReservado('n');

        repo.save(i);
        return i;
    }

}