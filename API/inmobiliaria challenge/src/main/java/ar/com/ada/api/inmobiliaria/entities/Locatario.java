package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

/**
 * Locatario
 */
@Entity
@Table(name = "locatario")
public class Locatario extends Persona implements ITieneUsuario {

    @Id
    @Column(name = "locatario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear ITieneUsuario con Usuario

    @OneToMany(mappedBy = "locatario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<Reserva>(); //creo que hay que sacar reserva_id en la DB

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Transient
    private String tipoUsuario = "Locatario";

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Locatario() {
    }

    @Override
    public String toString() {
        return tipoUsuario;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Usuario getUsuario() {
        return this.usuario;
    }

}