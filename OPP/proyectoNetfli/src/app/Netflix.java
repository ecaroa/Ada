package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Nexflix
 */
public class Netflix {

    public static List<Pelicula> CatalogoPelis = new ArrayList<Pelicula>();//
    public static List<Serie> CatalogoSeries = new ArrayList<Serie>();
        
    public static Pelicula getnomPelicula(String peli){
        for (Pelicula pe : CatalogoPelis) {
            if (pe.nombre.equals(peli)) {
                return pe;
            }
            
        }
        return null;
    }
    public static Serie getnomSerie(String serie){
        for (Serie ser : CatalogoSeries) {
            if(ser.nombre.equals(serie)){
                return ser;
            }
            
        }
        return null;
    }

    public static void InicializarCatalogo()
    {
            Netflix.AgregarBreakingBad();
    }

    public static void AgregarBreakingBad()
    {
            
            Serie breakingB = new Serie();
            breakingB.nombre = "Breaking Bad";
            breakingB.año = 2008;
            breakingB.genero = "Drama";
            
            Temporada t5 = new Temporada();
            t5.numeroTemporada = 5;
            
            Episodio ep = new Episodio("Say my name");
            
            ep.nroEpisodio = 7;
            ep.duracion = 43;
            //ep.tituloEpisodio = "Say my name";

            t5.episodios.add(ep);

            Episodio epOtro = new Episodio("Ozymandias");
            
            epOtro.nroEpisodio =5;            
            epOtro.duracion = 41;
            //epOtro.tituloEpisodio = "Ozymandias";
            
            t5.episodios.add(epOtro);

            breakingB.temporadas.add(t5);

            Websodio web1 = new Websodio("Primer Websodio");

            web1.nroEpisodio = 10;
            web1.duracion = 30;
            t5.episodios.add(web1);




            Netflix.CatalogoSeries.add(breakingB);
    }



    }




    //METODO STATIC CREAR UNA SERIE CON SUS TEMP Y CAP EN CATALOGO CATALOGO.ADD
