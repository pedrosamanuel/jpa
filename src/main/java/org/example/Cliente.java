package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
public class Cliente extends Base<Long>{
    private String apellido;
    private String nombre;
    private int dni;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private List<Factura> facturas = new ArrayList<>();
}
