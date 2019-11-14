package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Locador
 */
@Entity
@Table(name = "locador")

//@NamedQuery(name = "locador.findAllByNombreContiene", query = "FROM locador WHERE nombre like CONCAT('%', ?1,'%')")
//@NamedQuery(name = "Locador.findAllByNombre", query = "SELECT l FROM Locador l WHERE l.nombre = ?1")
//@NamedNativeQuery(name = "locador.findAllByNombre", query = "SELECT * FROM locador WHERE nombre like CONCAT('%', ?,'%')", resultClass = Persona.class)
public class Locador extends Persona {

    @Id
    @Column(name = "locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locadorId;
    @JsonIgnore
    @OneToMany(mappedBy = "locador", cascade = CascadeType.ALL)
    List<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    @Transient
    private String tipoUsuario = "inmobiliaria"; // ver si tiene algo que ver



    public int getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(int locadorId) {
        this.locadorId = locadorId;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public void agregarInmueble(Inmueble inmueble) {
        this.inmuebles.add(inmueble);
        inmueble.setLocador(this);
    }

    public Locador() {
    }
    
}