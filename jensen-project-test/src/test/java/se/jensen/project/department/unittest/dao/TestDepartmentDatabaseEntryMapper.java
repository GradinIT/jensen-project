package se.jensen.project.department.unittest.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.jensen.project.department.dao.DepartmentDatabaseEntry;
import se.jensen.project.department.dao.DepartmentDatabaseEntryMapper;
import se.jensen.project.department.entity.Department;
import se.jensen.project.department.test.builder.DepartmentDatabaseEntryTestBuilder;
import se.jensen.project.department.test.builder.DepartmentTestBuilder;

import java.util.Arrays;
import java.util.List;

public class TestDepartmentDatabaseEntryMapper {
    private final Department DEPARTMENT = DepartmentTestBuilder.build();
    private final DepartmentDatabaseEntry DEPARTMENT_DATABASE_ENTRY = DepartmentDatabaseEntryTestBuilder.build();

    @Test
    public void testDepartmentToDatabaseEntry() {
        DepartmentDatabaseEntry entry = DepartmentDatabaseEntryMapper.map(DEPARTMENT);
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(DEPARTMENT_DATABASE_ENTRY,entry);
    }

    @Test
    public void testDatabaseEntryToDepartment() {
        Department department = DepartmentDatabaseEntryMapper.map(DEPARTMENT_DATABASE_ENTRY);
        Assertions.assertNotNull(department);
        Assertions.assertEquals(DEPARTMENT,department);
    }

    @Test
    public void testEntriesToDepartments() {
        List<Department> DEPARTMENTS = Arrays.asList(DEPARTMENT);
        List<DepartmentDatabaseEntry> ENTRIES = Arrays.asList(DEPARTMENT_DATABASE_ENTRY);
        List<Department> departments = DepartmentDatabaseEntryMapper.map(ENTRIES);
        Assertions.assertNotNull(departments);
        Assertions.assertEquals(DEPARTMENTS,departments);
    }
}
