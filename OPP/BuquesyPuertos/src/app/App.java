package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando Buques y Puertos");

        Buque barquito = Buque.NuevoBuqueCargado();

        for (Contenedor contenedorcito : barquito.losContenedores) {
            switch (contenedorcito.puertoArribo.nroPuerto) {
            case 1:
                Puerto.buscarPuerto(1).contenedoresARecibir.add(contenedorcito);
                break;
            case 2:
                Puerto.buscarPuerto(2).contenedoresARecibir.add(contenedorcito);
                break;
            case 3:
                Puerto.buscarPuerto(3).contenedoresARecibir.add(contenedorcito);
                break;
            }
        }
        for (Puerto puertito : Puerto.PuertosDelMundo) {
            System.out.println("El puerto " + puertito.nombre + "recibira " + puertito.contenedoresARecibir.size());
        }
        // imprimo el peso del buque
        System.out.println("El peso del barco " + barquito.nombre + "es" + barquito.calcularPeso());

        // ahora saco el contenedor Maximo
        Contenedor elConteMasPesado = barquito.getContenedorMaximo();

        System.out.println("El contenador mas pesado es " + elConteMasPesado.idContenedor + " Cuyo peso es "
                + elConteMasPesado.peso);

    }
}