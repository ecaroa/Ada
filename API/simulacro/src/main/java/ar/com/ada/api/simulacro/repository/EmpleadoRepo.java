package ar.com.ada.api.simulacro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.simulacro.entities.Empleado;

/**
 * EmpleadoRepo
 */
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer>{

    
}