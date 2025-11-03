package cibertec.edu.pe.ProyectoDAW.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping(value = "")
    public String Principal() {
        return "redirect:/home";
    }
}
