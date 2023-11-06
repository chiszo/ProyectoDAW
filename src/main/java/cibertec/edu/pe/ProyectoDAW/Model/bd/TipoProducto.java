package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tipoproducto")
@Data
public class TipoProducto {
    @Id
    private String idtipopro;
    @Column(name ="descripcion")
    private String descripcion;
}
