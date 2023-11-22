package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Cargo;
import cibertec.edu.pe.ProyectoDAW.Repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CargoService {
    private CargoRepository cargoRepository;

    public List<Cargo> listar(){
        return cargoRepository.findAll();
    }
}
