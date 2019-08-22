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
    private char m;

    public Persona() {
        this.nombre = "Lucia";
        this.edad = 20;
        this.dni = 39444243;
        this.peso = 55.32;
        this.altura = 1.60;
        this.m = 'm';
    }

    public Persona(String nombre, int edad, char m) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = 39449400;
        this.peso = 60.10;
        this.altura = 1.70;
        this.m = m;
    }

    public Persona(String nombre, int edad, int dni, double peso, double altura, char m) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
        this.m = m;
    }

    public int calcularIMC(){
        double pesoActual = peso /

    }


    
    


}