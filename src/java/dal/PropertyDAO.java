package dal;

import dal.impl.PropertyDAOImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Property;

/**
 *
 * @author totipham
 */
public class PropertyDAO extends DBContext implements PropertyDAOImpl {

    @Override
    public List<Property> getAllProperties() {
        List<Property> list = new ArrayList<>();
        String sql = "SELECT * FROM [Property]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                PropertyImageDAO pImgDao = new PropertyImageDAO();
                PropertyTypeDAO pTypeDao = new PropertyTypeDAO();
                PropertyStatusDAO pStatusDao = new PropertyStatusDAO();
                PropertyUtilityDAO pUtilityDao = new PropertyUtilityDAO();
                UserDAO udb = new UserDAO();
                Property p = new Property();
                p.setId(rs.getInt("property_id"));
                p.setName(rs.getString("name"));
                p.setHost(udb.getUserById(rs.getInt("host_id")));
                p.setAddress(rs.getString("address"));
                p.setArea(rs.getDouble("area"));
                p.setPrice(rs.getDouble("price"));
                p.setTotal(rs.getInt("total"));
                p.setUtilities(pUtilityDao.getUtilitiesByPID(rs.getInt("property_id")));
                p.setCreatedDate(rs.getDate("created_date"));
                p.setStatus(pStatusDao.getStatusByID(rs.getInt("pstatus_id")));
                p.setType(pTypeDao.getTypeByID(rs.getInt("type_id")));
                p.setDescription(rs.getString("description"));
                p.setImages(pImgDao.getImagesByPID(rs.getInt("property_id")));
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public List<Property> getPropertiesByKeyword(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> getPropertiesByOwner(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> getPropertiesByType(int tid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> getPropertiesByFiter(String keyword, int lastestTime, int lowestPrice, double maxPrice, double minPrice, double area) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Property getPropertyById(int pid) {
        Property p = new Property();
        String sql = "SELECT * FROM [Property] WHERE property_id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                UserDAO udb = new UserDAO();
                PropertyImageDAO pImgDao = new PropertyImageDAO();
                PropertyTypeDAO pTypeDao = new PropertyTypeDAO();
                PropertyStatusDAO pStatusDao = new PropertyStatusDAO();
                PropertyUtilityDAO pUtilityDao = new PropertyUtilityDAO();
                p.setId(rs.getInt("property_id"));
                p.setName(rs.getString("name"));
                p.setHost(udb.getUserById(rs.getInt("host_id")));
                p.setAddress(rs.getString("address"));
                p.setArea(rs.getDouble("area"));
                p.setPrice(rs.getDouble("price"));
                p.setTotal(rs.getInt("total"));
                p.setUtilities(pUtilityDao.getUtilitiesByPID(rs.getInt("property_id")));
                p.setCreatedDate(rs.getDate("created_date"));
                p.setStatus(pStatusDao.getStatusByID(rs.getInt("pstatus_id")));
                p.setType(pTypeDao.getTypeByID(rs.getInt("type_id")));
                p.setDescription(rs.getString("description"));
                p.setImages(pImgDao.getImagesByPID(rs.getInt("property_id")));
                
                return p;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public void insertProperty(Property newProperty) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAvailableByPID(int pid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAvailableProperty(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberOfProperty(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberOfRentedProperty(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> getPropertyByPage(List<Property> list, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        PropertyDAO pd = new PropertyDAO();
        Property p = pd.getPropertyById(2);
        System.out.println(p);

    }
}
