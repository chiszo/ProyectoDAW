package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
}
