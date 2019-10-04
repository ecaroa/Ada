package ar.com.ada.billeteravirtual;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.*;

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
    private String moneda; // monedaId?
    private double saldo; // (balance)
    private double saldoDisponible;
    // private String nroCuenta; // (univoco)
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;
    @OneToMany (mappedBy = "cuenta", cascade = CascadeType.ALL)
    @LazyCollection (LazyCollectionOption.FALSE)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>(); // (puede necesitar tabla intermedia)

    public static Scanner Teclado = new Scanner(System.in);

    void dineroPendiente() {

    }

    void ultimosMovimientos() {

    }

    void dineroIngresado() {

    }

    void dineroExtraido() {

    }

    public Cuenta(int cuentaId, String moneda) {
        this.cuentaId = cuentaId;
        this.moneda = moneda;
    }

    public Cuenta() {
    }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
        this.billetera.getCuentas().add(this);
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    //falta poner límite para no tener saldos negativos
    public double getSaldoDisponible() {
        return saldo;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    // Adaptar para sacar el print del método.
    public Cuenta(Billetera b) {
        System.out.println("Creacion de cuenta. Seleccione la moneda: \n1: U$S \n2: AR$");
        int opcionMoneda = Teclado.nextInt();
        switch (opcionMoneda) {
        case 1:
            this.setMoneda("U$S");
            break;
        case 2:
            this.setMoneda("AR$");
            break;
        default:
            break;
        }

    }

    public Usuario getUsuario(){

        Usuario u = this.getBilletera().getPersona().getUsuario();
        return u;
        
    }

    
}