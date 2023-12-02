package cibertec.edu.pe.ProyectoDAW.Service;

import cibertec.edu.pe.ProyectoDAW.Model.bd.CompraProducto;
import cibertec.edu.pe.ProyectoDAW.Model.bd.DetalleCompra;
import cibertec.edu.pe.ProyectoDAW.Model.response.ResultadoResponse;
import cibertec.edu.pe.ProyectoDAW.Repository.CompraProductoRepository;
import cibertec.edu.pe.ProyectoDAW.Repository.DetalleCompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CompraProductoService {
    private DetalleCompraRepository detalleCompraRepository;
    private CompraProductoRepository compraProductoRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public ResultadoResponse guardarcompra(CompraProducto compraProducto,
                                           List<DetalleCompra> detalleCompraList){

        CompraProducto nuevoCompraProducto = compraProductoRepository.save(compraProducto);
        for (DetalleCompra detalleCompra: detalleCompraList){
            detalleCompra.setCodcomprapro(nuevoCompraProducto.getCodcomprapro());
            detalleCompraRepository.save(detalleCompra);
        }

        return null;
    }
}
