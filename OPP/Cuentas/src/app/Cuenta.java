//titular
//cantidad
//2 constructores, setters, getter,ToString
//ingresar (cantidad)
//retirar (cantidad)


package app;


/**
 * Cuenta
 */
public class Cuenta {

    protected String titular;

    public double cantidad;

    public String getTitular() {
        if(this.titular.equals("Pepe"))
        return this.titular + "(VIP)";

        return titular
    }

    public void setTitular(String titular) {

        if (titular.equals("NADIE"))
            return;
        this.titular = titular;
    }
    
}