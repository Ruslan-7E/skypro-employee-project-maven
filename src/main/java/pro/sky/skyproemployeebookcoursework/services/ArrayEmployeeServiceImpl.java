//package pro.sky.skyproemployeebookcoursework.services;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//import pro.sky.skyproemployeebookcoursework.domain.Employee;
//import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeAlreadyAddedException;
//import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeNotFoundException;
//import pro.sky.skyproemployeebookcoursework.exceptions.EmployeeStorageIsFullException;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Primary
//@Service
//public class ArrayEmployeeServiceImpl implements EmployeeService{
//    private static final int CAPACITY = 10;
//    private Employee[] staff = new Employee[CAPACITY];
//
//        ArrayEmployeeServiceImpl() {
//            staff[0] = new Employee("John", "Snow", 50.0, 1);
//            staff[1] = new Employee("Michael", "Jordan", 55.0, 2);
//            staff[2] = new Employee("James", "Gosling", 60.0, 3);
//            staff[3] = new Employee("Ruslan", "Expert", 45.0, 3);
//            staff[4] = new Employee("Vasya", "Ryzhov", 65.0, 2);
//            staff[5] = new Employee("Peter", "Parker", 35.0, 1);
//        }
//
//    private int currentSize = 0;
//    @Override
//    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {
//        if (currentSize >= CAPACITY) {
//            throw new EmployeeStorageIsFullException();
//        }
//        Employee temp = new Employee(firstName, lastName, salary, departmentId);
//        for (Employee emp : staff) {
//            if (Objects.equals(emp, temp)) {
//                throw new EmployeeAlreadyAddedException();
//            }
//        }
//        staff[currentSize] = temp;
//        currentSize++;
//        return temp;
//    }
//
//    @Override
//    public Employee removeEmployee(String firstName, String lastName, double salary, int departmentId) {
//        Employee temp = new Employee(firstName, lastName, salary, departmentId);
//        int i;
//        for (i = 0; i < currentSize; ++i) {
//            if (staff[i].equals(temp)) break;
//        }
//
//        if (i == currentSize) {
//            throw new EmployeeNotFoundException();
//        }
//
//        for (int j = i; j < currentSize; j++) {
//            staff[j] = staff[j + 1];
//        }
//        currentSize--;
//        return temp;
//    }
//
//    @Override
//    public Employee findEmployee(String firstName, String lastName, double salary, int departmentId) {
//        Employee temp = new Employee(firstName, lastName, salary, departmentId);
//        for (var emp : staff) {
//            if (Objects.equals(emp, temp)) return emp;
//        }
//        throw new EmployeeNotFoundException();
//    }
//
//    @Override
//    public Collection<Employee> findAll() {
//        return null;
//    }
//
//    @Override
//    public Employee getMaxPaidByDepart(int departmentId) {
//        return Arrays.stream(staff)
//                .filter(Objects::nonNull)
//                .filter(e -> e.getDepartmentId() == departmentId)
//                .max(Comparator.comparingDouble(Employee::getSalary))
//                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid!"));
//    }
//
//    @Override
//    public Employee getMinPaidByDepart(int departmentId) {
//        return Arrays.stream(staff)
//                .filter(Objects::nonNull)
//                .filter(e -> e.getDepartmentId() == departmentId)
//                .min(Comparator.comparingDouble(Employee::getSalary))
//                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid!"));
//    }
//
//    @Override
//    public List<Employee> showAll() {
//        return Arrays.stream(staff)
//                .filter(Objects::nonNull)
//                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public List<Employee> showByDepart(int department) {
//        return Arrays.stream(staff)
//                .filter(Objects::nonNull)
//                .filter(e -> e.getDepartmentId() == department)
//                .collect(Collectors.toList());
//    }
//}
