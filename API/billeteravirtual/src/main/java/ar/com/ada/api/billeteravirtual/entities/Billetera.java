package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * BilleteraVirtual
 */
@Entity
@Table(name = "billetera")
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    @OneToMany(mappedBy = "billetera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
        cuenta.setBilletera(this);
    }

    public void agregarPlata(BigDecimal plata,String moneda, String concepto, String detalle) {
        // Agarro el primero y le meto plata (esto se hacia antes porqeu le agregaba a la primer cuenta)
        //this.cuentas.get(0).agregarPlata(persona.getUsuario().getUsuarioId(), concepto, plata, detalle);
        this.buscarCuenta(moneda).agregarPlata(persona.getUsuario().getUsuarioId(), concepto, plata, detalle);
    
    }

    public void descontarPlata(BigDecimal plata,String moneda, String concepto, String detalle) {
        this.buscarCuenta(moneda).agregarPlata(persona.getUsuario().getUsuarioId(), concepto, plata, detalle);
    
    }

    

    /* public void transferencia(Billetera bDestino, BigDecimal importe) {
        movimientoTransferencia(-importe, this.getCuentas(), bDestino.getCuentas());
        bDestino.movimientoTransferencia(importe, bDestino.getCuentas(), this.getCuentas());
    } /*

    /**
     * Hace una transferencia entre cuentas principales.
     * 
     * @param importe
     * @param bOrigen
     * @param bDestino
     */
   /*public void movimientoTransferencia(BigDecimal importe, Cuenta cuentaDesde, Cuenta cuentaHasta) {
        Movimiento m = new Movimiento();
        m.setImporte(importe);
        m.setCuenta(this.getCuentas(0));
        Date f = new Date();
        m.setConceptoOperacion(" ");
        m.setTipoOperacion("Transferencia");
        m.setFechaMovimiento(f);
        m.setDeCuentaId(cuentaDesde.getCuentaId());
        m.setaCuentaId(cuentaHasta.getCuentaId());
        m.setDeUsuarioId(cuentaDesde.getUsuario().getUsuarioId());
        m.setaUsuarioId(cuentaHasta.getUsuario().getUsuarioId());
        cuentaDesde.setSaldo(cuentaDesde.getSaldo() + importe);
        cuentaDesde.setSaldoDisponible(cuentaDesde.getSaldoDisponible() + importe);
    } */

    private Cuenta buscarCuenta (String moneda){
        for (Cuenta cta : this.cuentas) {
            if (moneda.equals(cta.getMoneda())) {
                return cta;
            }
            
        }

        return null;
    }

    public BigDecimal consultarSaldoCuentaUnica()
    {
        return this.cuentas.get(0).getSaldo();
    }
}