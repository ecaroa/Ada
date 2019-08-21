/*. El dueño de un estacionamiento requiere un diagrama de flujo con el algoritmo que le
permita determinar cuánto debe cobrar por el uso del estacionamiento a sus clientes.
Las tarifas que se tienen son las siguientes:
a. Las dos primeras horas a $5.00 c/u.
b. Las siguientes tres a $4.00 c/u.
c. Las cinco siguientes a $3.00 c/u.
d. Después de diez horas el costo por cada una es de dos pesos. */

import java.util.*;

/**
 * Ejercicio06
 */
public class Ejercicio06 {

    public static Scanner Teclado = new Scanner (System.in);

    public static void main(String[] args) {
        
        double horas, horatotal, valorhoras1, valorhoras2, valorhoras3, valorhoras4;

        valorhoras1 = 5.00;
        valorhoras2 = 4.00;
        valorhoras3 = 3.00;
        valorhoras4 = 2.00;
        

        System.out.println("Ingrese las horas de estacionamiento");
        horas = Teclado.nextDouble();

        while (horas > 0) {
            if (horas <= 2) {
                horatotal = valorhoras1 * horas;
            }
            else {
                if (horas > 2 && horas <= 5) {
                    horatotal = (valorhoras1 * 2) + (valorhoras2 * horas);
                }
                else{
                    if (horas >5 && horas <= 10) {
                        horatotal = (valorhoras1 * 2) + (valorhoras2 * 3) + (valorhoras3 * horas);
                    }
                    else {
                        horatotal = (valorhoras1 * 2) + (valorhoras2 * 3) + (valorhoras3 * 5) + (valorhoras4 * horas);
                    }
                }
            }
            
        }



    }
    
}
