package dal;

import model.User;

/**
 *
 * @author totipham
 */
public interface IUserDAO {

    public User getUser(String username, String password);

    public User getUserById(int id);

    public void updateUser(int userid, String name, String phone, String email, String address);

    public boolean isDuplicateUsername(String username);

    public String insertUser(String name, String phone, String email, String address, String username, String password);

    public int updateNewPassword(int id, String newpwd);

    public void updateAvatar(User user);
}
