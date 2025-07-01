package sem4.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать справочник сотрудников
 * Необходимо:
 * Создать класс справочник сотрудников, который содержит внутри
 * коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавления нового сотрудника в справочник
 */

public class Main {
    public static void main(String[] args) {
        EmployeeBook eb = new EmployeeBook();
        eb.addEmployee(new Employee(123, 1234566, "dima", 2));
        eb.addEmployee(new Employee(1236, 12345654, "dima", 2));
        eb.addEmployee(new Employee(1237, 123453436, "riko", 2));
        eb.addEmployee(new Employee(1238, 123423256, "lika", 2));
        eb.addEmployee(new Employee(1239, 123343456, "vika", 4));
        eb.addEmployee(new Employee(1243, 1234325356, "nika", 3));
        System.out.println(eb.findEmployeeByTabel(123));

        List<Integer> phones = eb.findNumberByName("lika");
        phones.forEach(i -> System.out.println(i+ " "));

        List<Employee> exp = eb.findEmployeeByExperience(2);
        exp.forEach(i -> System.out.println(i));
    }
}
