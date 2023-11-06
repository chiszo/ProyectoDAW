package cibertec.edu.pe.ProyectoDAW.Model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}
