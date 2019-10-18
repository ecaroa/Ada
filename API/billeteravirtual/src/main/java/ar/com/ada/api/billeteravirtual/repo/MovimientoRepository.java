package ar.com.ada.api.billeteravirtual.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.ada.api.billeteravirtual.entities.Movimiento;

/**
 * MovimientoRepository
 */
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{

    @Query("SELECT m FROM Movimiento m WHERE m.cuenta.billetera.billeteraId = :billeteraId AND m.cuenta.moneda= :moneda ORDER BY fechaMovimiento desc")
    List<Movimiento> FindOrderByFech(@Param("billeteraId") int billeteraId,@Param("moneda") String moneda);
}