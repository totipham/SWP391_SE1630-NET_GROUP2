/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * Request
 * Record of change:
 *      DATE: Oct 7, 2022            
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
 * The class contains attribute of Request			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet	
 *
 * @author LANBTHHE160676 
 */
public class Request {
    int id;
    RequestStatus requestStatus;
    User renter;
    Property property;
    Date requestDate;

    public Request() {
    }

    public Request(int id, RequestStatus requestStatus, User renter, Property property, Date requestDate) {
        this.id = id;
        this.requestStatus = requestStatus;
        this.renter = renter;
        this.property = property;
        this.requestDate = requestDate;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

   

    @Override
    public String toString() {
        return "Request{" + "id=" + id + ", requestStatus=" + requestStatus + ", renter=" + renter + ", property=" + property + ", requestDate=" + requestDate + '}';
    }

    

    
    
}
