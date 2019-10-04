package ar.com.ada.billeteravirtual;

import javax.persistence.*;

/**
 * Dinero
 */
public class Dinero {

    @Id
    @Column(name = "moneda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monedaId;
    private String moneda;
    private double cantidad;

    private boolean esCursoLegal(){
        return false;
    }
}