package proSky.EmployeeBook.service;

import org.springframework.stereotype.Service;
import proSky.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentServiceImpl implements DepartamentService {
    private EmployeeServiceImpl employeeService;

    public DepartamentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee max(int dep) {
        final Optional<Employee> maxSal = employeeService.getEmployeeList().stream()
                .filter(e -> e.getDep() == dep)
                .max(Comparator.comparingDouble(Employee::getSalary));
        return maxSal.orElseThrow(() -> new RuntimeException("Employee not found " + dep));
    }

    @Override
    public Employee min(int dep) {
        final Optional<Employee> minSal = employeeService.getEmployeeList().stream()
                .filter(e -> e.getDep() == dep)
                .min(Comparator.comparingDouble(Employee::getSalary));
        return minSal.orElseThrow(() -> new RuntimeException("Employee not found " + dep));
    }

    @Override
    public Collection<Employee> byDep(int dep) {
        return employeeService.getEmployeeList().stream()
                .filter(e -> e.getDep() == dep)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> all() {
        return new ArrayList<>(employeeService.getEmployeeList());
    }
}





