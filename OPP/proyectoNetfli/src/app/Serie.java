package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Serie
 */
public class Serie extends Contenido{
    public List<Temporada> temporadas =new ArrayList<Temporada>();


    public Temporada getTemporada(int nro){
        //Recorrer cada demporada
        //Si el "nro" de temporada del ciclo es igual a "nro"
        //Devolver temporada
        // forech dividido en dos parte, la primera es el objeto que quiero recorrer
        for (Temporada tempo : this.temporadas) { 
            if (tempo.numeroTemporada == nro)
            {
                return tempo;                
            }
        }

        return null;
    }
}