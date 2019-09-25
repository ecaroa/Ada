package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Movimiento
 */
@Entity
@Table(name= "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int movimientoId;
    private Date fechaMovimiento;
    //private Coordenada ubicacion;
    private double importe;
    private String tipoDeOperacion;
    private String conceptoDeOperacion;
    private String detalle;
    private int estado;
    private int deUsuario_id;
    private int aUsuario_id;
    //private Usuario deUsuario;
    //private Usuario aUsuario;
    //private Cuenta cuentaDestino;
    //private Cuenta cuentaOrigen;
    private int cuentaDestino_id;
    private int cuentaOrigen_id;
    
    
    @ManyToOne
    @JoinColumn(name = "cuentaId", referencedColumnName = "cuentaId")
    //@MapsId
    private Cuenta cuenta;

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    public String getConceptoDeOperacion() {
        return conceptoDeOperacion;
    }

    public void setConceptoDeOperacion(String conceptoDeOperacion) {
        this.conceptoDeOperacion = conceptoDeOperacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /*public Usuario getDeUsuario() {
        return deUsuario;
    }
    public void setDeUsuario(Usuario deUsuario) {
        this.deUsuario = deUsuario;
    }
    public Usuario getaUsuario() {
        return aUsuario;
    }
    public void setaUsuario(Usuario aUsuario) {
        this.aUsuario = aUsuario;
    }
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
/**
     * @param movimiento the usuario to set
     */

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;

    }

    /**
     * @return the usuario
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getDeUsuario_id() {
        return deUsuario_id;
    }

    public void setDeUsuario_id(int deUsuario_id) {
        this.deUsuario_id = deUsuario_id;
    }

    public int getaUsuario_id() {
        return aUsuario_id;
    }

    public void setaUsuario_id(int aUsuario_id) {
        this.aUsuario_id = aUsuario_id;
    }

    public int getCuentaDestino_id() {
        return cuentaDestino_id;
    }

    public void setCuentaDestino_id(int cuentaDestino_id) {
        this.cuentaDestino_id = cuentaDestino_id;
    }

    public int getCuentaOrigen_id() {
        return cuentaOrigen_id;
    }

    public void setCuentaOrigen_id(int cuentaOrigen_id) {
        this.cuentaOrigen_id = cuentaOrigen_id;
    }



}