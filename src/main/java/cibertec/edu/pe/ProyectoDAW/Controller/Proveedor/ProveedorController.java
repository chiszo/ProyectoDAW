package cibertec.edu.pe.ProyectoDAW.Controller.Proveedor;

import cibertec.edu.pe.ProyectoDAW.Service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    private ProveedorService proveedorService;
    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("listadoproveedores", proveedorService.listarProveedor());
        return "Proveedor/list_proveedor";
    }
}
