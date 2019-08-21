package app;

/**
 * Websodio
 */
public class Websodio extends Episodio{
    public String tituloWebsodio;


public Websodio (String tit){
super(tit);
}

public void reproducir (){
    System.out.println("Reproduciendo Websodio " + this.tituloEpisodio + " " + this.nroEpisodio);
    return;
}


}