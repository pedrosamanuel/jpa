package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
public class DetalleFactura extends Base<Long>{
    private int cantidad;
    private int subtotal;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

}
