package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Temporada
 */
public class Temporada {
    public int numeroTemporada;
    public List<Episodio> episodios = new ArrayList<Episodio>();

    public Episodio getEpisodio (int nro){
        for (Episodio epi : this.episodios) {
            if (epi.nroEpisodio ==nro){
                return epi;
            }
        }
        return null;
    }


    public Episodio getEpisodio(String nombre){
        for (Episodio epi : this.episodios) {
            if (epi.tituloEpisodio.equals(nombre)){
                return epi;
            }
            
        }
        return null;
    }

       /* public Websodio geteWebsodio(String nombre){
        for (Websodio web : this.episodios) {
            if (web.tituloWebsodio.equals(nombre)){
                return web;
            }
            
        }
        return null;
    } */


    


    
}