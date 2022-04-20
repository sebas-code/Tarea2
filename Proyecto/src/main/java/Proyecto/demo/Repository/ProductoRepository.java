
package Proyecto.demo.Repository;

import Proyecto.demo.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
    
    
    
}
