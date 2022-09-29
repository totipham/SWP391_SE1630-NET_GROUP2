

package dal;

import dal.impl.PropertyImageDAOImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PropertyImage;

/**
 *
 * @author totipham
 */
class PropertyImageDAO extends DBContext implements PropertyImageDAOImpl{

    @Override
    public ArrayList<PropertyImage> getImagesByPID(int pid) {
        
        ArrayList<PropertyImage> list = new ArrayList<>();
        String sql = "SELECT * FROM [PropertyImage] WHERE property_id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                PropertyImage pImg = new PropertyImage();
                pImg.setPropertyId(pid);
                pImg.setFileName(rs.getString("filename"));
                
                list.add(pImg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }


}
