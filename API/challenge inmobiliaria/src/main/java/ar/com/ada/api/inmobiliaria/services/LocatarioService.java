package ar.com.ada.api.inmobiliaria.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.repo.LocatarioRepository;
import ar.com.ada.api.inmobiliaria.security.Crypto;

/**
 * LocatarioService
 */
@Service
public class LocatarioService {

    @Autowired
    LocatarioRepository repo;

    @Autowired
    UsuarioService us;

    public Locatario crearLocatario(String nombre, String dni, int edad, String email, String password) {
        Locatario l = new Locatario();
        Usuario u = us.crearUsuario(password, email, l);
        
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEdad(edad);
        l.setEmail(email);
        l.setUsuario(u);

        repo.save(l);

        return l;

    }
    public void login(String nombre, String password) {

        Locatario l = repo.findByNombre(nombre);

        if (l == null || !l.getUsuario().getPassword().equals(Crypto.encrypt(password, (String) l.getUsuario().getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

    public void grabar(Locatario locatario) {
        this.repo.save(locatario);
    }

    public Locatario buscarPorId(int id) {
        Optional<Locatario> l = repo.findById(id);

        if (l.isPresent())
            return l.get();
        return null;

    }

    public Locatario updateLocatario(String nombre, String dni, int edad, String email) {
        Locatario l = new Locatario();
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEdad(edad);
        l.setEmail(email);
        repo.save(l);
        return l;
    }

    
    public Locatario bajaLocatario(int id){

        Locatario l = this.buscarPorId(id);
        Usuario u = us.bajaUsuario(l.getUsuario().getUsuarioId());
        l.setUsuario(u); //no se si hace falta?

        repo.save(l);

        return l;
    }

     public List<Locatario> listarLocatariosYUsuarios() {
        return repo.findAll();
    }

    
}