//dado un numero que representa un año imprimir si es año bisiesto o no.

import java.util.*;

import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

/**
 * Ejercicio07
 */
public class Ejercicio07 {

    public static Scanner Teclado = new Scanner (System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese anio: ");
        anio = Teclado.nextInt();

    }

        private static boolean esAnioBisiesto(int anio) {
            if (anio % 4 == 0 && anio % 100 == 0 && anio % 400 == 0) {
                
            }

            return true;
            System.out.println("Es año bisiesto");


            
        }
    
}