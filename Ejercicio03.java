//Un conjunto de 15 valores positivos desarrollar un programa que imprima el valor maximo dentro del 
//conjunto y su posicion relativa

import java.util.*;

/**
 * Ejercicio03
 */
public class Ejercicio03 {
    public static Scanner Teclado = new Scanner (System.in);

    public static void main(String[] args) {

        int valor, valorMax, posMax;

        valorMax = 0;
        posMax = -1;

        for (int i = 1; i <= 15; i++) {
            System.out.println("Ingrese un valor: ");
        valor = Teclado.nextInt();
        if (valor > valorMax) {
            valorMax = valor;
            posMax = i; 
        }

        }
        System.out.println("El valor maximo es: " + valorMax + " , en la posicion: " + posMax);


       

        
    }

    
}