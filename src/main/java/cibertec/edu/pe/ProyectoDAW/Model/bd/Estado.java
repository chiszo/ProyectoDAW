package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="estado")
@Data
public class Estado {
    @Id
    private Integer idestado;
    @Column(name ="descripcion")
    private String descripcion;
}
