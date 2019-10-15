package ar.com.ada.api.billeteravirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.entities.Persona;



/**
 * BilleteraRepository
 */
@Repository
public interface BilleteraRepository extends JpaRepository<Billetera, Integer>{
    //public Billetera findByPersona(int personaId);
   // public Billetera findByPersona(Persona p);
   

    
}