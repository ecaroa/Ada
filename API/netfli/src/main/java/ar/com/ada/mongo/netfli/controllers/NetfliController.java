package ar.com.ada.mongo.netfli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.mongo.netfli.entities.Peli;
import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.models.response.NuevaPeliResponse;
import ar.com.ada.mongo.netfli.models.response.NuevaSerieResponse;
import ar.com.ada.mongo.netfli.services.NetflixService;

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
        r.message = "Te registraste con exitoooo";
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
    public List <Peli> getPeli()
    {
        List<Peli> lp = netfliService.getPeli();
        
        return lp;
    }

    @PostMapping ("/peliculas")
    public NuevaPeliResponse postNewPeli(@RequestBody Peli reqPeli) {
        NuevaPeliResponse np = new NuevaPeliResponse();
        //aca creamos nueva peli
        netfliService.grabar(reqPeli);

        np.isOk = true;
        np.message = "Te registraste con exitoooo";
        np.id = reqPeli.get_id().toString();
        return np;
        
        
    }
}