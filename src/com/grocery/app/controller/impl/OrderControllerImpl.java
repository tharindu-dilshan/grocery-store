/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.controller.impl;

import com.grocery.app.controller.OrderController;
import com.grocery.app.db.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tharindu
 */
public class OrderControllerImpl implements OrderController{
    private static ResultSet rst;
    
    public OrderControllerImpl(){}
    
    @Override
    public boolean addOrder(Order order) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("insert into Orders values(?, ?, ?)");
        stm.setObject(1, order.getId());
        stm.setObject(2, order.getCustomerId());
        stm.setObject(3, order.getDate());
        return stm.executeUpdate() > 0;
    }
    
    @Override
    public Order searchOrder(String oid) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        rst = stm.executeQuery("select * from Orders where OID='" + oid + "'");
        if (rst.next()) {
            return new Order(rst.getString(1), rst.getString(2), rst.getDate(3));
        }
        return null;
    }
    
    @Override
    public boolean deleteOrder(String oid) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate("delete from Orders where OID='" + oid + "'") > 0;
    }
    
    @Override
    public ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        rst = conn.createStatement().executeQuery("select * from Orders");
        ArrayList<Order> orderList = new ArrayList();
        while (rst.next()) {
            orderList.add(new Order(rst.getString(1), rst.getString(2), rst.getDate(3)));
        }
        return orderList;
    }
    
    @Override
    public boolean updateOrder(Order order) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Orders set CustID=?,Date=? where OID=?");
        stm.setObject(1, order.getCustomerId());
        stm.setObject(2, order.getDate());
        stm.setObject(3, order.getId());
        return stm.executeUpdate() > 0;
    }
}
