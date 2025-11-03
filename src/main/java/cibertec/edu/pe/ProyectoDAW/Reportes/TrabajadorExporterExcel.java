package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
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

public class TrabajadorExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;
    private List<Trabajador> trabajadorList;

    public TrabajadorExporterExcel(List<Trabajador> trabajador) {
        this.trabajadorList = trabajador;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Trabajador");
    }

    private void escribirCabeceraTabla(){
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID Trabajador");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Nombres");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Apellidos");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("DNI");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Telefono");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Correo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Direccion");
        celda.setCellStyle(estilo);

        celda = fila.createCell(7);
        celda.setCellValue("Cargo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(8);
        celda.setCellValue("Area");
        celda.setCellStyle(estilo);

        celda = fila.createCell(9);
        celda.setCellValue("Clave");
        celda.setCellStyle(estilo);
    }
    private void escribirDatosDeLaTabla() {
        int numeroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Trabajador trabajador : trabajadorList){
            Row fila = hoja.createRow(numeroFilas ++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(String.valueOf(trabajador.getIdtrabajador()));
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(String.valueOf(trabajador.getNombres()));
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(String.valueOf(trabajador.getApellidos()));
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(String.valueOf(trabajador.getDni()));
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(String.valueOf(trabajador.getTelefono()));
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(String.valueOf(trabajador.getCorreo()));
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(String.valueOf(trabajador.getDireccion()));
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);

            celda = fila.createCell(7);
            celda.setCellValue(String.valueOf(trabajador.getCargo().getDescripcion()));
            hoja.autoSizeColumn(7);
            celda.setCellStyle(estilo);

            celda = fila.createCell(8);
            celda.setCellValue(String.valueOf(trabajador.getArea().getDescripcion()));
            hoja.autoSizeColumn(8);
            celda.setCellStyle(estilo);

            celda = fila.createCell(9);
            celda.setCellValue(String.valueOf(trabajador.getClave()));
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
