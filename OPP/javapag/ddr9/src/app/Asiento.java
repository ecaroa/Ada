package app;

/**
 * Asiento
 */
/**
 * Clase asiento, se usa para manejar toda la informacion relativa al asiento
 *
 * @author DiscoDurodeRoer
 */

public class Asiento {

    /* Atributos */
    private char letra;
    private int nroAsiento;
    private Espectador espectador; // informacion del espectador que esta sentado, null si es vacio

    /* Constructores */
    public Asiento(char letra, int nro) {
        this.letra = letra;
        this.nroAsiento = nro;
        this.espectador = null; // al iniciar el asiento, no habra nadie sentado

    }

    /** Metodos */
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(int nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    /**
     * Indica si el asiento esta ocupado
     * 
     * @return
     */
    public boolean ocupado() {
        return espectador != null;
    }

    @Override
    public String toString() {
        if (ocupado()) {
            return "Asiento " + letra + this.nroAsiento + "y " + espectador;
        }

        return "Asiento " + letra + nroAsiento + "y este asiento está vacio";
    }

}