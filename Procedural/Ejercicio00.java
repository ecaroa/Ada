import java.util.*;

public class Ejercicio00 {
    
    public static Scanner Teclado = new Scanner (System.in);
    
    public static void main (String[] args) {

        double a,b,c;

        System.out.println("Ingrese el primer número: ");
        a = Teclado.nextDouble();
        
        System.out.println("Ingrese el segundo número: ");
        b = Teclado.nextDouble();

        System.out.println("Ingrese el tercer número: ");
        c = Teclado.nextDouble();

        c = (a + b);

        System.out.println("La multiplicacion es:" + c);

    }
}