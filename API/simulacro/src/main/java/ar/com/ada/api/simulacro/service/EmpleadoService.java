package ar.com.ada.api.simulacro.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.entities.Empleado;
import ar.com.ada.api.simulacro.repository.EmpleadoRepo;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService {

@Autowired
EmpleadoRepo empleadoRepo;

public void CrearEmpleado (String nombre, int edad, Categoria categoria, BigDecimal sueldo, String estado,Date fechaAlta,Date fechaBaja){
    Empleado emp = new Empleado();
    emp.setNombre(nombre);
    emp.setEdad(edad);
    emp.setCategoria(categoria);
    emp.setSueldo(sueldo);
    emp.setEstado(estado);
    emp.setFechaAlta(new Date());
	empleadoRepo.save(emp);
}

public void grabar(Empleado emp){
	this.empleadoRepo.save(emp);
}

}