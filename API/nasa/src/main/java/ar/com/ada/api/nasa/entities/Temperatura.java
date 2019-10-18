package ar.com.ada.api.nasa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * temperatura
 */
@Entity
@Table
public class Temperatura {
    @Id
    @Column(name="temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int temperaturaId;

    @ManyToOne
    @JoinColumn(name="pais_id", referencedColumnName = "pais_id")
    private Pais pais;
    
    @Column (name="anio_temperatura")
    private int aniosTemperatura;
    
    private double grados;

    public int getTemperaturaId() {
        return temperaturaId;
    }

    public void setTemperaturaId(int temperaturaId) {
        this.temperaturaId = temperaturaId;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getAniosTemperatura() {
        return aniosTemperatura;
    }

    public void setAniosTemperatura(int aniosTemperatura) {
        this.aniosTemperatura = aniosTemperatura;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

}