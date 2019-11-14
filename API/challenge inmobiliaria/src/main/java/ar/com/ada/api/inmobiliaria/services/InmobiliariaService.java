package ar.com.ada.api.inmobiliaria.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.repo.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repo;
    @Autowired
    LocadorService ls;
    @Autowired
    UsuarioService us;

    public void grabar(Inmobiliaria inmobiliaria) {
        this.repo.save(inmobiliaria);
    }

    public Inmobiliaria crearInmobiliaria(String cuit, String nombre, String email, String password) {
        Inmobiliaria inmo = new Inmobiliaria();
        Usuario u = us.crearUsuario(password, email, inmo);
        
        inmo.setCuit(cuit);
        inmo.setNombre(nombre);
        inmo.setUsuario(u);
        repo.save(inmo);

        return inmo;

    }

    public Inmobiliaria buscarPorId(int id) {
        Optional<Inmobiliaria> i = repo.findById(id);

        if (i.isPresent())
            return i.get();
        return null;

    }

    public Inmobiliaria updateInmobiliaria(String cuit, String nombre) {
        Inmobiliaria i = new Inmobiliaria();
        i.setCuit(cuit);
        i.setNombre(nombre);
        repo.save(i);
        return i;
    }
    


    public Locador crearLocador(String nombre, String dni, int edad, String email) {
        Locador loc = new Locador();
        loc.setNombre(nombre);
        loc.setDni(dni);
        loc.setEdad(edad);
        loc.setEmail(email);
        ls.grabar(loc);
        return loc;

    }

     

    

    
}