package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.repo.VentaRepository;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repo;
    @Autowired
    AvisoService as;

    public Venta crearVenta(String moneda, double valor){
        Venta v = new Venta();
        v.setMoneda(moneda);
        v.setValor(valor);
        repo.save(v);
        
        return v;
    }

    public void grabar(Venta v) {
        this.repo.save(v);
    }

    public Venta buscarPorId(int id) {
        Optional<Venta> v = repo.findById(id);

        if (v.isPresent())
            return v.get();
        return null;

    }

    public List<Venta> listarVentas() {
        return repo.findAll();
    }

}
