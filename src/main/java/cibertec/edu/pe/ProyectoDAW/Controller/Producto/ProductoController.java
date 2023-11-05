package cibertec.edu.pe.ProyectoDAW.Controller.Producto;

import cibertec.edu.pe.ProyectoDAW.Service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("listadoproductos", productoService.listarProductos());
        return "Producto/list_producto";
    }
}
