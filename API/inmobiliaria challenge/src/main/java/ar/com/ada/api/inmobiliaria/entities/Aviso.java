package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Aviso
 */
@Entity
@Table(name = "aviso")
public class Aviso {

    @Id
    @Column(name = "aviso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avisoId;
    @ManyToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    @OneToOne(mappedBy = "aviso", cascade = CascadeType.ALL)
    @JsonIgnore
    private Reserva reserva;
    @OneToOne(mappedBy = "aviso", cascade = CascadeType.ALL)
    private Venta venta;
    @OneToOne(mappedBy = "aviso", cascade = CascadeType.ALL)
    private Alquiler alquiler;
    
    @Transient  //annotation que sirve para que ignore el atributo en el mapping
    private IOperable operacion;
    
    @Column(name = "tipo_operacion")
    private String tipoOperacion;
    // lo saqué e hice el getter engañoso de más abajo

    public int getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(int avisoId) {
        this.avisoId = avisoId;
    }

    public String getTipoOperacion(IOperable operacion) {
        return operacion.getClass().getName();
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public IOperable getOperacion() {
        return operacion;
    }

    public void setOperacionYTipo(IOperable operacion) {
        this.operacion = operacion;
        this.tipoOperacion = operacion.toString();
    }

    /*public void setTipoOperacion(IOperable operacion) {
        this.tipoOperacion = operacion.getClass().getName();
    }*/

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Aviso() {
    }

    public void setOperacion(IOperable operacion) {
        this.operacion = operacion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

}