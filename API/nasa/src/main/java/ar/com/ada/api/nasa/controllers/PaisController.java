package ar.com.ada.api.nasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.nasa.entities.Pais;
import ar.com.ada.api.nasa.model.request.PaisRequest;
import ar.com.ada.api.nasa.model.response.PaisResponse;
import ar.com.ada.api.nasa.services.PaisService;

/**
 * PaisController
 */

@RestController
public class PaisController {
    @Autowired
    PaisService paisService;

    @PostMapping("/paises")
    public PaisResponse postRegisterPais(@RequestBody PaisRequest req) {
        paisService.CrearPais(req.codigoPais, req.nombre);

        PaisResponse r = new PaisResponse();
        r.isOk = true;
        r.message = "Pais creada con exito";

        return r;

    }

     @GetMapping("/paises")
     public List<Pais> getPaises() {
        List<Pais> lp = paisService.getPaises();

        return lp;
     }

     @GetMapping("/paises/{id}")
     public Pais getPaisById(@PathVariable int id)
    {
        Pais p = paisService.buscarPorId(id);
        
        return p;
    }

}