package com.tcs.Ex2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Marques", 50000, 10000, 5000, 2000),
                new Employee(2, "Alice Johnson", 60000, 12000, 6000, 2500),
                new Employee(3, "Bob Smith", 55000, 11000, 5500, 2200),
                new Employee(4, "Carol White", 65000, 13000, 6500, 2700),
                new Employee(5, "David Brown", 70000, 14000, 7000, 3000),
                new Employee(6, "Eva Green", 48000, 9600, 4800, 1800),
                new Employee(7, "Frank Black", 52000, 10400, 5200, 1900),
                new Employee(8, "Grace Blue", 58000, 11600, 5800, 2400),
                new Employee(9, "Henry Gray", 62000, 12400, 6200, 2600),
                new Employee(10, "Ivy Yellow", 53000, 10600, 5300, 2000)
        );

        for (Employee emp : employees) {
            employeeService.saveEmployee(emp);
        }
    }

    @GetMapping("/{name}")
    public Double getNetSalary(@PathVariable String name) {
        Employee employee = employeeService.findEmployeeByName(name);
        if (employee != null) {
            return employeeService.calculateNetSalary(employee);
        }
        return null;
    }
}