package ar.com.ada.billeteravirtual;

/**
 * Coordenada
 */
public class Coordenada {

    private float latitud;
    private float longitud;

    public Coordenada(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Coordenada() {
    }
    
    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Coordenada [latitud=" + latitud + ", longitud=" + longitud + "]";
    }


}