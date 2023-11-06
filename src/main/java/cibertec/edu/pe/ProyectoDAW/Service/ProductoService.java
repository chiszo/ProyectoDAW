package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
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

    public ResultadoResponse registrarProducto(Producto producto){

        String mensaje = "Producto registrado";
        Boolean respuesta = true;

        try {
            productoRepository.save(producto);
        }catch (Exception ex){
            mensaje= "Producto NO registrado";
            respuesta = false;
        }

        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }

    public ResultadoResponse eliminarProducto(String idproducto){
        String mensaje = "Producto eliminado";
        Boolean respuesta = true;
        try {
            productoRepository.deleteById(idproducto);
        }catch (Exception ex){
            mensaje= "Producto NO eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
