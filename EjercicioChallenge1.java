/*Devolver la suma de elementos de un arrays, el nro 13 es de mala suerte asi que no debe sumarse 
ignorar tambien el numero siguiente al 13.*/

import java.util.*;


/**
 * EjercicioChallenge1
 */
public class EjercicioChallenge1 {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int n;
        int suma = 0;

        System.out.println("Ingrese cant nros");
        n = Teclado.nextInt();

        boolean hay13=false;

        //declaro el array de N posiciones
        int[] nros = new int[n];
        
        //recorro el array para llenarlo
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el nro");
        
            nros[i] = Teclado.nextInt();
        }

        //aca recorro y pregunto por 13
        for (int i = 0; i < n; i++) {
            if (nros[i] == 13) {
                hay13 = true;
            } else {
                if (!hay13) {

                    suma = suma + nros[i];
                } else {
                    hay13 = false;
                }
            }

        }

        System.out.println("La suma es" + suma);
    }

    public static int sum13v1(int[] nros)
    {
        boolean hay13=false;
        int suma = 0;
        for (int i = 0; i < nros.length; i++) {
            if (nros[i] == 13) {
                hay13 = true;
            } else {
                if (!hay13) {

                    suma = suma + nros[i];
                } else {
                    hay13 = false;
                }
            }

        }
        return suma;
    }

    public static int sum13v2(int[] nros)
    {
        int suma = 0;
        for (int i = 0; i < nros.length; i++) {
            if (nros[i] == 13) {
                i++;
            }
            else{

                    suma = suma + nros[i];
                }

        }
        return suma;
    }
}
}