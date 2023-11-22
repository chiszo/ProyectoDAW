package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.TipoBaja;
import cibertec.edu.pe.ProyectoDAW.Repository.TipoBajaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoBajaService {
    private TipoBajaRepository tipoBajaRepository;

    public List<TipoBaja> listar(){
        return tipoBajaRepository.findAll();
    }
}
