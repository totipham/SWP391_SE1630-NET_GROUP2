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
import dao.IPropertyDAO;
import dao.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import model.Property;
import model.User;

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
            close(connection, statement, null);
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
            close(connection, statement, null);
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
            close(connection, statement, null);
        }
    }

    /**
     *
     * @param feedbackId
     * @param feedback
     * @throws Exception
     */
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
            close(connection, statement, null);
        }
    }

    @Override
    public Feedback getFeedbackByFeedbackID(int feedbackId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendFeedback(int propertyId, int userId, String header, String comment, int star) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editFeedback(int feedbackId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public List<Feedback> getAllFeedback() throws SQLException, Exception {
        List<Feedback> list = new ArrayList<>();  
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        IUserDAO userDAO = new UserDAOImpl();
        //set sql string
        String sql = "SELECT * FROM Feedback";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            // get feedback list from 
            while (result.next()){  
                // set properties of feedback
                Feedback feedback = new Feedback();
                feedback.setId(result.getInt("id"));
                
                Property property = new Property();
                property.setId(result.getInt("property_id"));
                int propertyId = property.getId();
                property = propertyDAO.getPropertyById(propertyId);
                feedback.setPropertyId(property);
                
                User user = new User();
                user.setId(result.getInt("user_id"));
                user = userDAO.getUserById(user.getId());
                feedback.setUserId(user);
                
                feedback.setHeader(result.getString("header"));
                feedback.setComment(result.getString("comment"));
                feedback.setStar(result.getInt("star"));              
                
                list.add(feedback);
            }
            return list;
        } catch(SQLException e) {
            throw e;
        } finally {
            close(connection, statement, null);
        }        
    }
    
    
    
}
