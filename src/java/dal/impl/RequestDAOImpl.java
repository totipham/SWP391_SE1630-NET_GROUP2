/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * RequestDAOImpl
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.impl;

import dal.DBContext;
import dal.IPropertyDAO;
import dal.IRequestDAO;
import dal.IUserDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import model.Property;
import model.Request;
import model.User;

/**
 * Desciption:
 *
 * @author LANBTHHE160676
 */
public class RequestDAOImpl extends DBContext implements IRequestDAO {

    @Override
    public void insertRequest(int userID, int propertyID, Date requestDate) {
        String sql = "INSERT INTO Request (user_id ,property_id ,request_date, rstatus_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, userID);
            st.setInt(2, propertyID);
            st.setDate(3, requestDate);
            st.setInt(4, 1);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRequestByRID(int requestID) {
        String sql = "DELETE FROM Request where (request_id) = (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, requestID);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStatusByRID(int requestID, int newrstatus) {
        String sql = "UPDATE Request set rstatus_id = ? where request_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, newrstatus);
            st.setInt(2, requestID);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    IUserDAO userDAO = new UserDAOImpl();
    IPropertyDAO propertyDAO = new PropertyDAOImpl();
    @Override
    public Request getRequestByRID(int requestID) {
        String sql = "SELECT * FROM Request WHERE request_id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, requestID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Request request = new Request();
                request.setId(result.getInt("request_id"));
                User user = userDAO.getUserById(result.getInt("user_id"));
                request.setRenter(user);
                Property property = propertyDAO.getPropertyById(result.getInt("property_id"));
                request.setProperty(property);
                request.setRequestDate(result.getDate("request_date"));
                
                return request;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RequestDAOImpl rd = new RequestDAOImpl();
        //rd.updateStatusByRId(5, 3);
        //System.out.println(rd);

    }
}
