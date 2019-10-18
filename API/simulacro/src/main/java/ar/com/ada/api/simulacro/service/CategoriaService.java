package ar.com.ada.api.simulacro.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.repository.CategoriaRepo;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

@Autowired 
CategoriaRepo categoriaRepo;

public List<Categoria> getCategorias() {
	return categoriaRepo.findAll();
}

public void crearCategoria(String nombreCategoria, BigDecimal sueldoBase){
	Categoria cat = new Categoria();
	cat.setNombreCategoria(nombreCategoria);
	cat.setSueldoBase(sueldoBase);
	categoriaRepo.save(cat);
}

public void grabar(Categoria cat){
	this.categoriaRepo.save(cat);
}
} 