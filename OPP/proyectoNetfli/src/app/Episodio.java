package app;

/**
 * Episodio
 */
public class Episodio {

    public int nroEpisodio;
    public String tituloEpisodio;
    public int duracion;

    public void reproducir (){
        System.out.println("Reproduciendo " + this.tituloEpisodio + " " + this.nroEpisodio);
        return;
    }


    public Episodio (String tit){
        this.tituloEpisodio = tit;
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