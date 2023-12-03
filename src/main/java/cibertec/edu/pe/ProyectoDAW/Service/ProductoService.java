package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.*;
import cibertec.edu.pe.ProyectoDAW.Model.dto.ProductoDto;
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
    public List<Producto> listarProductosxNombre(String palabraclave){
        if (palabraclave!=null){
           return productoRepository.findAll(palabraclave);
        }
        return productoRepository.findAll();
    }

    public ResultadoResponse registrarProducto(ProductoDto productoDto){

        String mensaje = "Producto registrado";
        Boolean respuesta = true;

        try {
            //llamar al producto
            Producto productonuevo = new Producto();

            //recibir los datos de productoDto
            //ID
            productonuevo.setIdproducto(productoDto.getIdproducto());
            //tipo producto
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto.setIdtipopro(productoDto.getIdtipopro());
            productonuevo.setTipoproducto(tipoProducto);
            //proveedor
            Proveedor proveedor = new Proveedor();
            proveedor.setIdproveedor(productoDto.getIdproveedor());
            productonuevo.setProveedor(proveedor);
            //nombre
            productonuevo.setNombre(productoDto.getNombre());
            //cantidad
            productonuevo.setCantidad(productoDto.getCantidad());
            //precio
            productonuevo.setPrecio(productoDto.getPrecio());
            //stock mínimo
            productonuevo.setCantmin(productoDto.getCantmin());
            //stock máximo
            productonuevo.setCantmax(productoDto.getCantmax());
            //lote
            Lote lote = new Lote();
            lote.setIdlote(productoDto.getIdlote());
            productonuevo.setLote(lote);
            //estado
            Estado estado = new Estado();
            estado.setIdestado(productoDto.getIdestado());
            productonuevo.setEstado(estado);
            //guardar producto
            productoRepository.save(productonuevo);
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

    public Producto obtener(String idproducto){
        if(idproducto!=null){
            return productoRepository.findByIdproducto(idproducto);
        }
        return null;
    }
}
