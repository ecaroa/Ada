package ar.com.ada.billeteravirtual;

import javax.persistence.*;

import ar.com.ada.billeteravirtual.*;
import ar.com.ada.billeteravirtual.excepciones.PersonaEdadException;

/**
 * Persona
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pesonaId;
    private String nombre;
    private String dni;
    private int edad;
    private String email;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Billetera billetera;

    public Persona(String nombre, String dni, int edad, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
    }

    public Persona() {
    }

    public int getPesonaId() {
        return pesonaId;
    }

    public void setPesonaId(int pesonaId) {
        this.pesonaId = pesonaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws PersonaEdadException {
        if (edad < 18) {
            // no se ejecuta nada mas despues del throw
            throw new PersonaEdadException(this, "ocurrio un error con la edad");

        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        if (this.usuario != null)
            return "Persona [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + ", usuario= "
                    + usuario.getUserName() + "]";
        else
            return "Persona [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.setPersona(this); // Vinculamos ambos objetos entre si
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
        this.billetera.setPersona(this);
    }
}