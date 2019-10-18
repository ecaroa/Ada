package ar.com.ada.api.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.nasa.entities.Pais;
import ar.com.ada.api.nasa.entities.Temperatura;

/**
 * TemperaturaRepository
 */
public interface TemperaturaRepository extends JpaRepository<Temperatura , Integer>{

    
}