package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Puerto
 */
public class Puerto {

    public String nombre;
    public String lugar;
    public int nroPuerto;
    public List<Contenedor> contenedoresARecibir = new ArrayList<Contenedor>();
    public static List<Puerto> PuertosDelMundo = Puerto.GetPuertosDelMundo();

    // Cuando es static los clases van en mayuscula y los metodos tambien
    public static List<Puerto> GetPuertosDelMundo() {

        List<Puerto> puertos = new ArrayList<Puerto>();

        Puerto p = new Puerto();

        p.nroPuerto = 1;
        p.nombre = "Puerto Frutos";
        p.lugar = "El Tigre, BA";

        puertos.add(p);

        p = new Puerto();

        p.nroPuerto = 2;
        p.nombre = "Buena Suerte";
        p.lugar = "China";

        puertos.add(p);

        p = new Puerto();
        p.nroPuerto = 3;
        p.nombre = "La Guaira";
        p.lugar = "Venezuela";

        puertos.add(p);

        return puertos;
    }

    public static Puerto buscarPuerto(int nro) {
        for (Puerto p : PuertosDelMundo) {
            if (p.nroPuerto == nro)
                return p;
        }
        return null;
    }
}