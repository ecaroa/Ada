package ar.com.ada.spookify1.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.spookify1.entities.Artista;

/**
 * ArtistaController
 */
@RestController
public class ArtistaController {

    @GetMapping (value = "/artistas")

    public List <Artista> getTodes()
    {
        List <Artista> artistas = new ArrayList<Artista>();

        Artista ar = new Artista();
        ar.setNombre("The Cranberries");
        ar.setEdad(30);

        artistas.add(ar);

        ar = new Artista();
        ar.setNombre("Jack");
        ar.setEdad(30);

        artistas.add(ar);

        ar = new Artista();
        ar.setNombre("Pingfong");
        ar.setEdad(28);

        artistas.add(ar);

        ar = new Artista();
        ar.setNombre("Billie Elish");
        ar.setEdad(21);

        artistas.add(ar);

        return artistas;
    }
}