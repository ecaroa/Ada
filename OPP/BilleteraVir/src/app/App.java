package app;

import java.util.*;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Para agregar una persona presione 1.");
        System.out.println("Para eliminar una persona presione 2.");
        System.out.println("Para modificar una persona presione 3.");
        System.out.println("Para ver el listado presione 4.");
        System.out.println("Para terminar presione 0.");
        System.out.println("");
        System.out.println("=======================================");

        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        while (opcion > 0) {

            switch (opcion) {
            case 1:
                alta();
                break;

            case 2:
                baja();
                break;

            case 3:
                modifica();
                break;

            case 4:
                listar();
                break;

            default:
                System.out.println("La opcion no es correcta.");
                break;
            }

            System.out.println("=======================================");
            System.out.println("");
            System.out.println("Para agregar una persona presione 1.");
            System.out.println("Para eliminar una persona presione 2.");
            System.out.println("Para modificar una persona presione 3.");
            System.out.println("Para ver el listado presione 4.");
            System.out.println("Para terminar presione 0.");
            System.out.println("");
            System.out.println("=======================================");

            opcion = Teclado.nextInt();
            Teclado.nextLine();
        }

    }

    public static void alta() {
        Persona p = new Persona();
        System.out.println("Ingrese el nombre:");
        p.nombre = Teclado.nextLine();
        System.out.println("Ingrese el DNI:");
        p.dni = Teclado.nextInt();
        Teclado.nextLine();
        System.out.println("Ingrese la edad:");
        p.edad = Teclado.nextInt();
        Teclado.nextLine();
        ABM.Personas.add(p);
    }

    public static void baja() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = null;

        for (Persona p : ABM.Personas) {
            if (p.nombre.equals(n) && id == p.dni) {
                personaEncontrada = p;
            }
        }
        if (!personaEncontrada.nombre.equals(n) || id != personaEncontrada.dni) {
            System.out.println("Persona no encontrada.");
        }
        ABM.Personas.remove(personaEncontrada);
        if (personaEncontrada != null) {
            System.out.println("El registro de " + personaEncontrada.dni + " ha sido eliminado.");
        }
    }

    public static void modifica() {
        System.out.println("Ingrese el nombre de la persona a modificar:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI de la persona a modificar:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = null;

        for (Persona p : ABM.Personas) {
            if (p.nombre.equals(n) && id == p.dni) {
                System.out.println(p.toString() + "seleccionado para modificacion.");
                System.out.println("Ingrese el nuevo nombre:");
                p.setNombre(Teclado.nextLine());
                System.out.println("Ingrese el nuevo DNI:");
                p.setDni(Teclado.nextInt());
                Teclado.nextLine();
                System.out.println("Ingrese la nueva edad:");
                p.setEdad(Teclado.nextInt());
                Teclado.nextLine();
                personaEncontrada = p;
                break;
            }
        }
        if (!personaEncontrada.nombre.equals(n) || id != personaEncontrada.dni) {
            System.out.println("Persona no encontrada.");
        }
        if (personaEncontrada != null) {
            System.out.println("El registro de " + personaEncontrada.dni + " ha sido modificado.");
        }
    }

    public static void listar() {
        for (int i = 0; i < ABM.Personas.size(); i++) {
            System.out.println(ABM.Personas.get(i));
        }
    }
}