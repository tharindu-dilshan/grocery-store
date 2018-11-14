/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tharindu
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection conn;
    private DBConnection()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/grocery_store", "root", "");
    }
    public static DBConnection getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return conn;
    }
}
