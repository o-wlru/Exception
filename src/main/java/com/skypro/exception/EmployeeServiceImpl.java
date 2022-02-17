package com.skypro.exception;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Employee[] employees = new Employee[2];
    private int size;

    @Override
    public Employee addEmployee(String firstName, String secondName) {
        if (employees.length == size) {
            throw new EmployeeArrayFullExeption("Список сотрудников заполнен");
        }
        Employee addingEmployee = new Employee(firstName, secondName);
        int addingEmployeeIndex = getEmployeeIndex(addingEmployee);

        if (addingEmployeeIndex != -1) {
            throw new EmployeeExistsExeption("Этот сотрудник уже в списке");
        }

        employees[size++] = addingEmployee;
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        Employee removingEmployee = new Employee(firstName, secondName);
        int employeeIndex = getEmployeeIndex(removingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundExeption("Этот сотрудник не найден");
        }
        Employee removedEmployee = employees[employeeIndex];
        System.arraycopy(employees, employeeIndex + 1, employees, employeeIndex, size - employeeIndex);
        size--;
        return removedEmployee;
    }

    private int getEmployeeIndex(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employee.equals(employees[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        Employee findingEmployee = new Employee(firstName, secondName);
        int employeeIndex = getEmployeeIndex(findingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundExeption("Этот сотрудник не найден");
        }
        return employees[employeeIndex];
    }
}
