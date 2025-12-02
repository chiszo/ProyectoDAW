package cibertec.edu.pe.ProyectoDAW.Controller.Producto;

import cibertec.edu.pe.ProyectoDAW.Model.bd.*;
import cibertec.edu.pe.ProyectoDAW.Model.dto.ProductoDto;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProductoExporterExcel;
import cibertec.edu.pe.ProyectoDAW.Reportes.ProductoExporterPDF;
import cibertec.edu.pe.ProyectoDAW.Service.*;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService productoService;
    private LoteService loteService;
    private TipoProductoService tipoProductoService;
    private EstadoService estadoService;

    @GetMapping("/listado")
    public String listado(Model model, @Param("palabraclave") String palabraclave){
        long inicio = System.currentTimeMillis();
        List<Producto> productoList = productoService.listarProductosxNombre(palabraclave);
        long fin = System.currentTimeMillis();
        long tiempoBusqueda = fin - inicio;
        model.addAttribute("palabraclave", palabraclave);
        model.addAttribute("listadoproductos", productoList);
        model.addAttribute("tiempoBusqueda", tiempoBusqueda);
        return "Producto/list_producto";
    }

    @GetMapping("/reporte")
    public String reporte(Model model, @Param("palabraclave") String palabraclave){
        List<Producto> productoList =  productoService.listarProductosxNombre(palabraclave);
        model.addAttribute("palabraclave",palabraclave);
        model.addAttribute("listadoproductos", productoList);
        return "Producto/report_producto";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProducto(
            @RequestBody ProductoDto objProducto) {
        return productoService.registrarProducto(objProducto);
    }

    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarProducto(
            @RequestBody Producto objProducto) {
        return productoService.eliminarProducto(objProducto.getIdproducto());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Producto> listarproductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/list_tipopro")
    @ResponseBody
    public List<TipoProducto> listartipopro(){
        return tipoProductoService.listar();
    }

    @GetMapping("/list_lote")
    @ResponseBody
    public List<Lote> listarlote(){
        return loteService.listar();
    }

    @GetMapping("/list_estado")
    @ResponseBody
    public List<Estado> listarestado(){
        return estadoService.listar();
    }


    @GetMapping("/exportarPDF")
    public void exportarListadoDeProductosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String cabecera  ="Content-Disposition";
        String valor ="attachment; filename=Productos.pdf";

        response.setHeader(cabecera,valor);

        List<Producto> productos = productoService.listarProductos();

        ProductoExporterPDF exporterPDF = new ProductoExporterPDF(productos);
        exporterPDF.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoDeProductosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        String cabecera  ="Content-Disposition";
        String valor ="attachment; filename=Productos.xlsx";

        response.setHeader(cabecera,valor);

        List<Producto> productos = productoService.listarProductos();

        ProductoExporterExcel exporter = new ProductoExporterExcel(productos);
        exporter.exportar(response);
    }
}
