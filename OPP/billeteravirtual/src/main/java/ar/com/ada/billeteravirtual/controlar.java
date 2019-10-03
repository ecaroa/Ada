package ar.com.ada.billeteravirtual;

import java.util.*;

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
    @Column(name = "fecha_mov")
    private Date fechaMov;
    private double importe;
    // private Coordenada ubicacion (fase 2);
    private String tipo; // "Entrada" "Salida"
    private String concepto; // "Pagos" "Deposito" "Transferencia" "Cobro"
    private String detalle;
    private int estado; // "Aprobado" "Pendiente" "Rechazado"
    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;
    @Column(name = "de_usuario_id")
    private int deUsuarioId;
    @Column(name = "a_usuario_id")
    private int aUsuarioId;
    @Column(name = "cuenta_destino_id")
    private int cuentaDestinoId;
    @Column(name = "cuenta_origen_id")
    private int cuentaOrigenId;

    public Movimiento() {
    }

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

    public int getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(int cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public int getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(int cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.cuenta.getMovimientos().add(this);
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
        this.setConcepto("Carga inicial");
        this.setImporte(100);
        this.setTipo("Entrada");
        this.setFechaMov(f);
        this.setCuentaOrigenId(c.getCuentaId());
        this.setCuentaDestinoId(c.getCuentaId());
        this.setaUsuarioId(u.getUsuarioId());
        this.setDeUsuarioId(u.getUsuarioId());
        if (this.getTipo().equals("Entrada")) {
            c.setSaldo(c.getSaldo() + this.getImporte());
            c.setSaldoDisponible(c.getSaldo());
        } else {
            c.setSaldo(c.getSaldo() - this.getImporte());
            c.setSaldoDisponible(c.getSaldo());
        }
        this.setCuenta(c);
    }
}