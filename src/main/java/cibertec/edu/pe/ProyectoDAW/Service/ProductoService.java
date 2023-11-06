package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {
    private ProductoRepository productoRepository;
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public boolean registrarProducto(Producto producto){
        return productoRepository.save(producto) !=null;
    }

    public void eliminarProducto(String idproducto){
        productoRepository.deleteById(idproducto);
    }
}
