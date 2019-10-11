package ar.com.ada.api.billeteravirtual.models.request;

import java.math.BigDecimal;

/**
 * TransferRequest
 */
public class TransferRequest {

    public BigDecimal importeATransferir;
    public String tipoOperacion;
    public String conceptoOperacion;
    public String detalle;

}