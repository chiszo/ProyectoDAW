package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "compra_producto")
public class CompraProducto {
    @Id
    private String codcomprapro;

    @Column(name ="fechapedido")
    private Date fechapedido;

    @Column(name ="idproveedor")
    private String idproveedor;

    @Column(name ="montototal")
    private Double montototal;
}
