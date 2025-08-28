package proSky.EmployeeBook.service;

import proSky.EmployeeBook.model.Employee;

import java.util.Collection;

public interface DepartamentService {
    Employee max(int dep);

    Employee min(int dep);

    Collection<Employee> byDep(int dep);

    Collection<Employee> all();
}
