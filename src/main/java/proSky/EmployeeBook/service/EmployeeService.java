package proSky.EmployeeBook.service;

import proSky.EmployeeBook.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departament, float salary);
    Employee remove(String firstName, String lastName, int departament, float salary);
    Employee find(String firstName, String lastName, int departament, float salary);

    Collection<Employee> findAll();


}
