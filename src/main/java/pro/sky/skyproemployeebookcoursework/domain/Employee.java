package pro.sky.skyproemployeebookcoursework.domain;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private final double salary;
    private final int departmentId;

    public Employee(String fullName, double salary, int departmentId) {
        this.fullName = fullName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0
                && departmentId == employee.departmentId
                && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, departmentId);
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", salary='" + salary + '\'' +
                ", departmentId'" + departmentId + '\'' +
                '}';
    }

}
