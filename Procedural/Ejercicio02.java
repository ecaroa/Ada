//"Dado un  conjuntos de valores donde cada uno represente el sueldo del empleado excepto el ultimos que es 0 
// e indinca el final el conjunto

//cuantos empleados ganan menos de 520 pesos
//cuantos ganan entre 520 y 780 
//cuantos entre 780 y  999
//y cuantos ganana mas de 999"

import java.util.*;

public class Ejercicio02 {
    public static Scanner Teclado = new Scanner (System.in);

    public static void main (String[] args) {

        int a, c1, c2, c3, c4;

        c1 = 0;
        c2 = 0;
        c3 = 0;
        c4 = 0;

        System.out.println("Ingrese el sueldo: ");
        a = Teclado.nextInt();

        while (a > 0) {
            if (a < 520) {
                c1 = c1 + 1;
            }
            else {
                if (a <= 780 && a >= 520) {
                    c2 = c2 + 1;
                }
                else {
                    if (a <= 999 && a >= 780) {
                        c3 = c3 + 1;
                    }
                    else {
                        c4 = c4 + 1;
                    }
                }
            }
            System.out.println("Ingrese el sueldo: ");
            a = Teclado.nextInt();
        }

        /*

        */
        System.out.println("Ganan menos de 520 pesos: " + c1 + " empleados" );
        System.out.println("Ganan entre 520 y 780: " + c2 + " empleados" );
        System.out.println("Ganan entre 780 y  999: " + c3 + " empleados" );
        System.out.println("Ganan mas de 999: " + c4 + " empleados" );
    }
}
