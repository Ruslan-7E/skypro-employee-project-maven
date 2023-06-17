package pro.sky.skyproemployeebookcoursework.services;

import pro.sky.skyproemployeebookcoursework.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

//    Employee addEmployee(String firstName, String lastName, double salary, int departmentId);
//
//    Employee removeEmployee(String firstName, String lastName, double salary, int departmentId);
//
//    Employee findEmployee(String firstName, String lastName, double salary, int departmentId);
//
//    Collection<Employee> findAll();

    Employee getMaxPaidByDepart(int departmentId);

    Employee getMinPaidByDepart(int departmentId);

    Map<Integer, List<Employee>> showAll();

    List<Employee> showByDepart(int department);


}
