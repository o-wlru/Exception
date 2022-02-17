package com.skypro.exception;

import java.util.Set;

public interface EmployeeCollectionService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Set<Employee> getAllEmployees();
}
