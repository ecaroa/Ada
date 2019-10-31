package ar.com.ada.mongo.netfli.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Serie
 */

@Document(collection = "Series")
public class Serie extends Contenido {

    public List<Temporada> temporadas = new ArrayList<Temporada>();
    

    public Temporada getTemporada(int nro)
    {
        //Recorrer cada temporada
        //Si el nro de temporada del ciclo es igual a "nro"
        //Devolver esa temporada
        
        for (Temporada tempo : this.temporadas) {
            if(tempo.numeroTemporada == nro)
            {
                return tempo;
            }
            
        }

        return null;
    }
}