package cibertec.edu.pe.ProyectoDAW.Controller.Producto;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Lote;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.bd.TipoProducto;
import cibertec.edu.pe.ProyectoDAW.Model.dto.ProductoDto;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Service.LoteService;
import cibertec.edu.pe.ProyectoDAW.Service.ProductoService;
import cibertec.edu.pe.ProyectoDAW.Service.ProveedorService;
import cibertec.edu.pe.ProyectoDAW.Service.TipoProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService productoService;
    private LoteService loteService;
    private ProveedorService proveedorService;
    private TipoProductoService tipoProductoService;

    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("listadoproductos", productoService.listarProductos());
        return "Producto/list_producto";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProducto(
            @RequestBody ProductoDto objProducto) {
        return productoService.registrarProducto(objProducto);
    }

    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarProducto(
            @RequestBody Producto objProducto) {
        return productoService.eliminarProducto(objProducto.getIdproducto());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Producto> listarproductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/list_tipopro")
    @ResponseBody
    public List<TipoProducto> listartipopro(){
        return tipoProductoService.listar();
    }

    @GetMapping("/list_lote")
    @ResponseBody
    public List<Lote> listarlote(){
        return loteService.listar();
    }
}
