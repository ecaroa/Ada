package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.models.request.DepositRequest;
import ar.com.ada.api.billeteravirtual.models.request.TransferRequest;
import ar.com.ada.api.billeteravirtual.models.response.DepositoResponse;
import ar.com.ada.api.billeteravirtual.models.response.MovimientoResponse;
import ar.com.ada.api.billeteravirtual.models.response.SaldoResponse;
import ar.com.ada.api.billeteravirtual.models.response.TransferResponse;
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

    @PostMapping("/billeteras/{id}/traferencias/")

    public TransferResponse postBilleteraTransferir(@PathVariable int id, @RequestBody TransferRequest req) {
        Billetera bOrigen = billeteraService.buscarPorId(id);
        billeteraService.transferencia(bOrigen, req.email, req.importeATransferir, req.moneda, req.concepto,
                req.detalle);

        billeteraService.grabar(bOrigen);

        TransferResponse r = new TransferResponse();
        r.isOk = true;
        r.message = "Transferencia con exito";

        return r;
    }

    @GetMapping("/billetera/{id}/movimientos/{moneda}")
    public ArrayList<MovimientoResponse> getBilleterById(@PathVariable int id, @PathVariable String moneda,
            @RequestParam(value = "orderByFech", required = false) boolean orderByFech) {

        
        ArrayList<MovimientoResponse> lm = new ArrayList<>();
        if (orderByFech) {
            List<Movimiento> lmOrdenado = billeteraService.buscarMovOrdenados(id, moneda);
            for (Movimiento mov : lmOrdenado) {
                MovimientoResponse m = new MovimientoResponse();
                m.movimientoId = id;
                m.fechaMovimiento = mov.getFechaMovimiento();
                m.importe = mov.getImporte();
                m.conceptoOperacion = mov.getConceptoOperacion();
                lm.add(m);

            }

            return lm;
        }
        Billetera b = billeteraService.buscarPorId(id);
        Cuenta cta = billeteraService.buscarCuentaPorMoneda(b, moneda);
        for (Movimiento mov : cta.getMovimientos()) {
            MovimientoResponse m = new MovimientoResponse();
            m.movimientoId = id;
            m.fechaMovimiento = mov.getFechaMovimiento();
            m.importe = mov.getImporte();
            m.conceptoOperacion = mov.getConceptoOperacion();
            lm.add(m);

        }
        return (lm);

    }

}