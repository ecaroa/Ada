package ar.com.ada.mongo.netfli.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfli.entities.Peli;
import ar.com.ada.mongo.netfli.repo.PeliRepository;

/**
 * PeliService
 */
@Service
public class PeliService {

    @Autowired
    PeliRepository peliRepo;

    public void grabar(Peli peli) {
        peliRepo.save(peli);
    }

    public Peli buscarPorId(ObjectId id) {
        return peliRepo.findBy_id(id);
    }

    public Peli buscarPorNombre(String nombre) {
        return peliRepo.findByNombre(nombre);
    }

    public List<Peli> getCatalogo() {
        return peliRepo.findAll();
    }
}