package cibertec.edu.pe.ProyectoDAW.Repository;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

    @Query("select p from Producto p"+
            " where" +
            " concat(p.idproducto,p.nombre)" +
            " like %?1%")
    public List<Producto> findAll(String nombre);
}
