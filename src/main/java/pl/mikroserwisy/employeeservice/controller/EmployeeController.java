package pl.mikroserwisy.employeeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mikroserwisy.employeeservice.model.Employee;
import pl.mikroserwisy.employeeservice.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public static final Logger LOGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository repository;

    @PostMapping
    public Employee addEmployee(@RequestBody final Employee employee) {
        LOGER.info("Employee add: {}", employee);
        return repository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable final Long id) {
        return repository.findById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    @GetMapping("/backoffice/{id}")
    public List<Employee> getEmployeesForBackoffice(@PathVariable Long backofficeId) {
        return repository.findByBackoffice(backofficeId);
    }

}
