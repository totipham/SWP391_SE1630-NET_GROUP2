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

    @Override
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM [User] WHERE username=? COLLATE sql_latin1_general_cp1_cs_as AND password=? COLLATE sql_latin1_general_cp1_cs_as";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
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
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM [User] WHERE user_id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
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
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM [User] WHERE username=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
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
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(int userid, String name, String phone, String email, String address) {
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isDuplicateUsername(String username) {
        String sql = "SELECT user_id FROM [User] WHERE username = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String insertUser(String name, String phone, String email, String address, String username, String password) {
        String sql = "INSERT INTO [User] (name, phone, email, address, username, password, role, avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        User u = getUser(username, password);

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, email);
            st.setString(4, address);
            st.setString(5, username);
            st.setString(6, password);
            st.setInt(7, 1);
            st.setString(8, "avatar.jpg");
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return "Register successfully!";
    }

    @Override
    public int updateNewPassword(int id, String newpwd) {
        String sql = "UPDATE [User]\n"
                + "SET password = ?\n"
                + "WHERE user_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpwd);
            st.setInt(2, id);

            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public void updateAvatar(User user) {
        String sql = "UPDATE [User]\n"
                + " SET [avatar] = ?\n"
                + " WHERE user_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getAvatar());
            st.setInt(2, user.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
