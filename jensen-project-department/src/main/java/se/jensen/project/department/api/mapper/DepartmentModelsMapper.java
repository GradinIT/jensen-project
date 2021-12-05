package se.jensen.project.department.api.mapper;


import se.jensen.project.department.api.DepartmentModel;
import se.jensen.project.department.entity.Department;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentModelsMapper {
    public static List<DepartmentModel> map(List<Department> departments) {
        return departments.stream().map(DepartmentModelMapper::map).collect(Collectors.toList());
    }
}
