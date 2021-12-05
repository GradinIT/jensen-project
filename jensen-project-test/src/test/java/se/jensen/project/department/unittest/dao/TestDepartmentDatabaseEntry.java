package se.jensen.project.department.unittest.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.jensen.project.department.dao.DepartmentDatabaseEntry;
import se.jensen.project.department.test.builder.DepartmentDatabaseEntryTestBuilder;

public class TestDepartmentDatabaseEntry {
    private static final DepartmentDatabaseEntry ENTRY = DepartmentDatabaseEntryTestBuilder.build();

    @Test
    public void testThatDepartmentIsCreated () {
        DepartmentDatabaseEntry department = DepartmentDatabaseEntry.builder()
                .departmentId(ENTRY.getDepartmentId())
                .departmentName(ENTRY.getDepartmentName())
                .build();

        Assertions.assertEquals(ENTRY,department);
        Assertions.assertEquals(ENTRY.getDepartmentName(), department.getDepartmentName());
        Assertions.assertEquals(ENTRY.getDepartmentId(), department.getDepartmentId());
        String DEPARTMENT_TO_STRING_VALUE = ENTRY.toString();
        String department_to_string_value = department.toString();
        Assertions.assertEquals(DEPARTMENT_TO_STRING_VALUE,department_to_string_value);
    }
    @Test
    public void testThatNullPointerExceptionIsRaisedWhenNotProvidingDepartmentId() {
        Assertions.assertThrows(NullPointerException.class ,
                () -> DepartmentDatabaseEntry.builder().departmentName(ENTRY.getDepartmentName()).build());

    }
    @Test
    public void testThatNullPointerExceptionIsRaisedWhenNotProvidingDepartmentName() {
        Assertions.assertThrows(NullPointerException.class ,
                () -> DepartmentDatabaseEntry.builder().departmentId(ENTRY.getDepartmentId()).build());

    }
}