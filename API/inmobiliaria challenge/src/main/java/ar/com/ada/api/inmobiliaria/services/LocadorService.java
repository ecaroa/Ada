package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.repo.LocadorRepository;

@Service
public class LocadorService {
    @Autowired
    LocadorRepository repo;

    public Locador buscarPorId(int id) {
        Optional<Locador> l = repo.findById(id);

        if (l.isPresent())
            return l.get();
        return null;

    }

    public void grabar(Locador locador) {
        this.repo.save(locador);
    }

    public List<Locador> listarLocadores() {
        return repo.findAll();
    }
    
        
    /*public List<Locador> buscarLocadoresOrdenadoPorNombre() {

        return repo.findAllOrderByNombre();
    }


    
    public List<Locador> buscarTodosPorNombre(String nombre) {

        return repo.findAllByNombreContiene(nombre);
    }*/
}
