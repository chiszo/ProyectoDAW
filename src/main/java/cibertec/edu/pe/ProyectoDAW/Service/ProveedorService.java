package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Repository.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProveedorService {
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedor(){
        return proveedorRepository.findAll();
    }

    public boolean registrarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor) !=null;
    }

    public void eliminarProveedor(String idproveedor){
        proveedorRepository.deleteById(idproveedor);
    }
}
