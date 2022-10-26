/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 15, 2022         1.0           LanBTHHE160676     First Implement
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;

/**				
 * The class contains attribute of Report			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class Report {
    private int id;
    private User sender;
    private User reportedUser;
    private Property reportedProperty;
    private Date reportedDate;
    private String header;
    private String time;

    public Report() {
    }

    public Report(int id, User sender, User reportedUser, Property reportedProperty, Date reportedDate, String header, String time) {
        this.id = id;
        this.sender = sender;
        this.reportedUser = reportedUser;
        this.reportedProperty = reportedProperty;
        this.reportedDate = reportedDate;
        this.header = header;
        this.time = time;
    }

    public Report(int id, User sender, Property reportedProperty, Date reportedDate, String header, String time) {
        this.id = id;
        this.sender = sender;
        this.reportedProperty = reportedProperty;
        this.reportedDate = reportedDate;
        this.header = header;
        this.time = time;
    }

    public Report(int id, User sender, User reportedUser, Date reportedDate, String header, String time) {
        this.id = id;
        this.sender = sender;
        this.reportedUser = reportedUser;
        this.reportedDate = reportedDate;
        this.header = header;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(User reportedUser) {
        this.reportedUser = reportedUser;
    }

    public Property getReportedProperty() {
        return reportedProperty;
    }

    public void setReportedProperty(Property reportedProperty) {
        this.reportedProperty = reportedProperty;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", sender=" + sender + ", reportedUser=" + reportedUser + ", reportedProperty=" + reportedProperty + ", reportedDate=" + reportedDate + ", header=" + header + ", time=" + time + '}';
    }

   
    
            
    
}
