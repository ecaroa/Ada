package app.personajes;

/**
 * Muggle
 */
public class Muggle extends Persona {

    public void atacar(Muggle muggle) {
        System.out.println(this.nombre + " no puede realizar magia porque es muggle.");

    }
}