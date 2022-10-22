/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 4, 2022         1.0           DucPTMHE160517     First Implement
 */
package dal.impl;

import dal.DBContext;
import dal.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contract;
import model.User;

/**
 * The class contains method find update, delete, insert user information from
 * DB
 *
 * The method wil throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class UserDAOImpl extends DBContext implements IUserDAO {

    /**
     *
     * @param username for username of user. It is <code>java.lang.String</code>
     * object
     * @param password for password of user. It is <code>java.lang.String</code>
     * object
     * @return <code>User</code> object
     * @throws Exception
     */
    @Override
    public User getUser(String username, String password) throws Exception {
        String sql = "SELECT * FROM [User] "
                + "WHERE username=? COLLATE sql_latin1_general_cp1_cs_as "
                + "AND password=? COLLATE sql_latin1_general_cp1_cs_as";

        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = getConnection();
        try {

            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPhone(result.getString("phone"));
                user.setAvatar(result.getString("avatar"));
                user.setAddress(result.getString("address"));
                user.setRole(result.getInt("role"));
                user.setVerify(result.getBoolean("verify"));
                return user;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE user_id=?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setRole(result.getInt("role"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPhone(result.getString("phone"));
                user.setAvatar(result.getString("avatar"));
                user.setAddress(result.getString("address"));
                user.setVerify(result.getBoolean("verify"));
                return user;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, null);
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     * @throws java.sql.SQLException
     */
    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE username=?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setRole(result.getInt("role"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPhone(result.getString("phone"));
                user.setAvatar(result.getString("avatar"));
                user.setAddress(result.getString("address"));
                user.setVerify(result.getBoolean("verify"));
                return user;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     * @throws java.sql.SQLException
     */
    public User getUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE email=?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setRole(result.getInt("role"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPhone(result.getString("phone"));
                user.setAvatar(result.getString("avatar"));
                user.setAddress(result.getString("address"));
                user.setVerify(result.getBoolean("verify"));
                return user;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }
        return null;
    }

    /**
     *
     * @param userid
     * @param name
     * @param phone
     * @param email
     * @param address
     */
    @Override
    public void updateUser(int userid, String name, String phone, String email, String address) throws SQLException {
        String sql = "UPDATE [User] SET name=?, phone=?, email=?, address=? WHERE user_id=?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, address);
            statement.setInt(5, userid);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public String insertUser(String name, String phone, String email, String address, String username, String password) throws Exception {
        String sql = "INSERT INTO [User] (name, phone, email, address, username, password, role, avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        String message = "Register successfully!";
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, address);
            statement.setString(5, username);
            statement.setString(6, password);
            statement.setInt(7, 1);
            statement.setString(8, "avatar.jpg");
            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }

        return message;
    }

    /**
     *
     * @param id
     * @param newpwd
     * @return
     */
    @Override
    public int updateNewPassword(int id, String newpwd) throws SQLException {
        String sql = "UPDATE [User]\n"
                + "SET password = ?\n"
                + "WHERE user_id = ?";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, newpwd);
            statement.setInt(2, id);
            
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param user
     * @throws SQLException
     */
    @Override
    public void updateAvatar(User user) throws SQLException {
        String sql = "UPDATE [User]\n"
                + " SET [avatar] = ?\n"
                + " WHERE user_id = ?";
        PreparedStatement statement = null;
        Connection connection = getConnection();

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getAvatar());
            statement.setInt(2, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void removeUserByID(int id) throws Exception {
        String strDelete = "DELETE FROM [dbo].[User]\n"
                + "      WHERE user_id=?";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public List<User> getAllUserSystem() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [User]";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setRole(result.getInt("role"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPhone(result.getString("phone"));
                user.setAvatar(result.getString("avatar"));
                user.setAddress(result.getString("address"));
                user.setVerify(result.getBoolean("verify"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public void updateVerifyByID(int id, boolean verify) throws Exception {
        String sql = "UPDATE User SET verify = ? WHERE user_id = ?";
        PreparedStatement statement = null;
        Connection connection = getConnection();

        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, verify);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param userid
     * @param role
     * @throws Exception
     */
    @Override
    public void updateRoleByID(int userid, int role) throws Exception {
        String sql = "UPDATE [User] SET role=? WHERE user_id=?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try {
            statement.setInt(1, role);
            statement.setInt(2, userid);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public List<Contract> getAllContract() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
        
