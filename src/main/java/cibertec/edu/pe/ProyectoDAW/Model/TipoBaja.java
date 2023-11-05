package cibertec.edu.pe.ProyectoDAW.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tipobaja")
@Data
public class TipoBaja {
    @Id
    private String idtipobaja;
    @Column(name ="descripcion")
    private String descripcion;
}
