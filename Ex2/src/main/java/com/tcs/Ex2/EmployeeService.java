package com.tcs.Ex2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Double calculateNetSalary(Employee employee) {
        double grossSalary = employee.getBasic() + employee.getHra() + employee.getDa();
        double tax = 0.15 * grossSalary;
        double netSalary = grossSalary - (tax + employee.getDeductions());
        return netSalary;
    }
}