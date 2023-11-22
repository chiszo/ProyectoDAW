package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Area;
import cibertec.edu.pe.ProyectoDAW.Model.bd.Estado;
import cibertec.edu.pe.ProyectoDAW.Repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoService {
    private EstadoRepository estadoRepository;
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }
}
