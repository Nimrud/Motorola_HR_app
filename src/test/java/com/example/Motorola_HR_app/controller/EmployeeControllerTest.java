package com.example.Motorola_HR_app.controller;

import com.example.Motorola_HR_app.model.Employee;
import com.example.Motorola_HR_app.model.Payment;
import com.example.Motorola_HR_app.repository.EmployeeRepository;
import com.example.Motorola_HR_app.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import java.util.Optional;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {




    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;


    @Test
    public void getAllEmployees() {
        //given:
        Employee employee1 = new Employee(1L, "A", "B", "99887766554", "aaa", "position", "description", new Payment());
        Employee employee2 = new Employee(2L, "CC", "CB", "99887766554", "aaa", "position", "description", new Payment());
        List<Employee> expected = Arrays.asList(employee1, employee2);
        when(employeeRepository.findAll()).thenReturn(expected);

        //when-then
        Assertions.assertArrayEquals(employeeService.getAllEmployees().toArray(), expected.toArray());

    }

    @Test
    public void getEmployeeById(){
        //given:
        Employee employee1 = new Employee(1L, "A", "B", "99887766554", "aaa", "position", "description", new Payment());
        Employee employee2 = new Employee(2L, "CC", "CB", "99887766554", "aaa", "position", "description", new Payment());
        List<Employee> expected = Arrays.asList(employee1, employee2);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));

        //when-then
        Assertions.assertEquals(employeeService.getEmployeeById(1L), employee1);
        Assertions.assertThrows(RuntimeException.class, ()->{
            employeeService.getEmployeeById(3L);
        }, " Employee not found for id :: 3");
    }

}