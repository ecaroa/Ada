package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    private String moneda;

    private BigDecimal saldo;

    @Column(name = "saldodisponible")
    private BigDecimal saldoDisponible;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void agregarPlata(int usuarioDe,String concepto, BigDecimal importe, String detalle) {
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("INGRESO");
        m.setImporte(importe);
        m.setConceptoOperacion(concepto);
        m.setDetalle(detalle);
        m.setFechaMovimiento(new Date());
        m.setDeUsuarioId(usuarioDe);
        m.setaUsuarioId(usuarioDe);
        m.setDeCuentaId(this.cuentaId);
        m.setaCuentaId(this.cuentaId);

        this.movimientos.add(m);
    }

    public void descontarPlata(int usuarioOr, String concepto, BigDecimal importe, String detalle){
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("EGRESO");
        m.setImporte(importe.negate());
        m.setConceptoOperacion(concepto);
        m.setFechaMovimiento(new Date());
        m.setDeUsuarioId(usuarioOr);
        m.setaUsuarioId(usuarioOr);
        m.setDeCuentaId(this.cuentaId);
        m.setaCuentaId(this.cuentaId);

    }


}