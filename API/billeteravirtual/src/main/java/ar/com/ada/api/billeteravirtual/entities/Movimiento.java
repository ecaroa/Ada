package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Movimiento
 */
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimientoId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;

    @Column(name = "fechamov")
    private Date fechaMovimiento;

    private BigDecimal importe;

    @Column(name = "tipooperacion")
    private String tipoOperacion;

    @Column(name = "conceptooperacion")
    private String conceptoOperacion;

    private String detalle;

    private int estado;

    @Column(name = "deusuario_id")
    private int deUsuarioId;

    @Column(name = "ausuario_id")
    private int aUsuarioId;

    @Column(name = "cuentaorigen_id")
    private int deCuentaId;

    @Column(name = "cuentadestino_id")
    private int aCuentaId;

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
        this.cuenta.setSaldo(this.cuenta.getSaldo().add(importe));
        this.cuenta.setSaldoDisponible(this.cuenta.getSaldoDisponible().add(importe));
    }

    public String getConceptoOperacion() {
        return conceptoOperacion;
    }

    public void setConceptoOperacion(String conceptoOperacion) {
        this.conceptoOperacion = conceptoOperacion;
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

    public int getDeCuentaId() {
        return deCuentaId;
    }

    public void setDeCuentaId(int deCuentaId) {
        this.deCuentaId = deCuentaId;
    }

    public int getaCuentaId() {
        return aCuentaId;
    }

    public void setaCuentaId(int aCuentaId) {
        this.aCuentaId = aCuentaId;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

}