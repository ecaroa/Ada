package ar.com.ada.api.nasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.nasa.excepciones.TemperaturaException;
import ar.com.ada.api.nasa.model.request.TemperaturaRequest;
import ar.com.ada.api.nasa.model.response.TemperaturaResponse;
import ar.com.ada.api.nasa.services.TemperaturaService;

/**
 * TemperaturaController
 */
@RestController
public class TemperaturaController {
@Autowired
TemperaturaService temperaturaService;

@PostMapping("/temperaturas")
    public TemperaturaResponse postRegisterTemperatura(@RequestBody TemperaturaRequest req)throws TemperaturaException {

       

        TemperaturaResponse r = new TemperaturaResponse();


        r.id = temperaturaService.CrearTemperatura(req.codigoPais, req.anio, req.grados).getTemperaturaId();

        return r;

    }
    
}