

package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author totipham
 */
public class UserDAO extends DBContext {

    public User getUser(String username, String password) {
        String sql = "SELECT * FROM [User] WHERE username=? AND password=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                    user.setId(result.getInt("user_id"));
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

    public User getUserById(int id) {
        String sql = "SELECT * FROM [User] WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("user_id"));
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

    public void updateUser(int userid, String name, String phone, String email, String address, String avatar) {
        String sql = "UPDATE [User] SET name=?, phone=?, email=?, address=?, avatar=? WHERE user_id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, email);
            st.setString(4, address);
            st.setString(5, avatar);
            st.setInt(6, userid);

            System.out.println(userid + "|" + name);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public String insertUser(String name, String phone, String email, String address, String username, String password) {
        String sql = "INSERT INTO [User] (name, phone, email, address, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        User u = getUser(username, password);

        if (isDuplicateUsername(username)) {
            return "Username " + username + " is existed!";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, email);
            st.setString(4, address);
            st.setString(5, username);
            st.setString(6, password);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return "Register successfully!";
    }

    public void updateNewPassword(int id, String newpwd) {
        String sql = "UPDATE [User]\n"
                + "SET password = ?\n"
                + "WHERE user_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpwd);
            st.setInt(2, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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


