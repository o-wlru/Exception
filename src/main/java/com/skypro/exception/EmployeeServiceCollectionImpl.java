package com.skypro.exception;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceCollectionImpl implements EmployeeCollectionService {

    private Set<Employee> employees = new HashSet<>();

    @Override
    public Employee addEmployee(String firstName, String secondName) {

        Employee addingEmployee = new Employee(firstName, secondName);

        if (employees.contains(addingEmployee)) {
            throw new EmployeeExistsExeption("Этот сотрудник уже в списке");
        }

        employees.add(addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        Employee removingEmployee = new Employee(firstName, secondName);

        if (employees.remove(removingEmployee)) {
            throw new EmployeeNotFoundExeption("Этот сотрудник не найден");
        }
        return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        Employee findingEmployee = new Employee(firstName, secondName);

        if (employees.contains(findingEmployee)) {
            throw new EmployeeNotFoundExeption("Этот сотрудник не найден");
        }
        return findingEmployee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employees;
    }

}
