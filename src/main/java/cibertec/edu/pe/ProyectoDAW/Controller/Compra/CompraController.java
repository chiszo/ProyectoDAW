package cibertec.edu.pe.ProyectoDAW.Controller.Compra;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/compra")
public class CompraController {

    private ProductoService productoService;

    @GetMapping("/registrar")
    public String registro(){
        return "Compra/RegistrarCompra";
    }

    @PostMapping("/guardarcompra")
    public String guardarcompra(){
        return "Compra/RegistrarCompra";
    }

    public Producto obtenerproducto(Model model, @Param("idproducto") String idproducto){
        model.addAttribute("idproducto",idproducto);
        return productoService.obtener(idproducto);
    }
}
