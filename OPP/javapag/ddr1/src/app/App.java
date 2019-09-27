package app;

public class App {
    public static void main(String[] args) throws Exception {

        Cuenta cuenta_1 = new Cuenta("DiscoDuroDeRoer");
        Cuenta cuenta_2 = new Cuenta("Fernando", 300);

        // Ingreso dinero en las cuentas
        cuenta_1.ingresar(300);
        cuenta_2.ingresar(400);

        // Retiramos dinero en las cuentas
        cuenta_1.retirar(500);
        cuenta_2.retirar(100);

        // Muestro la informacion de las cuentas
        System.out.println(cuenta_1); // 0 euros
        System.out.println(cuenta_2); // 600 euros
    }
}