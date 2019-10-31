package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;
import ar.com.ada.api.billeteravirtual.repo.MovimientoRepository;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;

/**
 * BilleteraService
 * 
 */
@Service
public class BilleteraService {
    @Autowired
    BilleteraRepository billeRepo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MovimientoRepository movRepo;

    @Autowired
    EmailService emailService;


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
        
        emailService.SendEmail(billetera.getPersona().getUsuario().getUserEmail(),"Su deposito se ha realizado con exito",
            "Hola "+billetera.getPersona().getNombre()+"\n ha depositado" + plata);
    }

    public void descontarPlata(Billetera billetera, BigDecimal plata, String moneda, String concepto, String detalle) {
        billetera.descontarPlata(plata, moneda, concepto, detalle);



    }

    public void transferencia (Billetera deBilletera, String email ,BigDecimal plata, String moneda, String concepto, String detalle){
        Billetera aBilletera;

        aBilletera = usuarioService.buscarPorEmail(email).getPersona().getBilletera();
        deBilletera.transferencia(aBilletera, plata, moneda, concepto, detalle);

        emailService.SendEmail(deBilletera.getPersona().getUsuario().getUserEmail(),"Su transferencia se ha realizado con exito",
            " Se envio al usuario"+ email +"\n la cantidad de " + plata);

         emailService.SendEmail(email,"Aviso de transferencia",
            "Hola "+ aBilletera +"\n te han depositado" + plata + "el usuario" + deBilletera );
        

    }

    public Cuenta buscarCuentaPorMoneda(Billetera b, String moneda){
        for (Cuenta cuenta : b.getCuentas()) {
            if (cuenta.getMoneda().equals(moneda)) {
                return cuenta;

                
            }
            
            
            
        }
        return null;
    }

    public List <Movimiento> buscarMovOrdenados (int billeteraId,String moneda){
        return movRepo.FindOrderByFech(billeteraId,moneda);
    }



}