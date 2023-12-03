package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

    @Query("select p from Proveedor p where concat(p.idproveedor,p.empresa,p.representante,p.telefono,p.direccion,p.ruc,p.correo) like %?1%")
    public List<Proveedor> findAll(String empresa);
}
