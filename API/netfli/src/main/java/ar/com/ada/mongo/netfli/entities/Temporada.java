package ar.com.ada.mongo.netfli.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Temporada
 */
public class Temporada {

    public int numeroTemporada;
    public List<Episodio> episodios = new ArrayList<Episodio>();
    

    public Episodio getEpisodio(int nro)
    {
        //Recorrer cada episodio
        //Si el nro de episodio del ciclo es igual a "nro"
        //Devolver esa episodio
        
        for (Episodio epi : this.episodios) {
            if(epi.nroEpisodio == nro)
            {
                return epi;
            }
            
        }

        return null;
    }

    
}