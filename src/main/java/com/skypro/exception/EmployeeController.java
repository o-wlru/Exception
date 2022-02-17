package com.skypro.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private EmployeeCollectionService employeeService;

    public EmployeeController(EmployeeCollectionService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String greetEmployee() {
        return "Добро пожаловать!";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("secondName") String secondName) {
        return "Сотрудник " + secondName + " " + firstName + " успешно создан";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("secondName") String secondName) {
        return "Сотрудник " + secondName + " " + firstName + " удален";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("secondName") String secondName) {
        Employee foundEmployee = employeeService.findEmployee(firstName, secondName);
        return foundEmployee;
    }

    @GetMapping("/getAllEmployees")
    public Set<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
