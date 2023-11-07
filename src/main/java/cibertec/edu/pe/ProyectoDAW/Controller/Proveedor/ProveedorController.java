package cibertec.edu.pe.ProyectoDAW.Controller.Proveedor;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProveedor(
            @RequestBody Proveedor objProveedor) {
        return proveedorService.registrarProveedor(objProveedor);
    }

    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarProveedor(
            @RequestBody Proveedor objProveedor) {
        return proveedorService.eliminarProveedor(objProveedor.getIdproveedor());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Proveedor> listarproveedor(){
        return proveedorService.listarProveedor();
    }
}
