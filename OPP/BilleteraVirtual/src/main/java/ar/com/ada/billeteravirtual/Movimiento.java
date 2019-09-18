package ar.com.ada.billeteravirtual;

import java.util.Date;

/**
 * Movimiento
 */
public class Movimiento {
    
    private int movimientoId;
    private Date fechaMov;
    private Cordenada ubicacion;
    private double importe;
    private String tipoOperacion;
    private String conceptoOpercion;
    private String detalle;
    private int estado;
    private int deUsuarioId;
    private int aUsuarioId;
    private Usuario deUsuario;
    private Usuario aUsuario;
    private Cuenta cuentaDestino;
    private Cuenta cuentaOrigen;
    private int cuentaOrigenId;
    private int cuentaDestinoId;

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public Cordenada getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Cordenada ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getConceptoOpercion() {
        return conceptoOpercion;
    }

    public void setConceptoOpercion(String conceptoOpercion) {
        this.conceptoOpercion = conceptoOpercion;
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

    public int getDeUsuarioId() {
        return deUsuarioId;
    }

    public void setDeUsuarioId(int deUsuarioId) {
        this.deUsuarioId = deUsuarioId;
    }

    public int getaUsuarioId() {
        return aUsuarioId;
    }

    public void setaUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

    public Usuario getDeUsuario() {
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

    public int getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(int cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public int getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(int cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

}