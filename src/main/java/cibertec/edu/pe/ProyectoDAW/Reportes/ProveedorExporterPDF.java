package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.*;
import cibertec.edu.pe.ProyectoDAW.Model.dto.ProveedorDTO;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import javax.print.Doc;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ProveedorExporterPDF {
    private List<Proveedor> proveedorList;

    public ProveedorExporterPDF(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable table){
        PdfPCell celda= new PdfPCell();
        celda.setBackgroundColor(Color.gray);
        celda.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        celda.setPhrase(new Phrase("ID Proveedor", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Telefono", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Direccion", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Empresa", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("RUC", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Correo", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Representante", font) );
        table.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        for(Proveedor proveedor : proveedorList){
            tabla.addCell(proveedor.getIdproveedor());
            tabla.addCell(proveedor.getTelefono());
            tabla.addCell(proveedor.getDireccion());
            tabla.addCell(proveedor.getEmpresa());
            tabla.addCell(proveedor.getRuc());
            tabla.addCell(proveedor.getCorreo());
            tabla.addCell(proveedor.getRepresentante());
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font fuente=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLACK);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Proveedores", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {2f,2f,2f,4f,1.5f,2f,1.5f});
        table.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(table);
        escribirDatosDeLaTabla(table);

        document.add(table);

        document.close();
    }
}