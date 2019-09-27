package app;

public class App {
    public static void main(String[] args) throws Exception {

        
        System.out.println("Iniciando Catalogo");
        Netflix.InicializarCatalogo();

        Serie bb = Netflix.getnomSerie("Breaking Bad");
        
        Temporada laMejorTemporada = bb.getTemporada(5);
        
        Episodio elTop;
        
        elTop = laMejorTemporada.getEpisodio(10);
        
        elTop.reproducir();
    }
}