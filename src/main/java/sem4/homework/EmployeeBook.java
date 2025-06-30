package sem4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeBook {
    List<Employee> employees;

    public EmployeeBook(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }

    public Employee findEmployeeByTabel(int tabel){
        Set<Employee> set = employees.stream().collect(Collectors.toSet());
        return set.stream().filter(emp -> emp.getTabel() == tabel).findFirst().orElse(null);
    }

}
