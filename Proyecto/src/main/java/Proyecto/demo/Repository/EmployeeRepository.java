
package Proyecto.demo.Repository;

import Proyecto.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
