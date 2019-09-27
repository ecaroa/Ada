package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Buque
 */
public class Buque {

    public List<Contenedor> losContenedores = new ArrayList<Contenedor>();
    public String nombre;

    // metodos
    public int calcularPeso() {
        int suma = 0;
        for (Contenedor c : this.losContenedores) {
            suma += c.peso;
        }
        return suma;

    }

    // devuelve el objeto contenedor que tenga el peso maximo
    public Contenedor getContenedorMaximo()
     {
        Contenedor maxCont = null;
        int maxPeso;
        
        maxPeso = 0;

        for (Contenedor c : this.losContenedores) {
            if (c.peso > maxPeso){
                maxPeso = c.peso;
                maxCont = c;

            }
        }
        
        return maxCont;
    }

    public static Buque NuevoBuqueCargado() {
        Buque barco = new Buque();
        barco.nombre = "ADA express";

        barco.losContenedores = new ArrayList<Contenedor>();

        for (int i = 1; i <= 100; i++) {
            Contenedor c = new Contenedor();

            c.idContenedor = 3000 + i;

            c.peso = 7 * i;

            c.puertoArribo = Puerto.buscarPuerto((i % 3) + 1);

            barco.losContenedores.add(c);

        }
        return barco;

    }
}