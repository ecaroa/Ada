package ar.com.ada.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    private String username;

    private String password;

    private String email;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    @Column(name = "estado_usuario")
    private String estadoUsuario;

    @Column(name = "fecha_alta")
    private Date fechaAltaUsuario;

    @Column(name = "fecha_baja")
    private Date fechaBajaUsuario;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Locatario locatario;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Inmobiliaria inmobiliaria;

    @Transient //annotation que sirve para que ignore el atributo en el mapping
    private ITieneUsuario tieneUsuario;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public Usuario(){
    }

    public String getTipoUsuario(ITieneUsuario tieneUsuario) {
        return tieneUsuario.getClass().getName();
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public ITieneUsuario getTieneUsuario() {
        return tieneUsuario;
    }

    public void setTieneUsuario(ITieneUsuario tieneUsuario) {
        this.tieneUsuario = tieneUsuario;
    }

    public void setTipoUsuario(ITieneUsuario tieneUsuario) {
        this.tipoUsuario = tieneUsuario.getClass().getName();
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Date getFechaAltaUsuario() {
        return fechaAltaUsuario;
    }

    public void setFechaAltaUsuario(Date fechaAltaUsuario) {
        this.fechaAltaUsuario = fechaAltaUsuario;
    }

    public Date getFechaBajaUsuario() {
        return fechaBajaUsuario;
    }

    public void setFechaBajaUsuario(Date fechaBajaUsuario) {
        this.fechaBajaUsuario = fechaBajaUsuario;
    }

	public String getUserName() {
		return username;
	}   

}