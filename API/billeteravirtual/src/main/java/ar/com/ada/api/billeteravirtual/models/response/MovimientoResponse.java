package ar.com.ada.api.billeteravirtual.models.response;

import java.math.BigDecimal;
import java.util.Date;


/**
 * MovimientoResponse
 */
public class MovimientoResponse {

    public int movimientoId;
    public Date fechaMovimiento;
    public BigDecimal importe;
    public String conceptoOperacion;

}