package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    PersonaService personaService;

    @Autowired
    BilleteraService billeteraService;

    @Autowired
    EmailService emailService;

    public List <Usuario> getUsuarios(){

        return repo.findAll();
    }

    public Usuario buscarPorId(int id) {

        Optional<Usuario> u = repo.findById(id);
        
        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario buscarPorEmail(String email){

        return repo.findByUserEmail(email);

    }

        public Usuario buscarPorUsername(String username) {

        return repo.findByUserName(username);

    }
    
     public int crearUsuario(String fullName, String dni, String email, int edad, String password)

            throws PersonaEdadException {

        Persona p = new Persona();
        p.setNombre(fullName);
        p.setDni(dni);
        p.setEmail(email);
        p.setEdad(edad);

        Usuario u = new Usuario();
        u.setUserName(p.getEmail());
        u.setUserEmail(p.getEmail());

        String passwordEnTextoClaro;
        String passwordEncriptada;

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());

        u.setPassword(passwordEncriptada);
        p.setUsuario(u);

        personaService.grabar(p);

        Billetera b = new Billetera();
        p.setBilletera(b);

        Cuenta c = new Cuenta();

        c.setMoneda("ARS"); // Moneda inicial en ARS.
        b.agregarCuenta(c);

        billeteraService.grabar(b);

        b.agregarPlata(new BigDecimal(100), "ARS", "Regalo", "Te regalo 100 pesitos");
        
        emailService.SendEmail(u.getUserEmail(),"Bienvenido a la Billetera Virtual ADA!!!", 
            "Hola "+p.getNombre()+"\nBienvenido a este hermoso proyecto hecho por todas las alumnas de ADA Backend 8va Mañana\n"+
            "Ademas te regalamos 100 pesitos" );
        
        return u.getUsuarioId();
        

    }
     public void login(String username, String password) {

        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUserName()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }
    
}