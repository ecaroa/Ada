package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*; 

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Inmueble
 */
@Entity
@Table(name = "inmueble")
public class Inmueble {

    @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inmuebleId;

    @ManyToOne
    @JoinColumn(name = "locador_id", referencedColumnName = "locador_id")
    @JsonIgnore
    Locador locador;

    
    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Aviso> avisos = new ArrayList<Aviso>();

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    @JsonIgnore
    private Reserva reserva;

    @Column(name = "tipo_inmueble")
    String tipoInmueble;
    @Column(name = "cant_amb")
    int cantAmb;
    String direccion;
    char reservado = 'n'; //'s' ó 'n'
    //boolean reservado = false; // cómo convertir de boolean a char?
    // Coordenada ubicacion; (para usar API Maps a futuro)
    int superficie; // en m2
    @Column(name = "cant_dormitorio")
    int cantDormitorio;
    @Column(name = "apto_prof") // cómo convertir de boolean a char?
    char aptoProf; //'s' ó 'n'
    //boolean aptoProf;
    String disposicion;
    @Column(name = "cant_banios")
    int cantBanios;
    @Column(name = "antiguedad_anios")
    int antiguedadAnios;
    // (etc)

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getCantDormitorio() {
        return cantDormitorio;
    }

    public void setCantDormitorio(int cantDormitorio) {
        this.cantDormitorio = cantDormitorio;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public int getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(int cantBanios) {
        this.cantBanios = cantBanios;
    }

    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }

    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public int getCantAmb() {
        return cantAmb;
    }

    public void setCantAmb(int cantAmb) {
        this.cantAmb = cantAmb;
    }

    public char getReservado() {
        return reservado;
    }

    public void setReservado(char reservado) {
        this.reservado = reservado;
    }

    public char getAptoProf() {
        return aptoProf;
    }

    public void setAptoProf(char aptoProf) {
        this.aptoProf = aptoProf;
    }
}