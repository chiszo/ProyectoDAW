package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, String> {
    @Query("select p from Trabajador p where" +
            " concat(p.nombres,p.apellidos,p.idtrabajador) " +
            " like %?1%")
    public List<Trabajador> findAll(String Nombres);
}
