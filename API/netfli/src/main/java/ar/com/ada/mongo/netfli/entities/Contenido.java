package ar.com.ada.mongo.netfli.entities;

import org.bson.types.ObjectId;

/**
 * Contenido
 */
public class Contenido {

    // Declarar variables de instancia: accesor tipo NombreVariable:

    private ObjectId _id;

    private String nombre;
    private String genero;
    private int año;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}