import java.util.*;
/**
* ejercicio09
*
*/
public class EjercicioBisiesto {
   public static Scanner Teclado = new Scanner(System.in);
   /*
    * solo para ingresar datos, teclado es el nombre q le pongo podria ser cualq
    * cosa
    */
   public static void main(String[] args) {
       int anio;
       System.out.println("Ingrese el año");
       anio = Teclado.nextInt();
       if (esbisiesto(anio)) {
           System.out.println("el año " + anio + " es bisiesto");
       } else {
           System.out.println("el año " + anio + " no es bisiesto");
       }
   }
   private static Boolean esbisiesto(int anio) {
       if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
           return true;
       } else {
           return false;
           //se podria hacer asi://
          // return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) //
       }
   }
}