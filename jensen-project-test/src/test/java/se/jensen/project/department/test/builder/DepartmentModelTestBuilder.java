package se.jensen.project.department.test.builder;


import se.jensen.project.department.api.DepartmentModel;

public class DepartmentModelTestBuilder {
    public static DepartmentModel build() {
        return DepartmentModel.builder()
                .departmentId(DepartmentTestFixture.id)
                .departmentName(DepartmentTestFixture.name)
                .build();
    }
}
