

package dal;

import dal.impl.PropertyTypeDAOImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PropertyType;

/**
 *
 * @author totipham
 */
class PropertyTypeDAO extends DBContext implements PropertyTypeDAOImpl {

    PropertyType getTypeByID(int id) {
       String sql = "SELECT * FROM [PropertyType] WHERE type_id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                PropertyType t = new PropertyType();
                t.setId(rs.getInt("type_id"));
                t.setType(rs.getString("ptype"));

                return t;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
