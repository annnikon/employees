package com.aimprosoft.task1.dao;

import com.aimprosoft.task1.model.Department;
import com.aimprosoft.task1.utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class MysqlDepartmentDao implements DepartmentDao {

    private Connection connection;

    public MysqlDepartmentDao() {
        connection = MysqlUtils.getConnection();

    }



    public Iterable<Department> list() throws SQLException {
        HashSet<Department> list = new HashSet<>();
        PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT name, info from departments");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                Department department = new Department();
                department.setName(resultSet.getString("name"));
                department.setInfo(resultSet.getString("info"));
                list.add(department);

            }

        return list;

    }

    public void add(Department department) throws SQLException{

        String sql = "INSERT INTO departments"
                + "(name, info) VALUES"
                + "(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getInfo());
            preparedStatement.executeUpdate();

    }

    public Department getByName(String name) throws SQLException{

           Department department = null;
           PreparedStatement  preparedStatement = connection.prepareStatement
                   ("SELECT name, info from departments where name = ?");
           preparedStatement.setString(1, name);
           ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet == null) {
               return null;
           }
           if (resultSet.next()) {
               department = new Department();
               department.setName(resultSet.getString("name"));
               department.setInfo(resultSet.getString("info"));


           }
           return department;

    }

    public void update(String name, Department newDepartment) throws SQLException {


           String sql = "UPDATE departments SET name = ?, info = ? WHERE name = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, newDepartment.getName());
           preparedStatement.setString(2, newDepartment.getInfo());
           preparedStatement.setString(3, name);
           preparedStatement.executeUpdate();
       }


    public void delete(String name) throws SQLException {
          String sql = "DELETE from departments where name = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }



}
