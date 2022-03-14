/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemo.dao;

import com.springdemo.entity.Customer;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface CustomerDAO {
    
    public List<Customer> getCustomers();
    
    public void  saveCustomer(Customer theCustomer);

    public Customer updateCustomer(int theId);

    public void deleteCustomer(int theId);
    
}
