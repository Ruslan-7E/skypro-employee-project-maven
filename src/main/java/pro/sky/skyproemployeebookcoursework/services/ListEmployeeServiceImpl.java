package pro.sky.skyproemployeebookcoursework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ListEmployeeServiceImpl implements EmployeeService {
    private static final int CAPASITY = 10;
    List<Employee> staff = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (staff.size() >= CAPASITY) {
            throw new EmployeeStorageIsFullException();
        }
        if (staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        int index = staff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.remove(index);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        int index = staff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.get(index);
    }
}
