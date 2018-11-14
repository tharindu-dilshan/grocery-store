/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.model;

import java.io.Serializable;

/**
 *
 * @author Tharindu  Encapsulation   public private
 */
public class Customer implements Serializable{
    private String id;
    private String name;
    private String address;
    private long telephone;

    public Customer(String id, String name, String address, long salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = salary;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephone
     */
    public long getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
    
    
    
}
