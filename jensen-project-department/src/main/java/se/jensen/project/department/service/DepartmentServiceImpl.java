package se.jensen.project.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensen.project.common.aspects.TimeAndLogg;
import se.jensen.project.common.dao.EntityAlreadyInStorageException;
import se.jensen.project.common.dao.EntityNotFoundException;
import se.jensen.project.department.dao.DepartmentDao;
import se.jensen.project.department.dao.DepartmentDatabaseEntry;
import se.jensen.project.department.dao.DepartmentDatabaseEntryMapper;
import se.jensen.project.department.entity.Department;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @TimeAndLogg
    public List<Department> getDepartments() {
        return DepartmentDatabaseEntryMapper.map(departmentDao.findAll());
    }

    @TimeAndLogg
    public Department getDepartmentById(Integer departmentId) {
        Optional<DepartmentDatabaseEntry> departmentDatabaseEntry = departmentDao.findById(departmentId);
        if (departmentDatabaseEntry.isPresent())
            return DepartmentDatabaseEntryMapper.map(departmentDatabaseEntry.get());
        throw new EntityNotFoundException(departmentId);
    }

    @TimeAndLogg
    public Department create(Department department) {
        Optional<DepartmentDatabaseEntry> departmentDatabaseEntry = departmentDao.findById(department.getDepartmentId().getId());
        if(departmentDatabaseEntry.isPresent())
            throw new EntityAlreadyInStorageException(department.getDepartmentId().getId());
        return DepartmentDatabaseEntryMapper.map(departmentDao.save(DepartmentDatabaseEntryMapper.map(department)));
    }

    @TimeAndLogg
    public Department update(Department department) {
        Optional<DepartmentDatabaseEntry> departmentDatabaseEntry = departmentDao.findById(department.getDepartmentId().getId());
        if(departmentDatabaseEntry.isPresent())
            return DepartmentDatabaseEntryMapper.map(departmentDao.save(DepartmentDatabaseEntryMapper.map(department)));
        throw new EntityNotFoundException(department.getDepartmentId().getId());
    }

    @TimeAndLogg
    public Department remove(Department department) {
        Optional<DepartmentDatabaseEntry> departmentDatabaseEntry = departmentDao.findById(department.getDepartmentId().getId());
        if(departmentDatabaseEntry.isPresent()) {
            departmentDao.delete(DepartmentDatabaseEntryMapper.map(department));
            return department;
        }
        throw new EntityNotFoundException(department.getDepartmentId().getId());
    }
}
