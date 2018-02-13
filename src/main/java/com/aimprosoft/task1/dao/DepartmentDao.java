package com.aimprosoft.task1.dao;

import com.aimprosoft.task1.model.Department;

public interface DepartmentDao {
    Iterable<Department> list() throws Exception;
    Department getByName(String name) throws Exception;
    void add(Department department) throws Exception;
    void delete(String name) throws Exception;
    void update(String name, Department department) throws Exception;
}
