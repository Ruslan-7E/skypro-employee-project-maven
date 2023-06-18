package pro.sky.skyproemployeebookcoursework.domain;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;
    private final int departmentId;

    public Employee(String firstName, String lastName, double salary, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }


    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                ", salary='" + salary + '\'' +
                ", departmentId'" + departmentId + '\'' +
                '}';
    }

}
