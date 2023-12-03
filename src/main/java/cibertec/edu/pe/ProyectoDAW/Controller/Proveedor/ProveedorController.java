package cibertec.edu.pe.ProyectoDAW.Controller.Proveedor;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProductoExporterExcel;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProductoExporterPDF;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProveedorExporterExcel;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProveedorExporterPDF;
import cibertec.edu.pe.ProyectoDAW.Service.ProveedorService;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    private ProveedorService proveedorService;
    @GetMapping("/listado")
    public String listado(Model model,@Param("palabraclave") String palabraclave){
        model.addAttribute("listadoproveedores", proveedorService.listarProveedorxNombre(palabraclave));
        model.addAttribute("palabraclave",palabraclave);
        return "Proveedor/list_proveedor";
    }

    @GetMapping("/reporte")
    public String reporte(Model model, @Param("palabraclave") String palabraclave){
        List<Proveedor> proveedorList =  proveedorService.listarProveedorxNombre(palabraclave);
        model.addAttribute("palabraclave",palabraclave);
        model.addAttribute("listadoproveedores", proveedorList);
        return "Proveedor/report_proveedor";
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

    @GetMapping("/exportarPDF")
    public void exportarListadoDeProveedorEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Proveedor.pdf";

        response.setHeader(cabecera, valor);

        List<Proveedor> proveedor = proveedorService.listarProveedor();

        ProveedorExporterPDF exporter = new ProveedorExporterPDF(proveedor);
        exporter.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoDeProveedorEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        String cabecera  ="Content-Disposition";
        String valor ="attachment; filename=Proveedor.xlsx";

        response.setHeader(cabecera,valor);

        List<Proveedor> proveedor = proveedorService.listarProveedor();

        ProveedorExporterExcel exporter = new ProveedorExporterExcel(proveedor);
        exporter.exportar(response);
    }
}