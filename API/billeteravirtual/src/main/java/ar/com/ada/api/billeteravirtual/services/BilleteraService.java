package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    
}