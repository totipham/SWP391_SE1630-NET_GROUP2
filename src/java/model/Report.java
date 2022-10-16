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
 *				
 * @author LanBTHHE160676				
 */
public class Report {
    private int id;
    private ReportType reportType;
    private User sender;
    private String target;
    private int targetId;
    private Date date;
    private String header;
    private String content;

    public Report() {
    }

    public Report(int id, ReportType reportType, User sender, String target, int targetId, Date date, String header, String content) {
        this.id = id;
        this.reportType = reportType;
        this.sender = sender;
        this.target = target;
        this.targetId = targetId;
        this.date = date;
        this.header = header;
        this.content = content;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", reportType=" + reportType + ", sender=" + sender + ", target=" + target + ", targetId=" + targetId + ", date=" + date + ", header=" + header + ", content=" + content + '}';
    }
    
            
    
}
