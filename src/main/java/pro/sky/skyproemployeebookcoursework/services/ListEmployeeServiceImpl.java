package pro.sky.skyproemployeebookcoursework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
@Primary
public class ListEmployeeServiceImpl implements EmployeeService {
    private static final int CAPASITY = 10;
    private final Map<String, Employee> staff;

    public ListEmployeeServiceImpl() {
        this.staff = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {
        Employee temp = new Employee(firstName, lastName, salary, departmentId);
        if (staff.size() >= CAPASITY) {
            throw new EmployeeStorageIsFullException();
        }
        if (staff.containsKey(temp.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.put(temp.getFullName(), temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, double salary, int departmentId) {

//        int index = staff.indexOf(new Employee(firstName, lastName));
//        if (index == -1) {
//            throw new EmployeeNotFoundException();
//        }
//        return staff.remove(index);
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (staff.containsKey(employee.getFullName())) {
            return staff.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, double salary, int departmentId) {

//        int index = staff.indexOf(new Employee(firstName, lastName));
//        if (index == -1) {
//            throw new EmployeeNotFoundException();
//        }
//        return staff.get(index);

        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (staff.containsKey(employee.getFullName())) {
            return staff.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(staff.values());
    }
}
