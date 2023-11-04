package cibertec.edu.pe.ProyectoDAW.Controller.Trabajador;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @GetMapping("/listado")
    public String listado(Model model){
        return "Trabajador/list_trabajador";
    }
}
