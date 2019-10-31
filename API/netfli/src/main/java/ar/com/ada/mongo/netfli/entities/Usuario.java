package ar.com.ada.mongo.netfli.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Usuario
 */
@Document(collection = "Usuarios")
public class Usuario {

    @Id
    private ObjectId _id;

    private String fullName;

    private String userName;
    private String password;
    private String userEmail;
    


    public Usuario (String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.userEmail = email;
    }

    public Usuario(){

    }


    public Usuario (String password){
        this.password = password;
    }

    
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    @Override
    public String toString() {
        return "Usuario [User Name=" + userName + ", Password=" + password + ", User Email=" + userEmail + "]";
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }




}