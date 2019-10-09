package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {
    @Autowired
    BilleteraRepository billeRepo;

    public Billetera buscarPorId(int id) {

        Optional<Billetera> b = billeRepo.findById(id);
        
        if (b.isPresent())
            return b.get();
        return null;
    }

    public void grabar (Billetera b)
    {
        this.billeRepo.save(b);
    }
    public void agregarPlata(Billetera billetera, BigDecimal plata,String moneda, String concepto, String detalle) {
     billetera.agregarPlata(plata,moneda , concepto, detalle);
    
    }
}