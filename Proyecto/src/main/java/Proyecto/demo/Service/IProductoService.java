
package Proyecto.demo.Service;

import Proyecto.demo.Entity.Producto;
import java.util.List;
import java.util.Optional;


public interface IProductoService {
    
    public Producto save(Producto producto);
    
    //Nos ayuda a validar la existencia del objeto
    public Optional <Producto> get(Integer id);
    
    public void update(Producto producto);
    
    public void delete(Integer id);
    
    public List<Producto> findAll();
    
}
