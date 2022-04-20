package Proyecto.demo.Controller;

import Proyecto.demo.Entity.Employee;
import Proyecto.demo.Repository.EmployeeRepository;
import Proyecto.demo.Service.ReportService;
import java.io.FileNotFoundException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerReportes {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ReportService service;

    
    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

}
