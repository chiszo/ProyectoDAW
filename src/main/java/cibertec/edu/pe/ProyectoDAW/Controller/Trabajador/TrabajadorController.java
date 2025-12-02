package cibertec.edu.pe.ProyectoDAW.Controller.Trabajador;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Area;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Cargo;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.dto.TrabajadorDto;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProveedorExporterPDF;
import cibertec.edu.pe.ProyectoDAW.Reportes.TrabajadorExporterExcel;
import cibertec.edu.pe.ProyectoDAW.Reportes.TrabajadorExporterPDF;
import cibertec.edu.pe.ProyectoDAW.Service.*;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/reporte")
    public String reporte(Model model, @Param("palabraclave") String palabraclave){
        List<Trabajador> trabajadorList =  trabajadorService.listarTrabajadorxNombre(palabraclave);
        model.addAttribute("palabraclave",palabraclave);
        model.addAttribute("listadotrabajadores", trabajadorList);
        return "Trabajador/report_trabajador";
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

    @GetMapping("/exportarPDF")
    public void exportarListadoDeTrabajadorEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Trabajador.pdf";
        response.setHeader(cabecera, valor);
        List<Trabajador> trabajador = trabajadorService.listarTrabajador();
        TrabajadorExporterPDF exporterPDF = new TrabajadorExporterPDF(trabajador);
        exporterPDF.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoDeTrabajadoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");
        String cabecera  ="Content-Disposition";
        String valor ="attachment; filename=Trabajador.xlsx";
        response.setHeader(cabecera,valor);
        List<Trabajador> trabajador = trabajadorService.listarTrabajador();
        TrabajadorExporterExcel exporter = new TrabajadorExporterExcel(trabajador);
        exporter.exportar(response);
    }

    @GetMapping("/listado-backtracking")
    public String listadoBacktracking(Model model, @Param("palabraclave") String palabraclave){
        List<Trabajador> lista = trabajadorService.listarTrabajador();
        long inicio = System.currentTimeMillis();
        List<Trabajador> resultado = new java.util.ArrayList<>();
        for (Trabajador t : lista) {
            if (palabraclave == null || palabraclave.isEmpty()) {
                resultado.add(t);
                continue;
            }
            if (coincideBacktracking(t.getNombres().toLowerCase(), palabraclave.toLowerCase())) {
                resultado.add(t);
            }
        }
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        model.addAttribute("palabraclave", palabraclave);
        model.addAttribute("listadotrabajadores", resultado);
        model.addAttribute("tiempo", tiempo);
        return "Trabajador/list_trabajador";
    }
    private boolean coincideBacktracking(String texto, String clave) {
        return backtrack(texto, clave, 0, 0);
    }
    private boolean backtrack(String texto, String clave, int i, int j) {
        if (j == clave.length()) return true;
        if (i == texto.length()) return false;
        boolean coincide = false;
        if (texto.charAt(i) == clave.charAt(j)) {
            coincide = backtrack(texto, clave, i + 1, j + 1);
        }
        if (!coincide) {
            coincide = backtrack(texto, clave, i + 1, j);
        }
        return coincide;
    }
}
