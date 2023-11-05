package cibertec.edu.pe.ProyectoDAW.Model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="lote")
@Data
public class Lote {
    @Id
    private String idlote;
    @Column(name ="descripcion")
    private String descripcion;
}
