package ar.com.ada.billeteravirtual;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.exception.ConstraintViolationException;

import ar.com.ada.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.billeteravirtual.security.Crypto;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static PersonaManager ABMPersona = new PersonaManager();
    public static UsuarioManager ABMUsuario = new UsuarioManager();
    public static BilleteraManager ABMBilletera = new BilleteraManager();
    public static CuentaManager ABMCuenta = new CuentaManager();
    public static MovimientoManager ABMMovimiento = new MovimientoManager();

    public static void main(String[] args) throws Exception {

        try {

            ABMPersona.setup();
            ABMUsuario.setup();
            ABMBilletera.setup();
            ABMCuenta.setup();
            ABMMovimiento.setup();

            // transferencia(12, 14, 50);

            printOpciones();

            int opcion = Teclado.nextInt();
            Teclado.nextLine();

            while (opcion > 0) {

                switch (opcion) {
                case 1:

                    try {
                        alta();
                    } catch (PersonaEdadException exedad) {
                        System.out.println("La edad permitida es a partir de 18 anios.");
                    }
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

                case 5:
                    listarPorNombre();
                    break;
                case 6:
                    consultaSaldo();
                    break;
                case 7:
                    transferir();
                    break;

                default:
                    System.out.println("La opcion no es correcta.");
                    break;
                }

                printOpciones();

                opcion = Teclado.nextInt();
                Teclado.nextLine();

            }

            // Hago un safe exit del manager
            ABMPersona.exit();
            ABMUsuario.exit();
            ABMBilletera.exit();
            ABMCuenta.exit();
            ABMMovimiento.exit();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Que lindo mi sistema, se rompio mi sistema.");
            throw e;
        } finally {
            System.out.println("Saliendo del sistema, bye bye...");

        }

    }

    public static void alta() throws Exception {
        Persona p = new Persona();
        System.out.println("Ingrese el nombre:");
        p.setNombre(Teclado.nextLine());
        System.out.println("Ingrese el DNI:");
        p.setDni(Teclado.nextLine());
        System.out.println("Ingrese la edad:");
        p.setEdad(Teclado.nextInt());

        Teclado.nextLine();
        System.out.println("Ingrese el Email:");
        p.setEmail(Teclado.nextLine());

        System.out.println("Persona generada con exito. " + p.getNombre());

        Usuario u = new Usuario();
        u.setUserName(p.getEmail());
        System.out.println("Su nombre de usuario es " + u.getUserName());
        System.out.println("Ingrese su password:");

        String passwordEnTextoClaro;
        String passwordEncriptada;
        String passwordEnTextoClaroDesencriptado;

        passwordEnTextoClaro = Teclado.nextLine();
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());
        passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUserName());

        System.out.println("Tu password encriptada es: " + passwordEncriptada);
        System.out.println("Tu password desencriptada es: " + passwordEnTextoClaroDesencriptado);

        if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado)) {
            System.out.println("Ambas passwords coinciden");
        } else {
            System.out.println("Las passwords no coinciden, nunca debio entrar aqui");
        }

        u.setPassword(passwordEncriptada);
        // System.out.println("Su mail es:");
        u.setUserEmail(p.getEmail());

        p.setUsuario(u);

        System.out.println("Usuario generado con exito. ID: " + u.getUserName());

        ABMPersona.create(p);

        Billetera b = new Billetera(p);
        Cuenta c = new Cuenta(b);

        c.setBilletera(b);
        ABMBilletera.create(b);

        System.out.println("Billetera generada con exito. ID: " + b.getBilleteraId());
        System.out.println("Cuenta generada con exito. ID: " + c.getCuentaId());

        Movimiento m = new Movimiento(c, u);

        ABMBilletera.update(b);
    }

    public static void consultaSaldo() {
        System.out.println("Consultar saldo: ingrese ID Billetera.");
        int id = Teclado.nextInt();
        Billetera b = ABMBilletera.read(id);

        System.out.println("Elija la cuenta \n1: U$S \n2: AR$");
        String moneda;
        int opcionMoneda = Teclado.nextInt();
        switch (opcionMoneda) {
        case 1:
            moneda = "U$S";
            break;
        case 2:
            moneda = "AR$";
            break;
        default:
            moneda = null;
            break;
        }
        if (moneda.equals(null)) {
            System.out.println("La billetera no posee una cuenta con esa moneda.");
        } else {
            System.out.println("El saldo en su cuenta es " + b.consultarSaldo(b, moneda) + ".");
            System.out.println("El saldo disponible en su cuenta es " + b.consultarSaldoDisponible(b, moneda) + ".");
        }

    }

    public static void baja() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el ID de Persona:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.read(id);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            // en esta version, como hicimos join column y cascade.ALL, delete se aplica a
            // todo lo vinculado
            // así que este try/catch no hace nada
            try {

                ABMPersona.delete(personaEncontrada);
                System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");

            } catch (ConstraintViolationException exPersonaConUsuario) {
                System.out.println("No se puede eliminar una persona que tenga usuario");

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Ocurrio un error al eliminar una persona.Error: " + e.getCause());
            }

        }
    }

    public static void bajaPorDNI() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI de Persona:");
        String dni = Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.readByDNI(dni);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            ABMPersona.delete(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");
        }
    }

    public static void modifica() throws Exception {

        System.out.println("Desea modificar un dato de la persona o del usuario? \n1:persona \n2: usuario");
        int seleccion = Teclado.nextInt();

        if (seleccion == 1) {

            System.out.println("Ingrese el ID de la persona a modificar:");
            int id = Teclado.nextInt();
            Teclado.nextLine();
            Persona personaEncontrada = ABMPersona.read(id);

            if (personaEncontrada != null) {

                System.out.println(personaEncontrada.toString() + "seleccionado para modificacion.");

                System.out.println(
                        "Elija qué dato de la persona desea modificar: \n1: nombre, \n2: DNI, \n3: edad, \n4: email");
                int selecper = Teclado.nextInt();

                switch (selecper) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    Teclado.nextLine();
                    personaEncontrada.setNombre(Teclado.nextLine());

                    break;
                case 2:
                    System.out.println("Ingrese el nuevo DNI:");
                    Teclado.nextLine();
                    personaEncontrada.setDni(Teclado.nextLine());

                    break;
                case 3:
                    System.out.println("Ingrese la nueva edad:");
                    Teclado.nextLine();
                    personaEncontrada.setEdad(Teclado.nextInt());

                    break;
                case 4:
                    System.out.println("Ingrese el nuevo Email:");
                    Teclado.nextLine();
                    personaEncontrada.setEmail(Teclado.nextLine());

                    break;

                default:
                    break;
                }

                Teclado.nextLine();
                ABMPersona.update(personaEncontrada);
                System.out.println("El registro de " + personaEncontrada.getNombre() + " ha sido modificado.");

            } else {
                System.out.println("Persona no encontrada.");
            }

        } else {

            System.out.println("Ingrese el ID del usuario que desea modificar:");
            int idu = Teclado.nextInt();
            Usuario usuarioEncontrado = ABMUsuario.read(idu);

            if (usuarioEncontrado != null) {

                System.out.println(usuarioEncontrado.toString() + "seleccionado para modificacion.");

                System.out.println("Elija qué dato del usuario desea modificar: 1: email, 2: password");
                int selecus = Teclado.nextInt();

                if (selecus == 1) {
                    System.out.println("Ingrese el nuevo Email de usuario:");
                    Teclado.nextLine();
                    usuarioEncontrado.setUserEmail(Teclado.nextLine());
                } else {
                    System.out.println("Ingrese la nueva password de usuario:");
                    Teclado.nextLine();
                    usuarioEncontrado.setPassword(Teclado.nextLine());
                }

                ABMUsuario.update(usuarioEncontrado);

                System.out.println("El registro de " + usuarioEncontrado.getUserName() + " ha sido modificado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }

        }
    }

    public static void listar() {

        List<Persona> todas = ABMPersona.buscarTodas();
        for (Persona p : todas) {
            System.out.println("Id: " + p.getPesonaId() + " Nombre: " + p.getNombre());

            if (p.getUsuario() != null)
                System.out.println(" Usuario: " + p.getUsuario().getUserName());
            else
                System.out.println("");
        }
    }

    public static void listarPorNombre() {

        System.out.println("Ingrese el nombre:");
        String nombre = Teclado.nextLine();

        List<Persona> personas = ABMPersona.buscarPor(nombre);
        for (Persona p : personas) {
            System.out.println("Id: " + p.getPesonaId() + " Nombre: " + p.getNombre());
        }
    }

    //falta poner límite para no tener saldos negativos
    public static void transferir() {
        System.out.println("Transferir: ingrese ID Billetera de origen.");
        int idO = Teclado.nextInt();
        Billetera bO = ABMBilletera.read(idO);
        System.out.println("Transferir: ingrese ID Billetera de destino.");
        int idD = Teclado.nextInt();
        Billetera bD = ABMBilletera.read(idD);
        System.out.println("Transferir: ingrese el importe.");
        double importe = Teclado.nextDouble();

        bO.transferencia(bD, importe);

        ABMBilletera.update(bO);
        ABMBilletera.update(bD);

        System.out.println(
                "Transferencia exitosa. Su nuevo saldo es " + bO.consultarSaldo(bO, bO.getCuenta(0).getMoneda()) + ".");

    }

    public static void printOpciones() {
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Para agregar una persona presione 1.");
        System.out.println("Para eliminar una persona presione 2.");
        System.out.println("Para modificar una persona presione 3.");
        System.out.println("Para ver el listado presione 4.");
        System.out.println("Buscar una persona por nombre especifico(SQL Injection)) 5.");
        System.out.println("Consultar Saldo presione 6.");
        System.out.println("Hacer una transferencia presione 7.");
        System.out.println("Para terminar presione 0.");
        System.out.println("");
        System.out.println("=======================================");
    }

}