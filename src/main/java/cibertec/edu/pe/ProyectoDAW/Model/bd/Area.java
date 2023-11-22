package cibertec.edu.pe.ProyectoDAW.Model.bd;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="area")
@Data
public class Area {
    @Id
    private String idtipoarea;
    @Column(name ="descripcion")
    private String descripcion;
}
