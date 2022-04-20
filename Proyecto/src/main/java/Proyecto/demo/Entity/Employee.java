package Proyecto.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "empleados")
public class Employee {

    @Id
    private int id;
    private String nombre;
    private String cargo;
    private double salario;
    private String ingreso;
}
