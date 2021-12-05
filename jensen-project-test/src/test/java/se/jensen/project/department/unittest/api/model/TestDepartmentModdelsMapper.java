package se.jensen.project.department.unittest.api.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.jensen.project.department.api.DepartmentModel;
import se.jensen.project.department.api.mapper.DepartmentModelsMapper;
import se.jensen.project.department.entity.Department;
import se.jensen.project.department.test.builder.DepartmentModelTestBuilder;
import se.jensen.project.department.test.builder.DepartmentTestBuilder;

import java.util.Arrays;
import java.util.List;

public class TestDepartmentModdelsMapper {
   @Test
   public void testDepartmentModelsMapper() {
       List<Department> DEPARTMENTS = Arrays.asList(DepartmentTestBuilder.build());
       List<DepartmentModel> DEPARTMENT_MODELS= Arrays.asList(DepartmentModelTestBuilder.build());
        List<DepartmentModel> departmentModels = DepartmentModelsMapper.map(DEPARTMENTS);
       Assertions.assertAll(
               ()->Assertions.assertNotNull(departmentModels),
               ()->Assertions.assertEquals(DEPARTMENT_MODELS,departmentModels)
       );
   }
}
