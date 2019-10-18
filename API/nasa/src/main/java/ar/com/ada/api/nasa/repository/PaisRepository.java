package ar.com.ada.api.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.nasa.entities.Pais;

/**
 * PaisRepository
 */
public interface PaisRepository extends JpaRepository<Pais, Integer>{
Pais findByNombre(String nombre);
    
}