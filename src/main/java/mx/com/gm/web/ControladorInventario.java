package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Inventario;
import mx.com.gm.servicio.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInventario {
    
    @Autowired
    private InventarioService inventarioService;
    
    @GetMapping("/lisInventarios")
    public String lisInventarios(Model model) {
        var inventarios = inventarioService.listarInventarios();
        log.info("ejecutar el controlador Spring mvc");
        model.addAttribute("inventarios", inventarios);
        return "lisInventarios";
    }
    @GetMapping("/agregarInventario")
    public String agregar(Inventario inventario) {
        return "modificarInventario";
    }
 @PostMapping("/guardarInventario")
    public String guardar(@Valid Inventario inventario, Errors errores) {
        if (errores.hasErrors()) {
            return "modificarInventario";
        }
        inventarioService.guardar(inventario);
        return "redirect:/lisInventarios";
    }
    @GetMapping("/editarInventario/{idinventario}")
    public String editar(Inventario inventario, Model model) {
        inventario = inventarioService.encontrarInventario(inventario);
        model.addAttribute("inventario", inventario);
        return "modificarInventario";
    }
    @GetMapping("/eliminarInventario/{idinventario}")
    public String eliminar(Inventario inventario) {
        inventarioService.eliminar(inventario);
        return "redirect:/lisInventarios";
    }
}
