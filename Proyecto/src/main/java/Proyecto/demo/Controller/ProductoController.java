/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.demo.Controller;

import Proyecto.demo.Entity.Producto;
import Proyecto.demo.Entity.Usuario;
import Proyecto.demo.Repository.ProductoRepository;
import Proyecto.demo.Service.CargarImagenService;
import Proyecto.demo.Service.ProductoService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sebas
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    
    
    @Autowired
    private CargarImagenService cargar;

    @Autowired
    private ProductoService productoService;

    
    
    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);
        //Subida de imagen
        if (producto.getId() == null) {
            String nombreImagen = cargar.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {

        }
        productoService.save(producto);
        return "redirect:/productos";
    }

    //PathVariable nos ayuda a localizar la variable id en la url
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        //Si el producto se edita pero la imagen esta vacia pone la misma
        if (file.isEmpty()) {
            Producto p = new Producto();
            p = productoService.get(producto.getId()).get();
            producto.setImagen(p.getImagen());
        } else {
            Producto p = new Producto();
            p=productoService.get(producto.getId()).get();
            
            if(!p.getImagen().equals("default.png")){
                cargar.EliminarImagen(p.getImagen());
            }
            
            String nombreImagen = cargar.saveImage(file);
            producto.setImagen(nombreImagen);
        }

        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Producto p= new Producto();
        p= productoService.get(id).get();
        //Eliminar cuando la imagen no sea la que este por determinado esto para que en catalogo siempre tenga la estrcutura
        if(p.getImagen().equals("default.png")){
            cargar.EliminarImagen(p.getImagen());
        }
        productoService.delete(id);
        return "redirect:/productos";

    }
}
