package cibertec.edu.pe.ProyectoDAW.Controller.Trabajador;

import cibertec.edu.pe.ProyectoDAW.Service.ProductoService;
import cibertec.edu.pe.ProyectoDAW.Service.TrabajadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    private TrabajadorService trabajadorService;
    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("listadotrabajadores", trabajadorService.listarTrabajador());
        return "Trabajador/list_trabajador";
    }
}
