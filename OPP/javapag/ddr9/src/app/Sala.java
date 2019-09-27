package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Sala
 */
public class Sala {

    public Pelicula peli;
    public List<Fila> filas = new ArrayList<>();

    /** Contrurores */
    public Sala(Pelicula peli) {
        this.peli = peli;
    }

    /**
     * Agrega una fila delegando la creacion de asientos a la fila
     * 
     * @param letra
     * @param cantAsientos
     */

    public void agregarFila(char letra, int cantAsientos) {
        Fila f = new Fila();
        f.letra = letra;
        f.agregarAsientos(cantAsientos);

        filas.add(f);

    }

    /**
     * Devuelve el primer asiento disponible que encuentre
     * 
     * @return
     */
    public Asiento proximoAsientoDisponibleParaEspectador() {
        for (Fila f : filas) {
            for (Asiento a : f.asientos) {
                if (!a.ocupado())
                    return a;

            }
        }
        return null;
    }

    /**
     * Devuelve la lista de asientos disponibles
     * 
     * @return
     */
    public List<Asiento> asientosLibres() {
        List<Asiento> r = new ArrayList<>();

        for (Fila f : filas) {
            for (Asiento a : f.asientos) {
                if (!a.ocupado())
                    r.add(a);
            }
        }
        return r;
    }

    /**
     * reusando la funcion de asientosLibres() devuelve la cantidad de asientos
     * libres que hay
     * 
     * @return
     */
    public int cantAsientosLibres() {
        return this.asientosLibres().size();
    }

    public boolean puedeVer(Espectador espectador) {

        return peli.getEdadMinima() > espectador.getEdad();

    }
}