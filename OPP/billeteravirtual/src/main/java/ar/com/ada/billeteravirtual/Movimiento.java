package ar.com.ada.billeteravirtual;

import java.util.Date;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;

    @Column(name = "fechamov")
    private Date fechaMovimiento;

    private double importe;

    @Column(name = "tipooperacion")
    private String tipoOperacion; // "Entrada" "Salida"

    @Column(name = "conceptooperacion")
    private String conceptoOperacion;// "Pagos" "Deposito" "Transferencia" "Cobro"

    private String detalle;

    private int estado;// "Aprobado" "Pendiente" "Rechazado"

    @Column(name = "deusuario_id")
    private int deUsuarioId;

    @Column(name = "ausuario_id")
    private int aUsuarioId;

    @Column(name = "cuentaorigen_id")
    private int deCuentaId;

    @Column(name = "cuentadestino_id")
    private int aCuentaId;

    public  Movimiento(){        
    }

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
        this.cuenta.getMovimientos().add(this);
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
        this.cuenta.setSaldo(this.cuenta.getSaldo() + importe);
        this.cuenta.setSaldoDisponible(this.cuenta.getSaldoDisponible() + importe);
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

    public int getAUsuarioId() {
        return aUsuarioId;
    }

    public void setAUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

    public int getDeCuentaId() {
        return deCuentaId;
    }

    public void setDeCuentaId(int deCuentaId) {
        this.deCuentaId = deCuentaId;
    }

    public int getACuentaId() {
        return aCuentaId;
    }

    public void setACuentaId(int aCuentaId) {
        this.aCuentaId = aCuentaId;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * Este constructor crea un movimiento inicial. Hay que sacar el print y
     * adaptarlo para generar distintos movimientos, no solo inicial.
     * @param c
     * @param u
     */
    public Movimiento(Cuenta c, Usuario u) {
        System.out.println("Gracias por crear tu billetera! te regalamos " + c.getMoneda() + " 100 para que empieces a usarla.");
        Date f = new Date();
        this.setConceptoOperacion("Carga inicial");
        this.setImporte(100);
        this.setTipoOperacion("Entrada");
        this.setFechaMovimiento(f);
        this.setDeCuentaId(c.getCuentaId());
        this.setACuentaId(c.getCuentaId());
        this.setAUsuarioId(u.getUsuarioId());
        this.setDeUsuarioId(u.getUsuarioId());
        if (this.getTipoOperacion().equals("Entrada")) {
            c.setSaldo(c.getSaldo() + this.getImporte());
            c.setSaldoDisponible(c.getSaldo());
        } else {
            c.setSaldo(c.getSaldo() - this.getImporte());
            c.setSaldoDisponible(c.getSaldo());
        }
        this.setCuenta(c);
    }
}