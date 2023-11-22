package cibertec.edu.pe.ProyectoDAW.Model.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private String idproducto;
    private String idtipopro;
    private String idproveedor;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private Integer cantmin;
    private Integer cantmax;
    private String idlote;
    private Integer estado;
}
