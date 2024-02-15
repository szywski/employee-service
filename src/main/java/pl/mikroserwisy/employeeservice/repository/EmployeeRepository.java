package pl.mikroserwisy.employeeservice.repository;

import org.springframework.stereotype.Repository;
import pl.mikroserwisy.employeeservice.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee (final Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(final Long id) {
        return employees.stream()
                .filter(employee ->
                        employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByBackoffice(final Long backofficeId) {
        return employees.stream().filter(employee -> employee.backofficeId().equals(backofficeId)).toList();
    }
}
