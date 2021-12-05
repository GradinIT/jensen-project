package se.jensen.project.department.api.mapper;


import se.jensen.project.department.api.DepartmentModel;
import se.jensen.project.department.entity.Department;
import se.jensen.project.department.entity.DepartmentId;

public class DepartmentModelMapper {
    public static Department map (DepartmentModel model) {
        return Department.builder()
                .departmentName(model.getDepartmentName())
                .departmentId(DepartmentId.builder().id(model.getDepartmentId()).build())
                .build();
    }
    public static DepartmentModel  map (Department department) {
        return DepartmentModel.builder()
                .departmentId(department.getDepartmentId().getId())
                .departmentName(department.getDepartmentName())
                .build();
    }
}
