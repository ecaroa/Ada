/* https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java */

package app;

/**
 * Persona
 */
public class Persona {

    private String nombre;
    private int edad;
    private int dni;
    private double peso;
    private double altura;
    private char sexo;

    /**
     * El peso de la persona esta por debajo del peso ideal
     */
    public static final int INFRAPESO = -1;

    /**
     * El peso de la persona esta en su peso ideal
     */
    public static final int PESO_IDEAL = 0;

    /**
     * El peso de la persona esta por encima del peso ideal
     */
    public static final int SOBREPESO = 1;

    public Persona() {
        this.nombre = "Lucia";
        this.edad = 20;
        this.dni = 39444243;
        this.peso = 55.32;
        this.altura = 1.60;
        this.sexo = 'm';
    }

    public Persona(String nombre, int edad, char m) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = 39449400;
        this.peso = 60.10;
        this.altura = 1.70;
        this.sexo = 'm';
    }

    public Persona(String nombre, int edad, int dni, double peso, double altura, char m) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
        this.sexo = 'm';
    }

    public int calcularIMC() {
        double pesoActual = peso / (Math.pow(altura, 2));
        // segun el peso, devuelve un un codigo
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad(){
        boolean mayor = false;
        if (edad >=18){
            mayor=true;
        }
        return mayor;
    }

    @Override
    public String toString() {
        String sexo;
        if (this.sexo == 'h');{
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona: \n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + edad + " años\n"
                + "DNI: " + dni + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
