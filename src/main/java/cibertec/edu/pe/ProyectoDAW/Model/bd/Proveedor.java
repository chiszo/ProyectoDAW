package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="proveedor")
@Data
public class Proveedor {
    @Id
    private String idproveedor;

    @Column(name ="telefono")
    private String telefono;

    @Column(name ="direccion")
    private String direccion;

    @Column(name ="empresa")
    private String empresa;

    @Column(name ="ruc")
    private String ruc;

    @Column(name ="correo")
    private String correo;

    @Column(name ="representante")
    private String representante;
}
