package pro.sky.skyproemployeebookcoursework.services;

import pro.sky.skyproemployeebookcoursework.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
