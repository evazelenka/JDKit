package sem4.homework;

import java.util.ArrayList;
import java.util.HashSet;
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

    public List<Integer> findNumberByName(String name){
        List<Integer> employeesWithTheSameName = new ArrayList<>();
        Set<Employee> set = new HashSet<>(employees);
        set.stream().filter(emp -> emp.getName().equals(name)).forEach(emp -> employeesWithTheSameName.add(emp.getPhone()));
        return employeesWithTheSameName;
    }

    public List<Employee> findEmployeeByExperience(int exp){
        List<Employee> employeesWithTheSameExperience = new ArrayList<>();
        Set<Employee> set = new HashSet<>(employees);
        set.stream().filter(emp -> emp.getExperience() == exp).forEach(employeesWithTheSameExperience::add);
        return employeesWithTheSameExperience;
    }

}
