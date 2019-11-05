package ar.com.ada.mongo.netfli.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepo;

    public void grabar(Serie serie) {
        serieRepo.save(serie);
    }

    public Serie buscarPorId(ObjectId id) {
        return serieRepo.findBy_id(id);
    }

    public Serie buscarPorNombre(String nombre) {
        return serieRepo.findByNombre(nombre);
    }

    public List<Serie> getCatalogo() {
        return serieRepo.findAll();
    }
}