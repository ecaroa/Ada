package ar.com.ada.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Reserva
 */
@Entity
@Table(name = "reserva")
public class Reserva implements IOperable {

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear IEsOperable con aviso

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;

    @OneToOne
    @JoinColumn(name= "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    @OneToOne
    @JoinColumn(name= "aviso_id", referencedColumnName = "aviso_id")
    @JsonIgnore
    private Aviso aviso;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getReservaId() {
        return id;
    }

    public void setReservaId(int reservaId) {
        this.id = reservaId;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

}