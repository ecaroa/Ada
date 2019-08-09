
/*Dado 10 numeros que representan edades calcular el promedio, imprimirle 
y luego imprimir todas las edades que ingresaron*/

import java.util.*;

/**
 * Ejercicio0909ejearray
 */
public class Ejercicio09ejearray {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int[] edades = new int[10];
        int suma = 0;
        int prom = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese el nro#" + i);

            int numero;
            numero = Teclado.nextInt();

            edades[i] = numero;
        }

        for (int i = 0; i < 10; i++) {
            suma += edades[i]; /* es lo mismo que ---> suma = suma + edades [i]; */
        }
        prom = suma / 10;
        System.out.println("El promedio es " + prom);

        for (int i = 0; i < 10; i++) {
            System.out.println("edad " + edades[i]);

        }

    }
}