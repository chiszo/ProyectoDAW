package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.Producto;
import cibertec.edu.pe.ProyectoDAW.Model.Trabajador;
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

    public boolean registrarTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador) !=null;
    }

    public void eliminarTrabajador(String idtrabajador){
        trabajadorRepository.deleteById(idtrabajador);
    }
}
