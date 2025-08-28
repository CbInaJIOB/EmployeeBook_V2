package proSky.EmployeeBook.service;

import org.springframework.stereotype.Service;
import proSky.EmployeeBook.exception.EmployeeAlreadyAddedException;
import proSky.EmployeeBook.exception.EmployeeNotFoundException;
import proSky.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>(List.of(
            // Employee для отладки
            new Employee("Люк", "Бессон", 1, 120.0F),
            new Employee("Джейсон", "Стетхем", 1, 130.0F),
            new Employee("Жан", "Рено", 2, 120.0F),
            new Employee("Жерар", "Депардье", 2, 100.0F)

    ));

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Employee add(String firstName, String lastName, int departament, float salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int departament, float salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int departament, float salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);

        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeList);
    }


}
