package ar.com.ada.api.billeteravirtual.models.request;

import java.math.BigDecimal;

/**
 * TransferRequest
 */
public class TransferRequest {

    public String email;
    public BigDecimal importeATransferir;
    public String moneda;
    public String concepto;
    public String detalle;

}