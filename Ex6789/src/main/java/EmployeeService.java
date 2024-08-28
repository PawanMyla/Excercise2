package com.tcs.Ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save or update an employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // Find an employee by name
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    // Find all employees
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // Calculate net salary
    public Double calculateNetSalary(Employee employee) {
        double grossSalary = employee.getBasic() + employee.getHra() + employee.getDa();
        double tax = 0.15 * grossSalary;
        double netSalary = grossSalary - (tax + employee.getDeductions());
        return netSalary;
    }

    // Delete an employee by ID
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
