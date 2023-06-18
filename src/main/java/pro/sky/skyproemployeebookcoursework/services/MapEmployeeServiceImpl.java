package pro.sky.skyproemployeebookcoursework.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MapEmployeeServiceImpl implements EmployeeService {
    private static final int CAPASITY = 10;
    private Map<String, Employee> staff = new HashMap<>();

    MapEmployeeServiceImpl() {
        staff.put("John Snow", new Employee("John", "Snow", 50.0, 1));
        staff.put("Michael Jordan", new Employee("Michael", "Jordan", 55.0, 2));
        staff.put("James Gosling", new Employee("James", "Gosling", 60.0, 3));
        staff.put("Ruslan Expert", new Employee("Ruslan", "Expert", 45.0, 3));
        staff.put("Vasya Ryzhov", new Employee("Vasya", "Ryzhov", 65.0, 2));
        staff.put("Peter Parker", new Employee("Peter", "Parker", 35.0, 1));
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {

        if (!validateInput(firstName, lastName)) {
            throw new IllegalArgumentException();
        }

        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (staff.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, double salary, int departmentId) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, double salary, int departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Override
    public Employee getMaxPaidByDepart(int departmentId) {
        return staff.values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid!"));
    }

    @Override
    public Employee getMinPaidByDepart(int departmentId) {
        return staff.values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid!"));
    }

    @Override
    public Map<Integer, List<Employee>> showAll() {
        return staff.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public List<Employee> showByDepart(int department) {
        return staff.values().stream()
                .filter(e -> e.getDepartmentId() == department)
                .collect(Collectors.toList());
    }

    private boolean validateInput(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }
}
