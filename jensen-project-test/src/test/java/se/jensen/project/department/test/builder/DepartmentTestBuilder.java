package se.jensen.project.department.test.builder;


import se.jensen.project.department.entity.Department;
import se.jensen.project.department.entity.DepartmentId;

public class DepartmentTestBuilder {
    public static Department build() {
        return  Department.builder()
                .departmentId(DepartmentId.builder().id(DepartmentTestFixture.id).build())
                .departmentName(DepartmentTestFixture.name)
                .build();
    }
}
