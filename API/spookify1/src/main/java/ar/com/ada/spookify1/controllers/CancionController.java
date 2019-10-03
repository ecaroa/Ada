package ar.com.ada.spookify1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import ar.com.ada.spookify1.entities.Cancion;

/**
 * CancionController
 */
@RestController
public class CancionController {

    @GetMapping(value = "/temas")
    public List <Cancion> getTodas()
    {
        List <Cancion> lista = new ArrayList<Cancion>();
        
        Cancion c = new Cancion();
        c.setTitulo("Zonbie");
        c.setDuracion(4.0);

        lista.add(c);

        c = new Cancion();
        c.setTitulo("This is Halloween");
        c.setDuracion(3.5);

        lista.add(c);

        c = new Cancion();
        c.setTitulo("Circles");
        c.setDuracion(4.0);

        lista.add(c);

        c = new Cancion();
        c.setTitulo("Bad Guy");
        c.setDuracion(3.5);

        lista.add(c);

        return lista;
        
    }
}