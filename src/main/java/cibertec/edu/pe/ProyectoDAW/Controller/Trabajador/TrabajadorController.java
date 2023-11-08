package cibertec.edu.pe.ProyectoDAW.Controller.Trabajador;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Service.ProductoService;
import cibertec.edu.pe.ProyectoDAW.Service.TrabajadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarTrabajador(
            @RequestBody Trabajador objTrabajador) {
        return trabajadorService.registrarTrabajador(objTrabajador);
    }

    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarTrabajador(
            @RequestBody Trabajador objTrabajador) {
        return trabajadorService.eliminarTrabajador(objTrabajador.getIdtrabajador());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Trabajador> listartrabajador(){
        return trabajadorService.listarTrabajador();
    }
}
