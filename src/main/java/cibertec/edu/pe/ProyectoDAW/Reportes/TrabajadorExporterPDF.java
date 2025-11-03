package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.dto.TrabajadorDto;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TrabajadorExporterPDF {
    private List<Trabajador> trabajadorList;

    public TrabajadorExporterPDF(List<Trabajador> productoList) {
        this.trabajadorList = trabajadorList;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable table){
        PdfPCell celda= new PdfPCell();
        celda.setBackgroundColor(Color.gray);
        celda.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        celda.setPhrase(new Phrase("ID Trabajador", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Nombres", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Apellidos", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("DNI", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Telefono", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Correo", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Dirección", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Cargo", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Area", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Contraseña", font) );
        table.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla){
        TrabajadorDto trabajadorDto = new TrabajadorDto();
        for(Trabajador trabajador : trabajadorList){
            tabla.addCell(trabajador.getIdtrabajador());
            tabla.addCell(trabajador.getNombres());
            tabla.addCell(trabajador.getApellidos());
            tabla.addCell(trabajador.getDni());
            tabla.addCell(trabajador.getTelefono());
            tabla.addCell(trabajador.getCorreo());
            tabla.addCell(trabajador.getDireccion());
            tabla.addCell(trabajador.getCargo().getDescripcion());
            tabla.addCell(trabajador.getArea().getDescripcion());
            tabla.addCell(trabajador.getClave());
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font fuente=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLACK);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Trabajadores", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);

        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {2f,2f,2f,4f,1.5f,2f,1.5f,1.5f,3f,3f});
        table.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(table);
        escribirDatosDeLaTabla(table);

        document.add(table);

        document.close();
    }
}
