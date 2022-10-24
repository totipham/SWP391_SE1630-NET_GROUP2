/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 16, 2022         1.0           NgocCMHE161386     First Implement
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.DBContext;
import dao.IFeedbackDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;

/**
 * The class contains method find update, delete, insert staff information from
 *
 * The method wil throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author NgocCMHE161386
 */
public class FeedbackDAOImpl extends DBContext implements IFeedbackDAO {

    /**
     *
     * @param pid
     * @return
     * @throws Exception
     */
    @Override
    public List<Feedback> getFeedbackByPropertyId(int pid) throws Exception {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM [Feedback] WHERE property_id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pid);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PropertyDAOImpl pDao = new PropertyDAOImpl();
                UserDAOImpl uDao = new UserDAOImpl();
                Feedback feedback = new Feedback();
                feedback.setId(result.getInt("feedback_id"));
                feedback.setPropertyId(pDao.getPropertyById(result.getInt("property_id")));
                feedback.setUserId(uDao.getUserById((result.getInt("user_id"))));
                feedback.setHeader(result.getString("header"));
                feedback.setComment(result.getString("comment"));
                feedback.setStar(result.getInt("star"));
                list.add(feedback);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
        return list;
    }

    /**
     *
     * @param pid
     * @param uid
     * @return 
     * @throws Exception
     */
    @Override
    public Feedback sendFeedback(int pid, int uid) throws Exception {
        String sql = "INSERT INTO [Feedback](property_id, user_id, header, comment, star) "
                + "VALUES (?, ?, ?, ?, ?)";   
        Feedback newFeedback = new Feedback();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pid);
            statement.setInt(2, uid);
            statement.setString(3, newFeedback.getHeader());
            statement.setString(4, newFeedback.getComment());
            statement.setInt(5, newFeedback.getStar());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
        return null;
    }

    /**
     *
     * @param feedbackId
     * @param feedback
     * @throws Exception
     */
    @Override
    public void deleteFeedback(int feedbackId) throws Exception {
        String sql = "DELETE FROM [Feedback] WHERE feedback_id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
           statement.setInt(1, feedbackId);
           statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param feedbackId
     * @param feedback
     * @throws Exception
     */
    @Override
    public void editFedback(Feedback feedback) throws Exception {
        String sql = "UPDATE [Feedback] SET header = ? ,comment =? ,star = ? WHERE feedback_id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement.setString(1, feedback.getHeader());
            statement.setString(2, feedback.getComment());
            statement.setInt(3, feedback.getStar());
            statement.setInt(4, feedback.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }
}
