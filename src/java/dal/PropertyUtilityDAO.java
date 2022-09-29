

package dal;

import dal.impl.PropertyUtilityDAOImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PropertyUtility;

/**
 *
 * @author totipham
 */
class PropertyUtilityDAO extends DBContext implements PropertyUtilityDAOImpl {

    List<PropertyUtility> getUtilitiesByPID(int pid) {
        List<PropertyUtility> list = new ArrayList<>();
        String sql = "SELECT * FROM [Utility] WHERE property_id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                PropertyUtility pu = new PropertyUtility();
                pu.setId(rs.getInt("utility_id"));
                pu.setName(rs.getString("name"));
                pu.setPrice(rs.getDouble("price"));
                pu.setPid(rs.getInt("property_id"));
                list.add(pu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

}
