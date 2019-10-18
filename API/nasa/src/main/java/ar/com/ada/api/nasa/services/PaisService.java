package ar.com.ada.api.nasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nasa.entities.Pais;
import ar.com.ada.api.nasa.repository.PaisRepository;

/**
 * PaisService
 */
@Service
public class PaisService {
@Autowired
PaisRepository paisRepo;

    public void CrearPais(int codigoPais, String nombre){
        Pais pais = new Pais();
        pais.setPaisId(codigoPais);
        pais.setNombre(nombre);
        paisRepo.save(pais);
    }

    public void grabar (Pais pais){
        this.paisRepo.save(pais);
    }

    public List<Pais> getPaises(){
        return paisRepo.findAll();

    }

    public Pais buscarPorId(int id){
        Optional<Pais> p = paisRepo.findById(id);
        
        if (p.isPresent())
            return p.get();
        return null;

    }

}