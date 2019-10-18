package ar.com.ada.api.simulacro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.model.request.CategoriaRequest;
import ar.com.ada.api.simulacro.model.response.CategoriaResponse;
import ar.com.ada.api.simulacro.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

/**
 * CategoriaControler
 */
@RestController
public class CategoriaControler {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        List<Categoria> lc = categoriaService.getCategorias();

        return lc;
    }

    @PostMapping("/categorias")
    public CategoriaResponse postRegisterUser(@RequestBody CategoriaRequest req) {

        categoriaService.crearCategoria(req.nombreCategoria, req.sueldoBase);

        CategoriaResponse r = new CategoriaResponse();
        r.isOk = true;
        r.message = "Categoria creada con exito";

        return r;
    }
}