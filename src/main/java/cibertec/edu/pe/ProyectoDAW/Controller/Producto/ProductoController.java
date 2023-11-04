package cibertec.edu.pe.ProyectoDAW.Controller.Producto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {

    @GetMapping("/listado")
    public String listado(Model model){
        return "Producto/list_producto";
    }
}
