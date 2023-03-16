package com.academy;

import com.academy.model.entity.Employee;
import com.academy.model.repository.impl.EmployeeRepositoryImpl;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        var employeeRepository = new EmployeeRepositoryImpl();

        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            System.out.println(employee.getId() + " " + employee.getName());
        }

        var employee = employeeRepository.findById(1);
        System.out.println(employee.getId() + " " + employee.getName());

/*
        var newEmployee = new Employee();
        newEmployee.setName("Slava");
        newEmployee.setSurname("Pupkin");
        newEmployee.setDob(1988);

        employeeRepository.create(newEmployee);*/













      /*  Class.forName("com.mysql.cj.jdbc.Driver");




        var prop = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        comboPooledDataSource.setJdbcUrl(prop.getProperty("db.url"));
        comboPooledDataSource.setUser(prop.getProperty("db.user"));
        comboPooledDataSource.setPassword(prop.getProperty("db.password"));

        comboPooledDataSource.setMinPoolSize(2);
        comboPooledDataSource.setMaxPoolSize(3);


        Connection connection=comboPooledDataSource.getConnection();*/

        //Connection connection = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.password"));
        //  connection.setAutoCommit(false);


        //Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/academy","admin","admin");

        //var statment = connection.createStatement();
/*

        int id = 3;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

*/

        //int i = statment.executeUpdate("delete from employee where id=2 ");

        // ResultSet resultSet = statment.executeQuery("select * from employee");
/*

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " "
                    + resultSet.getString("name") + " "
                    + resultSet.getString("surname") + " "
                    + resultSet.getInt("dob") + " "
                    + resultSet.getInt("phone") + " "
                    + resultSet.getString("title") + " "
                    + resultSet.getInt("salary"));
        }
        resultSet.close();
       preparedStatement.close();
      // connection.close();

*/


    }
}
