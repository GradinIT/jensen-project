package se.jensen.project.department.unittest.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.jensen.project.department.dao.DepartmentDao;
import se.jensen.project.department.dao.DepartmentDatabaseEntry;
import se.jensen.project.department.test.config.LiquibaseTestConfigurer;
import se.jensen.project.department.test.config.PersistenceTestConfig;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {LiquibaseTestConfigurer.class, PersistenceTestConfig.class})
public class TestDepartmentDao {
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void testGetDepartmentById() {
        Integer departmetId = 1;
        Optional<DepartmentDatabaseEntry> optionalEmployeeDatabaseEntry = departmentDao.findById(departmetId);
        Assertions.assertAll(
                () -> assertTrue(optionalEmployeeDatabaseEntry.isPresent()),
                () -> assertNotNull(optionalEmployeeDatabaseEntry.get()),
                () -> assertEquals("Development", optionalEmployeeDatabaseEntry.get().getDepartmentName()),
                () -> assertEquals(departmetId, optionalEmployeeDatabaseEntry.get().getDepartmentId())
        );
    }

    @Test
    public void testGetDepartments() {
        List<DepartmentDatabaseEntry> departments = departmentDao.findAll();
        Assertions.assertAll(
                () -> assertNotNull(departments),
                () -> assertEquals(5, departments.size())
        );
    }
}
