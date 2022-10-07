/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * Request
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;

/**
 * Desciption:
 *
 * @author LANBTHHE160676 
 */
public class Request {
    int request_id;
    int property_id;
    int rstatus_id;
    int user_id;
    Date request_date;

    public Request() {
    }

    public Request(int request_id, int property_id, int rstatus_id, int user_id, Date request_date) {
        this.request_id = request_id;
        this.property_id = property_id;
        this.rstatus_id = rstatus_id;
        this.user_id = user_id;
        this.request_date = request_date;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getRstatus_id() {
        return rstatus_id;
    }

    public void setRstatus_id(int rstatus_id) {
        this.rstatus_id = rstatus_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    @Override
    public String toString() {
        return "Request{" + "request_id=" + request_id + ", property_id=" + property_id + ", rstatus_id=" + rstatus_id + ", user_id=" + user_id + ", request_date=" + request_date + '}';
    }
    
    
}
