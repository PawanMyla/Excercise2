package com.tcs.Ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 1. GET all employees (READ)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    // 2. GET net salary of employee by name (READ)
    @GetMapping("/{name}")
    public Double getNetSalary(@PathVariable String name) {
        Employee employee = employeeService.findEmployeeByName(name);
        if (employee != null) {
            return employeeService.calculateNetSalary(employee);
        }
        return null;
    }

    // 3. POST to add a new employee (CREATE)
    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    // 4. PUT to update an existing employee (UPDATE)
    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee); // save() will update if the employee exists
    }

    // 5. DELETE an employee by ID (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
