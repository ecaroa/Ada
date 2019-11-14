package ar.com.ada.api.inmobiliaria.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.entities.Reserva;
import ar.com.ada.api.inmobiliaria.repo.ReservaRepository;

/**
 * ReservaService
 */
@Service
public class ReservaService {

    @Autowired
    ReservaRepository repo;
    @Autowired
    InmuebleService is;

        public void grabar(Reserva reserva) {
        this.repo.save(reserva);
    }

    public Reserva crearReserva(Aviso aviso, Inmueble inmueble, Locatario locatario) {
        Reserva r = new Reserva();
        r.setAviso(aviso);
        Date f = new Date();
        r.setFecha(f);
        r.setInmueble(inmueble);
        r.setLocatario(locatario);
    
        repo.save(r);
        return r;

    }

    public Reserva buscarPorId(int id){
        Optional<Reserva> r = repo.findById(id);
        
        if (r.isPresent())
            return r.get();
        return null;

    }


    public List<Reserva> listarReservas(){
        return repo.findAll();
    }



    
}