package com.employees.restapi.repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.employees.restapi.models.Employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("employeesRepositoryPgSql")
public class EmployeesRepositoryPgSql implements IEmployeesRepository {

    @Value("${postgresql.connectionString}")
    private String connectionString;

    @Value("${postgresql.user}")
    private String user;

    @Value("${postgresql.password}")
    private String password;

    @Override
    public Collection<Employee> listAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Collection<Employee> result = new ArrayList<Employee>();

            conn = getConnection();
            stmt = conn.prepareStatement("select id, name, salary, age, profile_image from employees order by name");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = GetEmployee(rs);
                result.add(employee);
            }
            rs.close();
            stmt.close();

            return result;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return null;
    }

    @Override
    public Employee getById(long id) {
        Connection conn = null;
        Employee result = null;

        try {
            conn = getConnection();
            return getById(id, conn);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return result;
    }

    private Employee getById(long id, Connection conn) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Employee result = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select id, name, salary, age, profile_image from employees where id=?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                result = GetEmployee(rs);
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Employee add(Employee employee) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Employee result = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(
                    "insert into employees (name, salary, age, profile_image) values (?, ?, ?, ?) RETURNING id");
            stmt.setString(1, employee.getName());
            stmt.setBigDecimal(2, employee.getSalary());
            stmt.setObject(3, employee.getAge());
            stmt.setString(4, employee.getProfileImage());
            rs = stmt.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("id");
                employee.setId(id);
                result = employee;
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return result;
    }

    @Override
    public Employee update(Employee employee) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Employee result = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("update employees set name=?, salary=?, age=?, profile_image=? where id=?");
            stmt.setString(1, employee.getName());
            stmt.setBigDecimal(2, employee.getSalary());
            stmt.setObject(3, employee.getAge());
            stmt.setString(4, employee.getProfileImage());
            stmt.setLong(5, employee.getId());
            int qtdeResult = stmt.executeUpdate();

            if (qtdeResult > 0) {
                result = employee;
            }

            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return result;
    }

    @Override
    public Employee deleteById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Employee result = null;

        try {
            conn = getConnection();

            Employee employee = getById(id, conn);
            if (employee == null)
                return null;

            stmt = conn.prepareStatement("delete from employees where id=?");
            stmt.setLong(1, id);
            int qtdeResult = stmt.executeUpdate();

            if (qtdeResult > 0) {
                result = employee;
            }

            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return result;
    }

    private Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(connectionString, user, password);
        return conn;
    }

    private Employee GetEmployee(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        BigDecimal salary = (BigDecimal) rs.getObject("salary");
        Integer age = (Integer) rs.getObject("age");
        String profileImage = rs.getString("profile_image");
        Employee employee = new Employee(id, name, salary, age, profileImage);
        return employee;
    }

}