package ar.com.ada.api.inmobiliaria.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;
import ar.com.ada.api.inmobiliaria.repo.UsuarioRepository;
import ar.com.ada.api.inmobiliaria.security.Crypto;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    public void grabar(Usuario u) {
        this.repo.save(u);
    }

    public Usuario crearUsuario(String password, String email, ITieneUsuario tieneUsuario) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(u.getEmail());
        u.setTipoUsuario(tieneUsuario.toString());
        Date f = new Date();
        u.setFechaAltaUsuario(f);
        u.setEstadoUsuario("Activo");

        String passwordEnTextoClaro = password;
        String passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUsername());

        u.setPassword(passwordEncriptada);

        repo.save(u);

        return u;

    }

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = repo.findById(id);
        if (u.isPresent())
            return u.get();
        return null;

    }

    public Usuario updateUsuario(int id, String userName, String email) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(userName);
        u.setEmail(email);
        repo.save(u);
        return u;
    }

    public Usuario bajaUsuario(int id){

        Usuario u = this.buscarPorId(id);
        u.setEstadoUsuario("Baja");
        Date f = new Date();
        u.setFechaBajaUsuario(f);
        repo.save(u);

        return u;
    }

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }

    public Usuario buscarPorUsername(String username){

        Usuario u = repo.findByUsername(username);
        return u;

    }

    public void login(String username, String password) {

        Usuario u = repo.findByUsername(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt((String) password, u.getUserName()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}