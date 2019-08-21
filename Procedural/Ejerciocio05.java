
import java.util.*;

/**
 * Ejerciocio05
 */
public class Ejerciocio05 {
    public static Scanner Teclado = new Scanner (System.in);

    public static void main(String[] args) {
        
        int zona;
        double gramos, costo1, costo2, costo3, costo4, costo5, costototal;
         

        costo1 = 11.00;
        costo2 = 10.00;
        costo3 = 12.00;
        costo4 = 24.00;
        costo5 = 27.00;

        System.out.println("Seleccione la zona para enviar el paquete: ");
        System.out.println("1 - América del Norte ");
        System.out.println("2 - América del Central ");
        System.out.println("3 - América del Sur ");
        System.out.println("4 - Europa ");
        System.out.println("5 - Asia ");
        
        System.out.println("Ingrese zona: ");
        zona = Teclado.nextInt();

        System.out.println("Ingrese en gramos el peso del paquete: ");
        gramos = Teclado.nextDouble();

        if (gramos < 5000) { 

        switch (zona) {
            case 1:
            costototal = gramos * costo1;
            System.out.println("El monto a pagar para America del Norte es: " + costototal + " $");                
                break;

            case 2:
            costototal = gramos * costo2;
            System.out.println("El monto a pagar para America Central es: " + costototal + " $");              
                break;

            case 3:
            costototal = gramos * costo3;
            System.out.println("El monto a pagar para America del Sur es: " + costototal + " $");               
                break;

            case 4:
            costototal = gramos * costo4;
            System.out.println("El monto a pagar para Europa es: " + costototal + " $");                
                break;

            case 5:
            costototal = gramos * costo5;
            System.out.println("El monto a pagar para Asia es: " + costototal + " $");               
                break;

        
            default:
                break;
        }
      }
      else {
          System.out.println("SUPERA LIMITE DE PESO!");
      }
    


    }


}