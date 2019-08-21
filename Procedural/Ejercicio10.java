/*Dado dos arrays de numers enteros de 7 posiciones generar un 3er arrays con 7 elementos, 
donde cada elemento sea la suma de los dos arrays anteriores */

import java.util.*;
/**
 * Ejercicio10
 */
public class Ejercicio10 {

    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Ingrese oración");
        String oracion = Teclado.nextLine();
        char cs[] = oracion.toCharArray(); //
 
        int vocales = 0;
        int espacios = 0;
        
        for (int i = 0; i < cs.length; i++) { //
            if (esVocal(cs[i])) {
            vocales++;
            } else if (cs[i] == ' ') {
            espacios++;
            }
        }
        System.out.println("La cantidad de vocales es " + vocales);
        System.out.println("La cantidad de espacios " + espacios);
    }

    static boolean esVocal(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
    

    
}



