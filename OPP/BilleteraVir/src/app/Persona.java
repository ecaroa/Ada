package app;

/**
 * Persona
 */
public class Persona {

    public String nombre;
    public int dni;
    public int edad;

    public Persona(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(int dni) {
        this.dni = dni;
    }

    public Persona() {
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + "]";
    }
}