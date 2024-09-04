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
public class Articulo extends Base<Long>{
    private int cantidad;
    private String denominacion;
    private int precio;
    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "articulo_categoria",
    joinColumns = @JoinColumn(name = "articulo_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();

}
