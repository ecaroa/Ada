package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Billetera
 */
@Entity
@Table(name = "billetera")
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;
    @OneToOne
    @JoinColumn(name= "persona_id", referencedColumnName = "persona_id")
    private Persona persona;
    @OneToMany (mappedBy = "billetera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    

    public Billetera(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public Billetera() {
	}

	public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta getCuenta(int index){
        return getCuentas().get(index);
    }

    public Billetera(Persona p) {
        this.setPersona(p);
        p.setBilletera(this);
    }

    public double consultarSaldo(Billetera b, String moneda) {
        double s = 0;
        for (Cuenta c : b.getCuentas()) {
            if (c.getMoneda().equals(moneda)){
                s = c.getSaldo();
            }
        }
        return s;
    }

    public double consultarSaldoDisponible(Billetera b, String moneda) {
        double s = 0;
        for (Cuenta c : b.getCuentas()) {
            if (c.getMoneda().equals(moneda)){
                s = c.getSaldoDisponible();
            }
        }
        return s;
    }   

    
    public void transferencia(Billetera bDestino, double importe) {
        movimientoTransferencia(-importe, this.getCuenta(0), bDestino.getCuenta(0));
        bDestino.movimientoTransferencia(importe, bDestino.getCuenta(0), this.getCuenta(0));
    }

    /**
     * Hace una transferencia entre cuentas principales.
     * 
     * @param importe
     * @param bOrigen
     * @param bDestino
     */
    public void movimientoTransferencia(double importe, Cuenta cuentaDesde, Cuenta cuentaHasta) {
        Movimiento m = new Movimiento();
        m.setImporte(importe);
        m.setCuenta(this.getCuenta(0));
        Date f = new Date();
        m.setConcepto(" ");
        m.setTipooperacion("Transferencia");
        m.setFechaMov(f);
        m.setCuentaOrigenId(cuentaDesde.getCuentaId());
        m.setCuentaDestinoId(cuentaHasta.getCuentaId());
        m.setDeUsuarioId(cuentaDesde.getUsuario().getUsuarioId());
        m.setaUsuarioId(cuentaHasta.getUsuario().getUsuarioId());
        cuentaDesde.setSaldo(cuentaDesde.getSaldo() + importe);
        cuentaDesde.setSaldoDisponible(cuentaDesde.getSaldoDisponible() + importe);
    }
    
}