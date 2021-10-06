package com.example.Motorola_HR_app.service;

import com.example.Motorola_HR_app.model.Employee;
import com.example.Motorola_HR_app.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    public List<Employee.Position> getAllPositions() {
        List<Employee.Position> positions = new ArrayList<>();
        for (Employee.Position p : EnumSet.allOf(Employee.Position.class)) {
            positions.add(p);
        }
        return positions;
    }

}
