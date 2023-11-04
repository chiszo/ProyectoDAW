package cibertec.edu.pe.ProyectoDAW.Controller.Proveedor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @GetMapping("/listado")
    public String listado(Model model){
        return "Proveedor/list_proveedor";
    }
}
