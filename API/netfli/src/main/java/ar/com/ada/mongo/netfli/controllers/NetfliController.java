package ar.com.ada.mongo.netfli.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.mongo.netfli.entities.Peli;
import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.entities.Temporada;
import ar.com.ada.mongo.netfli.models.response.NuevaPeliResponse;
import ar.com.ada.mongo.netfli.models.response.NuevaSerieResponse;
import ar.com.ada.mongo.netfli.models.response.NuevaTempResponse;
import ar.com.ada.mongo.netfli.services.NetflixService;
import ar.com.ada.mongo.netfli.services.SerieService.SerieValidationType;

/**
 * NetfliController
 */
@RestController
public class NetfliController {

    @Autowired
    NetflixService netfliService;

    @PostMapping("/series")
    public NuevaSerieResponse postNewSerie(@RequestBody Serie reqSerie) {
        NuevaSerieResponse r = new NuevaSerieResponse();
        // aca creamos la serie
        netfliService.grabar(reqSerie);

        r.isOk = true;
        r.message = "Se agrego serie";
        r.id = reqSerie.get_id().toString();
        return r;

    }

    @GetMapping("/series")
    public ResponseEntity<?> GetSeries() throws Exception {

        List<Serie> series = netfliService.getCatalogoSeries();
        if (series.size() == 0)
            return (ResponseEntity<?>) ResponseEntity.notFound();

        return ResponseEntity.ok(series);

    }

    @GetMapping("/peliculas")
    public List<Peli> getPeli() {
        List<Peli> lp = netfliService.getPeli();

        return lp;
    }

    @PostMapping("/peliculas")
    public NuevaPeliResponse postNewPeli(@RequestBody Peli reqPeli) {
        NuevaPeliResponse np = new NuevaPeliResponse();
        // aca creamos nueva peli
        netfliService.grabar(reqPeli);

        np.isOk = true;
        np.message = "Se agrego peli";
        np.id = reqPeli.get_id().toString();
        return np;

    }

    @PostMapping(value = "/serie/{id}/temporada")
    public ResponseEntity<?> postNewTemp(@PathVariable String id, @RequestBody Temporada reqTemp) {
        // TODO: process POST request
        NuevaSerieResponse nt = new NuevaSerieResponse();
        Serie serie = netfliService.buscarSerie(new ObjectId(id));
        serie.temporadas.add(reqTemp);

        SerieValidationType sv = netfliService.grabar(serie);

        switch (sv) {
        case SERIE_OK:
            nt.isOk = true;
            nt.message = "Se agrego temporada";
            nt.id = serie.get_id().toString();
            return ResponseEntity.ok(nt);
            

        case TEMPORADAS_NULA:

            nt.isOk = false;
            nt.message = "Es nula";
            nt.id = serie.get_id().toString();
            return ResponseEntity.badRequest().body(nt);
            

        case TEMPORADAS_VACIA:
            nt.isOk = false;
            nt.message = "Temporada vacia";
            nt.id = serie.get_id().toString();
            return ResponseEntity.badRequest().body(nt);

        case TEMPORADA_DUPLICADA:
            nt.isOk = false;
            nt.message = "Temporada duplicada";
            nt.id = serie.get_id().toString();
            return ResponseEntity.badRequest().body(nt);

        case TEMPORADA_INVALIDA:
            nt.isOk = false;
            nt.message = "temporada invalida";
            nt.id = serie.get_id().toString();
            return ResponseEntity.badRequest().body(nt);

        case SERIE_DATOS_INVALIDOS:
            nt.isOk = false;
            nt.message = "serie datos invalidos";
            nt.id = serie.get_id().toString();
            return ResponseEntity.badRequest().body(nt);

        default:
            return ResponseEntity.badRequest().body(nt);


        }

    }

}