package com.skypro.exception;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String secondName;

    public Employee(String secondName, String firstName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }


    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(secondName, employee.secondName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondName, firstName);
    }
    @Override
    public String toString() {
        return "Employee: " + " secondname=" + secondName + " firstname=" + firstName;
    }


}
