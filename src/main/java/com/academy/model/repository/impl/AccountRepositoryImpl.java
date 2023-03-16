package com.academy.model.repository.impl;

import com.academy.model.DataSourceManager;
import com.academy.model.entity.Account;
import com.academy.model.entity.Employee;
import com.academy.model.repository.AccountRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public void create(Account account) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public List<Account> findAll() {
        var result = new ArrayList<Account>();

        var connection = DataSourceManager.getInstance().getConnection();

        try(var statement = connection.prepareStatement("select account.id  as account_id, summ, name, surname, dob, phone,  title, salary, employee.id as employee_id from academy.account join academy.employee on academy.account.employee_id = employee.id")) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                var account = new Account();

                account.setId(rs.getInt("account_id"));
                account.setSumm(rs.getInt("summ"));

                var employee = new Employee();

                employee.setId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setDob(rs.getInt("dob"));
                employee.setPhone(rs.getInt("phone"));
                employee.setTitle(rs.getString("title"));
                employee.setSalary(rs.getInt("salary"));

                result.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public Account findById(Integer id) {
        return null;
    }
}
