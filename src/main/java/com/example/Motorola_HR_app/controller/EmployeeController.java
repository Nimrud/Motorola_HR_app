package com.example.Motorola_HR_app.controller;

import com.example.Motorola_HR_app.model.Employee;
import com.example.Motorola_HR_app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }


    @GetMapping("/employees/{id}")
    public String getEmployeeById(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee_id";
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:employees";

    }


    @GetMapping("/admin/employeeForm")
    public String showNewEmployeeForm(Model model, @RequestParam(required = false, defaultValue = "1") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            employee = new Employee();
        }
        model.addAttribute("employee", employee);
        return "new_employee";
    }


    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:employees";
    }

}
