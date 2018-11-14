/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.controller.impl;

import com.grocery.app.controller.CustomerController;
import com.grocery.app.db.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tharindu Inheritence & polymopism
 */
public class CustomerControllerImpl implements CustomerController {
    private static ResultSet rst;
    
    public CustomerControllerImpl(){
    }
    
    @Override
    public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("Insert into Customer values(?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getTelephone());
        return stm.executeUpdate()>0;
    }
    
    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("Delete from Customer where CustID=?");
        stm.setObject(1, id);
        return stm.executeUpdate()>0;
    }
    
    @Override
    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("Update Customer set CustName=?, CustAddress=?, Telephone=? where CustID=?");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getTelephone());
        stm.setObject(4, customer.getId());
        return stm.executeUpdate()>0;
    }
    
    @Override
    public Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("Select * from Customer where CustID=?");
        stm.setObject(1, id);
        rst = stm.executeQuery();
        if(rst.next()){
            return new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getLong(4));
        }else{
            return null;
        }
    }
    
    @Override
    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        rst = stm.executeQuery("Select * from Customer");
        ArrayList<Customer> custList=new ArrayList<>();
        while(rst.next()){
            custList.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getLong(4)));
        }
        return custList;
    }
}
