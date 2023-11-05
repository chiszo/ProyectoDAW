package cibertec.edu.pe.ProyectoDAW.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cargo")
@Data
public class Cargo {
    @Id
    private String idcargo;
    @Column(name ="descripcion")
    private String descripcion;
}
