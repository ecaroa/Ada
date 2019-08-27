package app;

/**
 * Clase Cine, lleva todo lo relativo al cine
 *
 * @author DiscoDurodeRoer
 */

/**
 * Cine
 */
public class Cine {

    /*Atributos*/
    private Sala sala;
    private double precio;
    private Pelicula pelicula;
 
    /**Constructor */
    public Cine(Sala sala, double precio, Pelicula pelicula) {
        
        this.precio = precio;
        this.pelicula = pelicula;
    }

    /**Metodo */
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

      
    /**
     * Indicamos si el espectador cumple lo necesario para entrar: - Tiene
     * dinero - Tiene edad El tema de si hay sitio, se controla en el main
     *
     * @param e
     * @return
     */

     public boolean sePuedeSentar(Espectador e){
         return e.tieneDinero(precio) && e.tieneEdad(pelicula.getEdadMinima());
     }


      /**
     * Mostramos la información de nuestro cine (Tambien se puede hacer en un
     * toString pero hay que devolver un String)
     */
    public void mostrar (){

        System.out.println("Informacion cine");
        System.out.println("Pelicula reproducida: " + pelicula);
        System.out.println("Precio entrada: " + precio);
    }


}