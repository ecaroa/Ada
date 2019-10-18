package ar.com.ada.api.nasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nasa.entities.Pais;
import ar.com.ada.api.nasa.entities.Temperatura;
import ar.com.ada.api.nasa.excepciones.TemperaturaException;
import ar.com.ada.api.nasa.repository.TemperaturaRepository;

/**
 * TemperaturaService
 */
@Service
public class TemperaturaService {
    @Autowired
    TemperaturaRepository temperaturaRepo;

    @Autowired
    PaisService paisService;

    public Temperatura CrearTemperatura(int codigoPais, int anio, double grados) throws TemperaturaException{
        
        Pais p = paisService.buscarPorId(codigoPais);
        Temperatura temp = new Temperatura();
        
        temp.setAniosTemperatura(anio);
        temp.setGrados(grados);
              

        p.agregarTemperatura(temp);
        temperaturaRepo.save(temp);
        return temp;
        
    }

    public void grabarT (Temperatura temp){
        this.temperaturaRepo.save(temp);
    }

    
}