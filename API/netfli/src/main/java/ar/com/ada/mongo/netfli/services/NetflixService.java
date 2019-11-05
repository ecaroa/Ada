package ar.com.ada.mongo.netfli.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfli.entities.Peli;
import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.repo.PeliRepository;

/**
 * NetflixService
 */
@Service
public class NetflixService {
    
    @Autowired
    PeliRepository peliRepo;

    @Autowired
    SerieService serieService;

    @Autowired
    PeliService peliService;


    public void grabar(Serie serie) {
        serieService.grabar(serie);
    }

    public void grabar(Peli peli) {
        peliService.grabar(peli);
    }
    

    public Serie buscarSerie(String nombre) {
        return serieService.buscarPorNombre(nombre);
    }

    public Serie buscarSerie(ObjectId id) {
        return serieService.buscarPorId(id);
    }

    public List<Serie> getCatalogoSeries() {
        return serieService.getCatalogo();
    }


    public List<Peli> getPeli() {

        return peliRepo.findAll();
    }

    public static Peli BuscarPeli(String nombre) {
        //Aca repo a buscar las pelis
        return null;
    }



}