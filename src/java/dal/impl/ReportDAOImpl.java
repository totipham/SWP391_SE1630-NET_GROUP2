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

package dal.impl;

import dal.DBContext;
import dal.IReportDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Report;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ReportDAOImpl extends DBContext implements IReportDAO{

    @Override
    public void insertReport(int reportTypeID, int senderId, String target, int targetID,Date reportTime, String header, String content) throws SQLException {
         String sql = "INSERT INTO Report (rtype_id, sender_id, target, target_id, time, header, content) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, reportTypeID);
            statement.setInt(2, senderId);
            statement.setString(3,target);
            statement.setInt(4,targetID );
            statement.setDate(5, reportTime);
            statement.setString(6, header);
            statement.setString(7, content);
            statement.executeUpdate();

            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, null);
        }

     
    }

    
}
