package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Clase;
import mx.com.gm.servicio.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorClase {

    @Autowired
    private ClaseService claseService;

     @GetMapping("/lisClases")
    public String lisClases(Model model) {
        var clases = claseService.listarClases();
        log.info("ejecutar el controlador Spring mvc");
        model.addAttribute("clases", clases);
        return "lisClases";
    }

    @GetMapping("/agregarClase")
    public String agregar(Clase clase) {
        return "modificarClase";
    }

    @PostMapping("/guardarClase")
    public String guardar(@Valid Clase clase, Errors errores) {
        if (errores.hasErrors()) {
            return "modificarClase";
        }
        claseService.guardar(clase);
        return "redirect:/lisClases";
    }

    @GetMapping("/editarClase/{idclase}")
    public String editar(Clase clase, Model model) {
        clase = claseService.encontrarClase(clase);
        model.addAttribute("clase", clase);
        return "modificarClase";
    }

    @GetMapping("/eliminarClase/{idclase}")
    public String eliminar(Clase clase) {
        claseService.eliminar(clase);
        return "redirect:/lisClases";
    }
}
