package dal.impl;

import dal.DBContext;
import dal.IUserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author totipham
 */
public class UserDAOImpl extends DBContext implements IUserDAO {

    /**
     *
     * @param username for username of user. It is <code>java.lang.String</code> object
     * @param password for password of user. It is <code>java.lang.String</code> object
     * @return <code>User</code> object
     * @throws Exception
     */
    @Override
    public User getUser(String username, String password) throws Exception {
        String sql = "SELECT * FROM [User] "
                + "WHERE username=? COLLATE sql_latin1_general_cp1_cs_as "
                + "AND password=? COLLATE sql_latin1_general_cp1_cs_as";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(ps, rs);
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
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
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
                return user;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(ps, null);
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE username=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setRole(rs.getInt("role"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(ps, rs);
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

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, email);
            st.setString(4, address);
            st.setInt(5, userid);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            connection.close();
        }
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public boolean isDuplicateUsername(String username) throws SQLException {
        String sql = "SELECT user_id FROM [User] WHERE username = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            connection.close();
        }

        return false;
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
        PreparedStatement ps = null;
        User u = getUser(username, password);
        String message = "Register successfully!";
        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, username);
            ps.setString(6, password);
            ps.setInt(7, 1);
            ps.setString(8, "avatar.jpg");
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(ps, null);
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
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, newpwd);
            ps.setInt(2, id);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(ps, null);
        }

        return ps.executeUpdate();
    }

    @Override
    public void updateAvatar(User user) throws SQLException {
        String sql = "UPDATE [User]\n"
                + " SET [avatar] = ?\n"
                + " WHERE user_id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getAvatar());
            ps.setInt(2, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(ps, null);
        }
    }
}
