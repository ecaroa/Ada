package ar.com.ada.api.nasa.entities;

import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

/**
 * Pais
 */
@Entity
@Table (name = "pais")
public class Pais {

    @Id
    @Column(name="pais_id")
    private int paisId;

    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
     private List<Temperatura> temperaturas = new ArrayList<Temperatura>();

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }

    public void agregarTemperatura(Temperatura temperatura){
        this.temperaturas.add(temperatura);
        temperatura.setPais(this);
    }
}