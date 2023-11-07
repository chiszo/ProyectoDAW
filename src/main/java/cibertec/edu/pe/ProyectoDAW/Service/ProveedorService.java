package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.Proveedor;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
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

    public ResultadoResponse registrarProveedor(Proveedor proveedor){
        String mensaje = "Proveedor registrado";
        Boolean respuesta = true;

        try {
            proveedorRepository.save(proveedor);
        }catch (Exception ex){
            mensaje= "Proveedor NO registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }

    public ResultadoResponse eliminarProveedor(String idproveedor){

        String mensaje = "Proveedor eliminado";
        Boolean respuesta = true;
        try {
            proveedorRepository.deleteById(idproveedor);
        }catch (Exception ex){
            mensaje= "Proveedor NO eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
