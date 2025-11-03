package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Producto;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ProductoExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;
    private List<Producto> productoList;

    public ProductoExporterExcel(List<Producto> productos) {
        this.productoList = productos;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Producto");
    }

    private void escribirCabeceraTabla(){
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID Producto");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Tipo producto");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Proveedor");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Nombre");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Cantidad");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Precio");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Stock mín");
        celda.setCellStyle(estilo);

        celda = fila.createCell(7);
        celda.setCellValue("Stock máx.");
        celda.setCellStyle(estilo);

        celda = fila.createCell(8);
        celda.setCellValue("Lote");
        celda.setCellStyle(estilo);

        celda = fila.createCell(9);
        celda.setCellValue("Estado");
        celda.setCellStyle(estilo);
    }
    private void escribirDatosDeLaTabla() {
        int numeroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Producto producto : productoList){
            Row fila = hoja.createRow(numeroFilas ++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(String.valueOf(producto.getIdproducto()));
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(String.valueOf(producto.getTipoproducto().getDescripcion()));
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(String.valueOf(producto.getProveedor().getRepresentante()));
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(String.valueOf(producto.getNombre()));
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(producto.getCantidad());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(producto.getPrecio());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(producto.getCantmax());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);

            celda = fila.createCell(7);
            celda.setCellValue(producto.getCantmin());
            hoja.autoSizeColumn(7);
            celda.setCellStyle(estilo);

            celda = fila.createCell(8);
            celda.setCellValue(String.valueOf(producto.getLote().getDescripcion()));
            hoja.autoSizeColumn(8);
            celda.setCellStyle(estilo);

            celda = fila.createCell(9);
            celda.setCellValue(producto.getEstado().getIdestado());
            hoja.autoSizeColumn(9);
            celda.setCellStyle(estilo);
        }
    }
    @SneakyThrows
    public void exportar(HttpServletResponse response){
        escribirCabeceraTabla();
        escribirDatosDeLaTabla();

        ServletOutputStream outputStream = response.getOutputStream();
        libro.write(outputStream);

        libro.close();
        outputStream.close();
    }
}
