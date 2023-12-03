package cibertec.edu.pe.ProyectoDAW.Controller.Trabajador;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Area;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Cargo;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.dto.TrabajadorDto;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    private TrabajadorService trabajadorService;
    private CargoService cargoService;
    private AreaService areaService;
    @GetMapping("/listado")
    public String listado(Model model,@Param("palabraclave") String palabraclave){
        model.addAttribute("listadotrabajadores", trabajadorService.listarTrabajadorxNombre(palabraclave));
        model.addAttribute("palabraclave",palabraclave);
        return "Trabajador/list_trabajador";
    }
    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarTrabajador(
            @RequestBody TrabajadorDto objTrabajador) {
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

    @GetMapping("/list_area")
    @ResponseBody
    public List<Area> listararea(){
        return areaService.listar();
    }

    @GetMapping("/list_cargo")
    @ResponseBody
    public List<Cargo> listarcargo(){
        return cargoService.listar();
    }
}
