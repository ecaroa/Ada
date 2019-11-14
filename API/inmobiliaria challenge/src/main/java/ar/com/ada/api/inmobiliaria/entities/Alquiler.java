package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Alquiler
 */
@Entity
@Table(name = "alquiler")
public class Alquiler implements IOperable {

    @Id
    @Column(name = "alquiler_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear IEsOperable con aviso
    @Column(name = "tipo_alquiler")
    private String tipoAlquiler;
    private String moneda;
    private double valor;
    @Column(name = "plazo_meses")
    private int plazoMeses;
    @OneToOne
    @JoinColumn(name = "aviso_id", referencedColumnName = "aviso_id")
    @JsonIgnore
    private Aviso aviso;

    public String getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(String tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alquiler";
    }

}