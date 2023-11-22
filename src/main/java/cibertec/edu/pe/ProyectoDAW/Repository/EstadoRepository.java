package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {
}
