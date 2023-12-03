package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
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

public class ProveedorExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;
    private List<Proveedor> productoList;

    public ProveedorExporterExcel(List<Proveedor> proveedor) {
        this.productoList = proveedor;
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
        celda.setCellValue("ID Proveedor");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Telefono");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Direccion");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Empresa");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("RUC");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Correo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Representante");
        celda.setCellStyle(estilo);
    }
    private void escribirDatosDeLaTabla() {
        int numeroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Proveedor proveedor : productoList){
            Row fila = hoja.createRow(numeroFilas ++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(String.valueOf(proveedor.getIdproveedor()));
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(String.valueOf(proveedor.getTelefono()));
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(String.valueOf(proveedor.getDireccion()));
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(String.valueOf(proveedor.getEmpresa()));
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(String.valueOf(proveedor.getRuc()));
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(String.valueOf(proveedor.getCorreo()));
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(String.valueOf(proveedor.getRepresentante()));
            hoja.autoSizeColumn(6);
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
