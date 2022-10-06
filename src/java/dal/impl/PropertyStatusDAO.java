package dal.impl;

import dal.DBContext;
import dal.IPropertyStatusDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PropertyStatus;

/**
 *
 * @author totipham
 */
class PropertyStatusDAO extends DBContext implements IPropertyStatusDAO {

    PropertyStatus getStatusByID(int id) {
        String sql = "SELECT * FROM [PropertyStatus] WHERE pstatus_id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                PropertyStatus ps = new PropertyStatus();
                ps.setId(id);
                ps.setStatus(rs.getString("pstatus"));

                return ps;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
