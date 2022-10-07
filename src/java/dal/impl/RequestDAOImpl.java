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
import dal.IRequestDAO;
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
    public void insertRequest(int user_id, int property_id, Date requestDate) {
        String sql = "INSERT INTO Request (user_id ,property_id ,request_date, rstatus_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, user_id);
            st.setInt(2, property_id);
            st.setDate(3, requestDate);
            st.setInt(4, 1);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRequestByUid(int user_id) {
        String sql = "DELETE FROM Request where (user_id) = (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, user_id);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStatusByRId(int request_id, int newrstatus) {
        String sql = "UPDATE Request set rstatus_id = ? where request_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, newrstatus);
            st.setInt(2, request_id);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Request getRequestByUid(int user_id) {
        String sql = "SELECT * FROM Request WHERE user_id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Request request = new Request();
                request.setRequest_id(result.getInt("request_id"));
                request.setProperty_id(result.getInt("property_id"));
                request.setRstatus_id(result.getInt("rstatus_id"));
                request.setUser_id(result.getInt("user_id"));
                request.setRequest_date(result.getDate("request_date"));

                return request;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RequestDAOImpl rd = new RequestDAOImpl();
        rd.updateStatusByRId(5, 3);
        //System.out.println(rd);

    }
}
