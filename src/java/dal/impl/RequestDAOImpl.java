/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 6, 2022         1.0           LanBTHHE160676     First Implement
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Property;
import model.Request;
import model.User;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class RequestDAOImpl extends DBContext implements IRequestDAO {

    /**
     *
     * @param userID
     * @param propertyID
     * @param requestDate
     * @throws SQLException
     */
    @Override
    public void insertRequest(int userID, int propertyID, Date requestDate) throws Exception {
        String sql = "INSERT INTO Request (user_id ,property_id ,request_date, rstatus_id) VALUES (?, ?, ?, ?)";
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, userID);
            st.setInt(2, propertyID);
            st.setDate(3, requestDate);
            st.setInt(4, 1);
            st.executeUpdate();

        } catch (Exception e) {
           throw e;
        }finally {
            closeConnection(st,null);
        }
    }

    /**
     *
     * @param requestID
     * @throws SQLException
     */
    @Override
    public void deleteRequestByRID(int requestID) throws Exception {
        String sql = "DELETE FROM Request where (request_id) = (?)";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, requestID);

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }finally {
            closeConnection(st,null);
        }
    }

    /**
     *
     * @param requestID
     * @param newrstatus
     * @throws SQLException
     */
    @Override
    public void updateStatusByRID(int requestID, int newrstatus) throws Exception {
        String sql = "UPDATE Request set rstatus_id = ? where request_id = ?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, newrstatus);
            st.setInt(2, requestID);

            st.executeUpdate();

        } catch (Exception e) {
           throw e;
        }finally {
            closeConnection(st,null);
        }
    }

    /**
     *
     * @param requestID
     * @return
     * @throws Exception
     */
    @Override
    public Request getRequestByRID(int requestID) throws Exception {
        String sql = "SELECT * FROM Request WHERE request_id=?";
        PreparedStatement statement = null;
        ResultSet result = null;
        IUserDAO userDAO = new UserDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, requestID);
            result = statement.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(statement, result);
        }
        return null;
    }

    public static void main(String[] args) {
        RequestDAOImpl rd = new RequestDAOImpl();
        //rd.getRequestByRID(7);
        //System.out.println(rd);

    }
}
