package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;
/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")

public class Cuenta {
    @Id
    @Column(name = "cuentaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuenta_id;

    private String moneda;
    private double saldo;
    private double saldoDisponible;

    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    // @MapsId
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public List<Movimiento> getMovimiento() {
        return movimientos;
    }

    public void setMovimiento(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        movimiento.setCuenta(this);
        this.movimientos.add(movimiento);
        this.setSaldo(this.getSaldo() + movimiento.getImporte());
    }

    /**
     * @param billetera the usuario to set
     */

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;

    }

    /**
     * @return the usuario
     */
    public Billetera getBilletera() {
        return billetera;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

}