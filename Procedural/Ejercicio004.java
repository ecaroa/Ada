//la tienda realina N ventas durante un día y se requiere saber 
//cuantas fueron mayor a 1000
//cuantas mayor a 500 pero menores o iguales a 1000
//cuantas fueron menores o iguales a 500
//se re quiere saber lo vendido en cada categoria y global

import java.util.*;

/**
 * Ejercicio004
 */
public class Ejercicio004 {

    public static Scanner Teclado = new Scanner (System.in);

    public static void main(String[] args) {
        
        double  CN, V, TotalA, TotalB, TotalC, TotalV;
        int A, B, C;

        TotalA = 0;
        TotalB = 0;
        TotalC = 0;
        A = 0;
        B = 0;
        C = 0;
        TotalV = 0;
        CN = 1;

        System.out.println("Ingrese valor: ");
        V = Teclado.nextDouble();
        

        while (V > 0) {
            if (V > 1000) {
                A = A + 1;
                TotalA = TotalA + V;
            }
            else {
                if (V > 500) {
                    B = B + 1;
                    TotalB = TotalB + V;
                }
                else {
                    C = C + 1;
                    TotalC = TotalC + V;
                }
            }
            TotalV = TotalV + V;
            CN = CN + 1;
            System.out.println("Ingrese valor: ");
            V = Teclado.nextDouble();

            
        }

        System.out.println("Fueron mayor a 1000: " + A + " veces");
        System.out.println("Fueron mayor a 500: " + B + " veces");
        System.out.println("Fueron menor a 500: " + C + " veces");
        
        System.out.println("El total que fueron mayor a 1000: " + TotalA);
        System.out.println("El total que fueron mayor a 500: " + TotalB);
        System.out.println("El total que fueron menor a 500: " + TotalC);
        System.out.println("El total de ventas es: " + TotalV);
    
    }
}
