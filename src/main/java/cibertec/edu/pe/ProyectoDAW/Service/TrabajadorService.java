package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Area;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Cargo;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Trabajador;
import cibertec.edu.pe.ProyectoDAW.Model.dto.TrabajadorDto;
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

    public List<Trabajador> listarTrabajadorxNombre(String palabraclave){
        if (palabraclave != null){
            return trabajadorRepository.findAll(palabraclave);
        }
        return trabajadorRepository.findAll();
    }

    public ResultadoResponse registrarTrabajador(TrabajadorDto trabajadorDto){
        String mensaje = "Trabajador registrado";
        Boolean respuesta = true;

        try {
            //llamar al trabajador
            Trabajador trabajadornuevo=new Trabajador();

            //recibir los datos
            //ID
            trabajadornuevo.setIdtrabajador(trabajadorDto.getIdtrabajador());
            //nombres
            trabajadornuevo.setNombres(trabajadorDto.getNombres());
            //apellidos
            trabajadornuevo.setApellidos(trabajadorDto.getApellidos());
            //dni
            trabajadornuevo.setDni(trabajadorDto.getDni());
            //telefono
            trabajadornuevo.setTelefono(trabajadorDto.getTelefono());
            //correo
            trabajadornuevo.setCorreo(trabajadorDto.getCorreo());
            //direccion
            trabajadornuevo.setDireccion(trabajadorDto.getDireccion());
            //cargo
            Cargo cargo = new Cargo();
            cargo.setIdcargo(trabajadorDto.getIdcargo());
            trabajadornuevo.setCargo(cargo);
            //area
            Area area = new Area();
            area.setIdtipoarea(trabajadorDto.getIdarea());
            trabajadornuevo.setArea(area);
            //clave
            trabajadornuevo.setClave(trabajadorDto.getClave());

            trabajadorRepository.save(trabajadornuevo);
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
