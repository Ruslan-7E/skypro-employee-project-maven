package pro.sky.skyproemployeebookcoursework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployeebookcoursework.domain.Employee;
import pro.sky.skyproemployeebookcoursework.services.EmployeeService;

import java.util.Collection;

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
            @RequestParam("lastName") String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
