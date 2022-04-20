
package Proyecto.demo.Controller;

import Proyecto.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class IndexController {


    @Autowired
    private ProductoService productoService;
            
    @GetMapping("")
    public String index(Model model){
        
        model.addAttribute("productos" , productoService.findAll());
        
        return "usuario/home";
        
    }
    
}
