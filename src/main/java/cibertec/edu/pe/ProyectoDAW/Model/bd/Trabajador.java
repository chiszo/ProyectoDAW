package cibertec.edu.pe.ProyectoDAW.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="trabajador")
@Data
public class Trabajador {
    @Id
    private String idtrabajador;

    @Column(name ="nombres")
    private String nombres;

    @Column(name ="apellidos")
    private String apellidos;

    @Column(name ="dni")
    private String dni;

    @Column(name ="telefono")
    private String telefono;

    @Column(name ="correo")
    private String correo;

    @Column(name ="direccion")
    private String direccion;

    @Column(name ="idcargo")
    private String idcargo;

    @Column(name ="idtipoarea")
    private String idarea;

    @Column(name ="contraseña")
    private String clave;
}
