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

package dao.impl;

import dao.DBContext;
import dao.IReportDAO;
import dao.IUserDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Report;

/**				
 * The class contains method find update, delete, insert user information from
 * DB
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ReportDAOImpl extends DBContext implements IReportDAO{

    @Override
    public void insertReport(int reportTypeId, int currentUserId,  int targetId, String target, Date reportDate, String header, String content) throws SQLException{
        String sql = "INSERT INTO Report (rtype_id, sender_id, target_id, target, time, header, content) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, reportTypeId);
            statement.setInt(2, currentUserId);
            statement.setInt(3, targetId);
            statement.setString(4, target);
            statement.setDate(5, reportDate);
            statement.setString(6, header);
            statement.setString(7, content);
            statement.executeUpdate();

        } catch (SQLException e) {
           throw e;
        }finally {
            close(connection, statement, null);
        }
    }

    /**
     *
     * @param senderId
     * @param target
     * @param targetId
     * @return
     * @throws Exception
     */
    @Override
    public boolean isReported(int senderId, String target, int targetId) throws Exception {
        String sql = "SELECT * FROM Report WHERE sender_id = ? and target = ? and target_id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, senderId);
            statement.setString(2, target);
            statement.setInt(3, targetId);

            result = statement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            close(connection, statement, result);
        }

        return false;
    }
    /*public static void main(String []args) {
        try{
            ReportDAOImpl r = new ReportDAOImpl();
        boolean t = r.isReported(6, "user", 10);
            System.out.println(t);
        } catch(Exception ex){
            System.out.println(ex);
        }
        
  }*/

    @Override
    public List<Report> getAllReports() throws Exception{
        List<Report> list = new ArrayList<>();
        String sql = "SELECT * FROM Report";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            IUserDAO userDAO = new UserDAOImpl();
            while (result.next()) {
                Report report = new Report();
                report.setId(result.getInt("report_id"));
                System.out.println(report.getId());
                report.setReportType(result.getInt("rtype_id"));
                report.setSender(userDAO.getUserById(result.getInt("sender_id")));
                report.setTargetId(result.getInt("target_id"));
                report.setTarget(result.getString("target"));
                report.setTime(result.getDate("time").toString());
                report.setHeader(result.getString("header"));
                report.setContent(result.getString("content"));
                list.add(report);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, statement, result);
        }
        
        return list;
    }
}
