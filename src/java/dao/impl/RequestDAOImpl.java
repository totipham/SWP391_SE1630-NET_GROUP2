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
package dao.impl;

import dao.DBContext;
import dao.IPropertyDAO;
import dao.IRequestDAO;
import dao.IRequestStatusDAO;
import dao.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Property;
import model.Request;
import model.RequestStatus;
import model.User;

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
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, userID);
            statement.setInt(2, propertyID);
            statement.setDate(3, requestDate);
            statement.setInt(4, 1);
            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, statement, null);
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
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, requestID);

            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, statement, null);
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
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, newrstatus);
            statement.setInt(2, requestID);

            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, statement, null);
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
        Connection connection = getConnection();
        IUserDAO userDAO = new UserDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        IRequestStatusDAO requestStatusDAO = new RequestStatusDAOImpl();
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
                RequestStatus requestStatus = requestStatusDAO.getRequestStatusByStatusId(result.getInt("rstatus_id"));
                request.setRequestStatus(requestStatus);
                return request;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, statement, result);
        }
        return null;
    }

    /**
     *
     * @param hostId
     * @return
     * @throws Exception
     */
    @Override
    public List<Request> getRequestByHostId(int hostId) throws Exception {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM Request r INNER JOIN Property p ON p.property_id = r.property_id WHERE p.host_id=?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = getConnection();
        IUserDAO userDAO = new UserDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, hostId);
            result = statement.executeQuery();
            while (result.next()) {
                Request request = new Request();
                request.setId(result.getInt("request_id"));
                User user = userDAO.getUserById(result.getInt("user_id"));
                request.setRenter(user);
                Property property = propertyDAO.getPropertyById(result.getInt("property_id"));
                request.setProperty(property);
                request.setRequestDate(result.getDate("request_date"));
                list.add(request);

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, statement, result);
        }
        return list;
    }

    /**
     *
     * @param hostId
     * @param begin
     * @param end
     * @return
     * @throws Exception
     */
    @Override
    public Map<Date, Integer> getNumberRequestByRange(int hostId, Date begin, Date end) throws Exception {
        Map<Date, Integer> map = new TreeMap<>();
        String sql = "SELECT request_date, COUNT(*) as number FROM Request r "
                + "INNER JOIN Property p "
                + "ON r.property_id = p.property_id "
                + "WHERE p.host_id = ? "
                + "GROUP BY request_date "
                + "HAVING request_date BETWEEN ? AND ? ";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, hostId);
            statement.setString(2, begin.toString());
            statement.setString(3, end.toString());

            result = statement.executeQuery();

            while (result.next()) {
                
                map.put(result.getDate("request_date"), result.getInt("number"));
            }

            return map;
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, statement, result);
        }

    }

//    public static void main(String args[]) {
//        try {
//            RequestDAOImpl r = new RequestDAOImpl();
//
//            Date begin = Date.valueOf("2022-10-12");
//            Date end = Date.valueOf("2022-10-24");
//
//            Map<Date, Integer> map = r.getNumberRequestByRange(2, begin, end);
//            Set<Date> set = map.keySet();
//            for (Date key : set) {
//                System.out.println(key + " " + map.get(key));
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//    }

    @Override
    public Request getRequestByPropertyIdandUserId(int propertyId, int userId) throws Exception {
        String sql = "SELECT * FROM Request WHERE property_id=? and user_id=?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = getConnection();
        IUserDAO userDAO = new UserDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        IRequestStatusDAO requestStatusDAO = new RequestStatusDAOImpl();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, propertyId);
            statement.setInt(1, userId);
            result = statement.executeQuery();
            while (result.next()) {
                Request request = new Request();
                request.setId(result.getInt("request_id"));
                User user = userDAO.getUserById(result.getInt("user_id"));
                request.setRenter(user);
                Property property = propertyDAO.getPropertyById(result.getInt("property_id"));
                request.setProperty(property);
                request.setRequestDate(result.getDate("request_date"));
                RequestStatus requestStatus = requestStatusDAO.getRequestStatusByStatusId(result.getInt("rstatus_id"));
                request.setRequestStatus(requestStatus);
                return request;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, statement, result);
        }
        return null;
    }

}
