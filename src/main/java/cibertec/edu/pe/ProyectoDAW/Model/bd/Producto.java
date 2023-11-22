package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="producto")
@Data
public class Producto {
    @Id
    private String idproducto;

    @ManyToOne
    @JoinColumn(name ="idtipopro")
    private TipoProducto tipoproducto;

    @ManyToOne
    @JoinColumn(name ="idproveedor")
    private Proveedor proveedor;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="cantidad")
    private Integer cantidad;

    @Column(name ="precio")
    private Double precio;

    @Column(name ="stockminimo")
    private Integer cantmin;

    @Column(name ="stockmaximo")
    private Integer cantmax;

    @ManyToOne
    @JoinColumn(name ="idlote")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name ="idestado")
    private Estado estado;
}
