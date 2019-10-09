package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import antlr.collections.List;
import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.models.request.DepositRequest;
import ar.com.ada.api.billeteravirtual.models.response.DepositoResponse;
import ar.com.ada.api.billeteravirtual.models.response.SaldoResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraCotroller
 */
@RestController
public class BilleteraCotroller {

    @Autowired
    BilleteraService billeteraService;

    @GetMapping("/billeteras/{id}/saldos")
    public ArrayList<SaldoResponse> getBilleteraById(@PathVariable int id) {

        Billetera b = billeteraService.buscarPorId(id);

        ArrayList<SaldoResponse> ls = new ArrayList<>();
        for (Cuenta cta : b.getCuentas()) {
            SaldoResponse s = new SaldoResponse();
            s.IdBilletera = id;
            s.moneda = cta.getMoneda();
            s.saldo = cta.getSaldo();
            ls.add(s);
        }

        return ls;
    }

    @PostMapping("/billeteras/{id}/depositos")
    public DepositoResponse setBilleteraById(@PathVariable int id, @RequestBody DepositRequest req) {

        Billetera b = billeteraService.buscarPorId(id);
        billeteraService.agregarPlata(b, req.importeADepositar, req.moneda, req.concepto, req.detalle);

        billeteraService.grabar(b);

        DepositoResponse r = new DepositoResponse();
        r.isOk = true;
        r.message = "Deposito con exito";

        return r;

    }

}