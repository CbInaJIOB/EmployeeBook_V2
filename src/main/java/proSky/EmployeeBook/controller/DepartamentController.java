package proSky.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proSky.EmployeeBook.model.Employee;
import proSky.EmployeeBook.service.DepartamentService;

import java.util.Collection;

@RestController
@RequestMapping("/departament")
public class DepartamentController {
    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam ("dep")int dep) {
        return departamentService.max(dep);
    }

    @GetMapping("/min-salary")
    public Employee min(@RequestParam ("dep")int dep) {
        return departamentService.min(dep);
    }

    @GetMapping("/all/byDep")
    public Collection<Employee> byDep(@RequestParam ("dep")int dep) {
        return departamentService.byDep(dep);
    }

    @GetMapping("/all")
    public Collection<Employee> all() {
        return departamentService.all();
    }






}
