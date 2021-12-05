package se.jensen.project.department.test.builder;


import se.jensen.project.department.dao.DepartmentDatabaseEntry;

public class DepartmentDatabaseEntryTestBuilder {
    public static DepartmentDatabaseEntry build() {
        return DepartmentDatabaseEntry.builder()
                .departmentId(DepartmentTestFixture.id)
                .departmentName(DepartmentTestFixture.name)
                .build();
    }
}
