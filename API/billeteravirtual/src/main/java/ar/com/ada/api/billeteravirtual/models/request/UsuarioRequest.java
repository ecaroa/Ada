package ar.com.ada.api.billeteravirtual.models.request;

import java.math.BigDecimal;

/**
 * UsuarioRequest
 */
public class UsuarioRequest {

    public String email;
    public String concepto;
    public BigDecimal importe;
    public String moneda;
}