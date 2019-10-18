package ar.com.ada.api.simulacro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacro.model.request.EmpleadoRequest;
import ar.com.ada.api.simulacro.model.response.EmpleadoResponse;
import ar.com.ada.api.simulacro.service.EmpleadoService;

/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping ("/empleados")
    public EmpleadoResponse postRegisterUser1(@RequestBody EmpleadoRequest req) {

        EmpleadoService.em

        /*EmpleadoResponse r = new EmpleadoResponse();
        r.isOk = true;
        r.message = "Empleado creada con exito";

        return r;*/
    }
    
}