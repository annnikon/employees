package com.aimprosoft.task1.dao;

import com.aimprosoft.task1.model.Employee;

public interface EmployeeDao {

    Iterable<Employee> list(String departmentName) throws Exception;
    Employee getByEmail(String email) throws Exception;
    void add(Employee employee) throws Exception;
    void delete(String email) throws Exception;
    void update(String email, Employee employee) throws Exception;
}
