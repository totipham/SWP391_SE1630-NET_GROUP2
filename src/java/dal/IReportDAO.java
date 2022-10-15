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
package dal;

import java.sql.Date;

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
     * @param sendId
     * @param reportUserId
     * @param reportDate
     * @param header
     * @param content
     * @throws Exception
     */
    public void insertReportUser (int sendId, int reportUserId, Date reportDate, String header, String content) throws Exception;

    /**
     *
     * @param sendId
     * @param reportPropertyId
     * @param reportDate
     * @param header
     * @param content
     * @throws Exception
     */
    public void insertReportProperty (int sendId, int reportPropertyId, Date reportDate, String header, String content) throws Exception;
}
