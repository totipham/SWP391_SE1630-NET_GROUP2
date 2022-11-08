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
package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.Report;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public interface IReportDAO {

    /**
     *
     * @param reportTypeId
     * @param currentUserId
     * @param targetId
     * @param target
     * @param reportDate
     * @param header
     * @param content
     * @throws SQLException
     */
    public void insertReport(int reportTypeId, int currentUserId,  int targetId, String target, Date reportDate, String header, String content) throws SQLException;

    /**
     *
     * @param senderId
     * @param target
     * @param targetId
     * @return
     * @throws Exception
     */
    public boolean isReported (int senderId, String target, int targetId) throws Exception;

    public List<Report> getAllReports() throws Exception;
}
