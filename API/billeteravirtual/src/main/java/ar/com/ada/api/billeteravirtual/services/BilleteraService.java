package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
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

    @Autowired
    UsuarioService usuarioService;

    public Billetera buscarPorId(Integer bD) {

        Optional<Billetera> b = billeRepo.findById(bD);

        if (b.isPresent())
            return b.get();
        return null;
    }

    public void grabar(Billetera b) {
        this.billeRepo.save(b);
    }

    public void agregarPlata(Billetera billetera, BigDecimal plata, String moneda, String concepto, String detalle) {
        billetera.agregarPlata(plata, moneda, concepto, detalle);

    }

    public void descontarPlata(Billetera billetera, BigDecimal plata, String moneda, String concepto, String detalle) {
        billetera.descontarPlata(plata, moneda, concepto, detalle);
    }

    public void transferencia (Billetera deBilletera, String email ,BigDecimal plata, String moneda, String concepto, String detalle){
        Billetera aBilletera;

        aBilletera = usuarioService.buscarPorEmail(email).getPersona().getBilletera();
        deBilletera.transferencia(aBilletera, plata, moneda, concepto, detalle);
    }




}