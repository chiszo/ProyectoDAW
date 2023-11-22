package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.TipoProducto;
import cibertec.edu.pe.ProyectoDAW.Repository.TipoProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoProductoService {
    private TipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> listar(){
        return tipoProductoRepository.findAll();
    }
}
