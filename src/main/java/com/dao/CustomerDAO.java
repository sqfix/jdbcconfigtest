package com.dao;


import com.model.Customer;

public interface CustomerDAO {

    void save(Customer customer);

    Customer findById(int id);
}
