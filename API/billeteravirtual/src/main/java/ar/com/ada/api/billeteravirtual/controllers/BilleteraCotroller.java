package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import antlr.collections.List;
import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraCotroller
 */
@RestController
public class BilleteraCotroller {

@Autowired
BilleteraService billeteraService;

@GetMapping ("/saldo/{id}")
public Billetera getBilleteraById(@PathVariable int id){
    
        Billetera b = billeteraService.buscarPorId(id);
        
        return b;
}
    
}