package dal;

import java.util.List;
import model.User;

/**
 *
 * @author totipham
 */
public interface IUserDAO {

    /**
     *
     * @param username for username of user. It is <code>java.lang.String</code> object
     * @param password for password of user. It is <code>java.lang.String</code> object
     * @return <code>User</code> object
     * @throws Exception
     */
    public User getUser(String username, String password) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User getUserById(int id) throws Exception;

    /**
     *
     * @param userid
     * @param name
     * @param phone
     * @param email
     * @param address
     * @throws Exception
     */
    public void updateUser(int userid, String name, String phone, String email, String address) throws Exception;

    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    public boolean isDuplicateUsername(String username) throws Exception;

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
    public String insertUser(String name, String phone, String email, String address, String username, String password) throws Exception;

    /**
     *
     * @param id
     * @param newpwd
     * @return
     * @throws Exception
     */
    public int updateNewPassword(int id, String newpwd) throws Exception;

    /**
     *
     * @param user
     * @throws Exception
     */
    public void updateAvatar(User user) throws Exception;
    
    /**
     *    
     * @return
     * @throws Exception
     */
    public List<User> getAllUserSystem() throws Exception;
}
