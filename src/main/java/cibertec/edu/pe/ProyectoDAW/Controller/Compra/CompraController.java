package cibertec.edu.pe.ProyectoDAW.Controller.Compra;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/compra")
public class CompraController {

    @GetMapping("/registrar")
    public String registro(){
        return "Compra/RegistrarCompra";
    }

    @PostMapping("/guardarcompra")
    public String guardarcompra(){
        return "Compra/RegistrarCompra";
    }
}
