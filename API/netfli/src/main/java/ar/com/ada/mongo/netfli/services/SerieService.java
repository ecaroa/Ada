package ar.com.ada.mongo.netfli.services;

import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.entities.Temporada;
import ar.com.ada.mongo.netfli.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepo;

    public SerieValidationType grabar(Serie serie) {

        SerieValidationType resultado = this.verificarSerie(serie);
        if (resultado != SerieValidationType.SERIE_OK)
            return resultado;

        serieRepo.save(serie);

        return SerieValidationType.SERIE_OK;
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

    public enum SerieValidationType {

        SERIE_OK, TEMPORADAS_NULA, TEMPORADAS_VACIA, TEMPORADA_DUPLICADA, TEMPORADA_INVALIDA,

        SERIE_DATOS_INVALIDOS

    }

    public SerieValidationType verificarSerie(Serie serie) {

        if (serie.getNombre() == null)
            return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getAño() <= 0)
            return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getTemporadas() == null)
            return SerieValidationType.TEMPORADAS_NULA;
        if (serie.getTemporadas().size() == 0)
            return SerieValidationType.TEMPORADAS_VACIA;

        // Armo un hashmap para ver si la temporada esta duplicada
        HashMap<Integer, Temporada> unicasTemps = new HashMap<>();

        for (Temporada t : serie.getTemporadas()) {
            if (unicasTemps.containsKey(new Integer(t.getNumeroTemporada())))
                return SerieValidationType.TEMPORADA_DUPLICADA;
            if (t.getEpisodios().size() == 0)
                return SerieValidationType.TEMPORADA_INVALIDA;

            unicasTemps.put(new Integer(t.getNumeroTemporada()), t);

        }

        return SerieValidationType.SERIE_OK;
    }

}