package ar.com.ada.mongo.netfli.models.response;

import org.bson.types.ObjectId;

/**
 * RegistrationResponse
 */
public class RegistrationResponse {
    
    public boolean isOk = false;
    public String message = "";
    public ObjectId userId ;
}