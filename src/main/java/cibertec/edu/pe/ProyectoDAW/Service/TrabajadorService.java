package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Repository.TrabajadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrabajadorService {
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarTrabajador(){
        return trabajadorRepository.findAll();
    }

    public ResultadoResponse registrarTrabajador(Trabajador trabajador){
        String mensaje = "Trabajador registrado";
        Boolean respuesta = true;

        try {
            trabajadorRepository.save(trabajador);
        }catch (Exception ex){
            mensaje= "Trabajador NO registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }

    public ResultadoResponse eliminarTrabajador(String idtrabajador){
        String mensaje = "Trabajador eliminado";
        Boolean respuesta = true;
        try {
            trabajadorRepository.deleteById(idtrabajador);
        }catch (Exception ex){
            mensaje= "Trabajador NO eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
