package com.academy.model.repository.impl;

import com.academy.model.DataSourceManager;
import com.academy.model.entity.Department;
import com.academy.model.entity.Employee;
import com.academy.model.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    public void create(Employee employee) {
        var connection = DataSourceManager.getInstance().getConnection();

        try (var statement = connection.prepareStatement("insert into employee(name,surname,dob) values(?,?,?)")) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setInt(3, employee.getDob());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {

    }

    public void delete(Employee employee) {
        var connection = DataSourceManager.getInstance().getConnection();

        try (var statement = connection.prepareStatement("delete from employee where id = ?")) {
            statement.setInt(1, employee.getId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        var result = new ArrayList<Employee>();

        var connection = DataSourceManager.getInstance().getConnection();

        try {
            var statement = connection.prepareStatement("select e.id as employee_id, e.name,surname,dob,phone,title,salary, d.id as department_id, d.name as dep_name, address from employee e\n" +
                    "left join employee_department ed on e.id=ed.employee_id\n" +
                    "left join department d on d.id = ed.department_id");
            var rs = statement.executeQuery();
            while (rs.next()) {

                var employeeId = rs.getInt("employee_id");

                var mayBeEmployee = result.stream().filter(employee -> employee.getId() == employeeId).findFirst();

                var department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("dep_name"));
                department.setAddress(rs.getString("address"));

                List<Department> departments = new ArrayList<>();
                departments.add(department);

                if (mayBeEmployee.isEmpty()) {
                    var employee = Employee.builder()
                            .id(rs.getInt("employee_id"))
                            .name(rs.getString("name"))
                            .surname(rs.getString("surname"))
                            .dob(rs.getInt("dob"))
                            .phone(rs.getInt("phone"))
                            .title(rs.getString("title"))
                            .salary(rs.getInt("salary"))
                            .departments(departments)

                            .build();

                    result.add(employee);
                } else {
                    var employee = mayBeEmployee.get();
                    departments.add(department);
                    employee.setDepartments(departments);

                }
            }

             /*   var employee = new Employee();

                employee.setId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setDob(rs.getInt("dob"));
                employee.setPhone(rs.getInt("phone"));
                employee.setTitle(rs.getString("title"));
                employee.setSalary(rs.getInt("salary"));


                var department = new Department();

                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("dep_name"));
                department.setAddress(rs.getString("address"));

                employee.setDepartments(Collections.singletonList(department));

                result.add(employee);
            }*/

    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }


        return result;
}

    public Employee findById(Integer id) {
        var employee = new Employee();

        var connection = DataSourceManager.getInstance().getConnection();

        try (var statement = connection.prepareStatement("select * from employee where id = ?")) {
            statement.setInt(1, id);

            var rs = statement.executeQuery();
            if (rs.next()) {

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setDob(rs.getInt("dob"));
                employee.setPhone(rs.getInt("phone"));
                employee.setTitle(rs.getString("title"));
                employee.setSalary(rs.getInt("salary"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
}
