package ar.com.ada.billeteravirtual;

import javax.persistence.*;

/**
 * Usuario
 */

@Entity
@Table (name = "usuario")
public class Usuario {
    @Id
    @Column (name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String username;
    private String password;
    private String email;
    @Column(name = "persona_id")
    private int pesonaId;

    public Usuario(String username, String password, String email, int pesonaId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.pesonaId = pesonaId;
    }

    public Usuario () {   
    }

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

    public int getPesonaId() {
        return pesonaId;
    }

    public void setPesonaId(int pesonaId) {
        this.pesonaId = pesonaId;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Usuario [Username=" + username + "]";
    }

    
}