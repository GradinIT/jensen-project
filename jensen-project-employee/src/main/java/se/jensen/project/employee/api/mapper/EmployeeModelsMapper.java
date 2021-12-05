package se.jensen.project.employee.api.mapper;


import se.jensen.project.employee.api.EmployeeModel;
import se.jensen.project.employee.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeModelsMapper {
    public static List<EmployeeModel> map(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeModelMapper::map)
                .collect(Collectors.toList());
    }
}
