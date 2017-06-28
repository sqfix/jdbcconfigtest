package com.dao;


import com.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



public class JdbcCustomerDAO implements CustomerDAO{
    private final String SAVE_CUSTOMER_QUERY = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?,?,?)";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Customer customer) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(SAVE_CUSTOMER_QUERY);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Customer findById(int id) {
        return null;
    }
}
