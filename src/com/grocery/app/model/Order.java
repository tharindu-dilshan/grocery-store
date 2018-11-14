/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grocery.app.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tharindu
 */
public class Order implements Serializable{
    
    private String id;
    private String customerId;
    private Date date;

    public Order(String id, String customerId, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
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
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    

}
