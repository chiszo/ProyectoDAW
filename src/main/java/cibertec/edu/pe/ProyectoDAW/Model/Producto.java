package cibertec.edu.pe.ProyectoDAW.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="producto")
@Data
public class Producto {
    @Id
    private String idproducto;

    @Column(name ="idtipopro")
    private String idtipopro;

    @Column(name ="idproveedor")
    private String idproveedor;

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

    @Column(name ="idlote")
    private String idlote;

    @Column(name ="estado")
    private Byte estado;
}
