package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 * 
 * @param <MovimientoController>
 */
@Service
public class BilleteraService<MovimientoController> {
    @Autowired
    BilleteraRepository billeRepo;

    public Billetera buscarPorId(Billetera bD) {

        Optional<Billetera> b = billeRepo.findById(bD);
        
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

    @Autowired
    MovimientoController  movicontrol;



}