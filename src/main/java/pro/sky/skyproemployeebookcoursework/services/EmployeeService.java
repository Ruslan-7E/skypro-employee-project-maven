package pro.sky.skyproemployeebookcoursework.services;

import pro.sky.skyproemployeebookcoursework.domain.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, double salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName, double salary, int departmentId);

    Employee findEmployee(String firstName, String lastName, double salary, int departmentId);

    Collection<Employee> findAll();
}
