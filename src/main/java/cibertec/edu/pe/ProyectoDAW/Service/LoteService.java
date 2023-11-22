package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Lote;
import cibertec.edu.pe.ProyectoDAW.Repository.LoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoteService {
    private LoteRepository loteRepository;

    public List<Lote> listar(){
        return loteRepository.findAll();
    }
}
