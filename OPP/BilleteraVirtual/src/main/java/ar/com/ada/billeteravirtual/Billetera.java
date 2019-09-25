package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Billetera
 */
@Entity
@Table(name= "billetera")
public class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billetera_id;
    
    
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    //@MapsId
    private Persona persona;

    @OneToMany(mappedBy = "billetera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        
    }

    public List<Cuenta> getCuentas(){
        return cuentas;
    }

    public void setCuenta(List<Cuenta> cuentas){
        this.cuentas = cuentas;
    }

    public void agregarCuenta (Cuenta cuenta){
        cuenta.setBilletera(this);
        this.cuentas.add(cuenta);
    }

    public int getBilletera_id() {
        return billetera_id;
    }

    public void setBilletera_id(int billetera_id) {
        this.billetera_id = billetera_id;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}