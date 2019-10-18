package ar.com.ada.api.simulacro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.simulacro.entities.Categoria;

/**
 * CategoriaRepo
 */
public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {
    Categoria findByNombreCategoria(String nombreCategoria);
    
}