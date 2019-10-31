package ar.com.ada.mongo.netfli.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfli.entities.Usuario;
import ar.com.ada.mongo.netfli.repo.UsuarioRepository;
import ar.com.ada.mongo.netfli.security.Crypto;
import ar.com.ada.mongo.netfli.sistema.comms.EmailService;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    EmailService emailService;

    public List<Usuario> getUsuarios() {

        return repo.findAll();
    }

    public Usuario buscarPorId(int id) {

        Optional<Usuario> u = repo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario buscarPorEmail(String email) {

        return repo.findByUserEmail(email);

    }

    public Usuario buscarPorUsername(String username) {

        return repo.findByUserName(username);

    }

    public ObjectId crearUsuario(String fullName, String email, String password) {

        Usuario u = new Usuario();
        u.setFullName(fullName);
        u.setUserName(email);
        u.setUserEmail(email);

        String passwordEnTextoClaro;
        String passwordEncriptada;

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());

        u.setPassword(passwordEncriptada);
        repo.save(u);

        emailService.SendEmail(u.getUserEmail(), "Bienvenido a tu Nefly!!!",
                "Hola " + u.getFullName()
                        + "\nBienvenido a este hermoso proyecto hecho por todas las alumnas de ADA Backend 8va Mañana\n"
                        + "Ademas te regalamos 100 pesitos");

        return u.get_id();

    }

    public void login(String username, String password) {

        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUserName()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}