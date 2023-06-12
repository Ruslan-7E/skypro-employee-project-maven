package pro.sky.skyproemployeebookcoursework.services;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Objects;

@Service
public class ArrayEmployeeServiceImpl implements EmployeeService{
    private static final int CAPACITY = 10;
    private Employee[] staff = new Employee[CAPACITY];
    private int currentSize = 0;
    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {
        if (currentSize >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        Employee temp = new Employee(firstName, lastName, salary, departmentId);
        for (Employee emp : staff) {
            if (Objects.equals(emp, temp)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        staff[currentSize] = temp;
        currentSize++;
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, double salary, int departmentId) {
        Employee temp = new Employee(firstName, lastName, salary, departmentId);
        int i;
        for (i = 0; i < currentSize; ++i) {
            if (staff[i].equals(temp)) break;
        }

        if (i == currentSize) {
            throw new EmployeeNotFoundException();
        }

        for (int j = i; j < currentSize; j++) {
            staff[j] = staff[j + 1];
        }
        currentSize--;
        return temp;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, double salary, int departmentId) {
        Employee temp = new Employee(firstName, lastName, salary, departmentId);
        for (var emp : staff) {
            if (Objects.equals(emp, temp)) return emp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }
}
