package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Area;
import cibertec.edu.pe.ProyectoDAW.Model.bd.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProductoRepository extends JpaRepository<CompraProducto, String> {
}
