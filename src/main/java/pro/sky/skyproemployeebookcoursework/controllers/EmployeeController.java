package pro.sky.skyproemployeebookcoursework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.services.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/departments")
    public String welcome() {
        return "Welcome to Departments";
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") double salary,
            @RequestParam("department") int departmentId) {
        return service.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") double salary,
            @RequestParam("department") int departmentId) {
        return service.findEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") double salary,
            @RequestParam("department") int departmentId) {
        return service.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/departments/max-salary")
    public Employee getMaxPaidByDepart(@RequestParam("departmentid") int departmentId) {
        return service.getMaxPaidByDepart(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee getMinPaidByDepart(@RequestParam("departmentid") int departmentId) {
        return service.getMinPaidByDepart(departmentId);
    }

    @GetMapping("/departments/all")
    public List<Employee> getEmployeeByDepart(@RequestParam(value = "departmentid", required = false) Integer departmentId) {
        if (departmentId == null) {
            return service.showAll();
        }
        return service.showByDepart(departmentId);
    }
}
