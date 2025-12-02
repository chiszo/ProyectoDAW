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

    @GetMapping("/listado-binario")
    public String listadoBinario(
            Model model,
            @RequestParam(required = false) String id,
            @RequestParam(defaultValue = "todos") String filtro
    ) {
        long inicio = System.currentTimeMillis();
        List<Proveedor> proveedores = proveedorService.listarProveedor();
        List<Proveedor> filtrados = proveedores.stream().filter(p -> {
            int numero = Integer.parseInt(p.getIdproveedor().substring(1)); // A001 → 001 → 1
            if (filtro.equals("pares")) return numero % 2 == 0;
            if (filtro.equals("impares")) return numero % 2 != 0;
            return true; // todos
        }).toList();
        List<Proveedor> ordenados = filtrados.stream()
                .sorted((a, b) -> a.getIdproveedor().compareTo(b.getIdproveedor()))
                .toList();
        List<Proveedor> resultadoBusqueda = ordenados;
        if (id != null && !id.isEmpty()) {
            int left = 0, right = ordenados.size() - 1;
            Proveedor encontrado = null;
            while (left <= right) {
                int mid = (left + right) / 2;
                Proveedor actual = ordenados.get(mid);
                int comparacion = actual.getIdproveedor().compareTo(id);
                if (comparacion == 0) {
                    encontrado = actual;
                    break;
                } else if (comparacion < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (encontrado != null) {
                resultadoBusqueda = List.of(encontrado);
            } else {
                resultadoBusqueda = List.of(); // vacío
            }
        }
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        model.addAttribute("listadoproveedores", resultadoBusqueda);
        model.addAttribute("id", id);
        model.addAttribute("filtro", filtro);
        model.addAttribute("tiempo", tiempo);
        return "Proveedor/list_proveedor";
    }
}