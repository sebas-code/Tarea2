/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.demo.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CargarImagenService {
    private String folder="imagenes//";
    
    //MultipartFile nos sirve para subir la imagen
    public String saveImage(MultipartFile file) throws IOException{
        if(!file.isEmpty()){
            //Pasamos la imagen a 1 y 0 para poder manejarla
            byte [] bytes=file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
            
        }
            
        return "default.png";
    }
    
    public void EliminarImagen(String nombre){
        String ruta="imagenes//";
        File file= new File(ruta+nombre);
        file.delete();
    }
}
