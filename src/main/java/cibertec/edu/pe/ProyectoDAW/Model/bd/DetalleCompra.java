package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetallecompra;

    @Column(name ="codcomprapro")
    private String codcomprapro;

    @Column(name ="idproducto")
    private String idproducto;

    @Column(name ="preciocompra")
    private Double preciocompra;

    @Column(name ="cantidad")
    private Integer cantidad;

    @Column(name ="monto")
    private Double monto;
}
