package cibertec.edu.pe.ProyectoDAW.Reportes;

import cibertec.edu.pe.ProyectoDAW.Model.bd.*;
import cibertec.edu.pe.ProyectoDAW.Model.dto.ProductoDto;
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

public class ProductoExporterPDF {
    private List<Producto> productoList;

    public ProductoExporterPDF(List<Producto> productoList) {
        this.productoList = productoList;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable table){
        PdfPCell celda= new PdfPCell();
        celda.setBackgroundColor(Color.gray);
        celda.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        celda.setPhrase(new Phrase("ID Producto", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Tipo producto", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Proveedor", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Nombre", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Cantidad", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Precio", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Stock mín", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Stock máx.", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Lote", font) );
        table.addCell(celda);

        celda.setPhrase(new Phrase("Estado", font) );
        table.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla){
        ProductoDto productoDto = new ProductoDto();
        for(Producto producto : productoList){
            tabla.addCell(producto.getIdproducto());
            tabla.addCell(producto.getTipoproducto().getDescripcion());
            tabla.addCell(producto.getProveedor().getEmpresa());

            tabla.addCell(producto.getNombre());
            tabla.addCell(producto.getCantidad().toString());

            tabla.addCell(producto.getPrecio().toString());

            tabla.addCell(producto.getCantmin().toString());

            tabla.addCell(producto.getCantmax().toString());

            tabla.addCell(producto.getLote().getDescripcion());

            tabla.addCell(producto.getEstado().getDescripcion());
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font fuente=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLACK);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Productos", fuente);
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
