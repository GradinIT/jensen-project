package se.jensen.project.department.unittest.api.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.jensen.project.department.api.DepartmentModel;
import se.jensen.project.department.api.mapper.DepartmentModelMapper;
import se.jensen.project.department.entity.Department;
import se.jensen.project.department.test.builder.DepartmentTestBuilder;

public class TestDepartmentModelMapper {
    private static final Department DEPARTMENT = DepartmentTestBuilder.build();
    private static final DepartmentModel DEPARTMENT_MODEL = DepartmentModel.builder()
            .departmentId(DEPARTMENT.getDepartmentId().getId())
            .departmentName(DEPARTMENT.getDepartmentName())
            .build();

    @Test
    public void testThatDepartmentModelIsEqualToDepartment() {
        DepartmentModel departmentModel = DepartmentModelMapper.map(DEPARTMENT);
        Assertions.assertEquals(DEPARTMENT_MODEL,departmentModel);
        Assertions.assertEquals(DEPARTMENT.getDepartmentName(),departmentModel.getDepartmentName());
        Assertions.assertEquals(DEPARTMENT.getDepartmentId().getId(),departmentModel.getDepartmentId());
    }
    @Test
    public void testThatDepartmentIsEqualToDepartmentModel() {
        Department department = DepartmentModelMapper.map(DEPARTMENT_MODEL);
        Assertions.assertEquals(DEPARTMENT,department);
        Assertions.assertEquals(DEPARTMENT_MODEL.getDepartmentName(),department.getDepartmentName());
        Assertions.assertEquals(DEPARTMENT_MODEL.getDepartmentId(),department.getDepartmentId().getId());
    }
}
