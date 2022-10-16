package dal;

import java.util.List;
import model.Property;


/**
 *
 * @author totipham
 */
public interface IPropertyDAO {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Property> getAllProperties() throws Exception;

    public List<Property> getPropertiesByKeyword(String keyword) throws Exception;

    public List<Property> getPropertiesByOwner(int uid) throws Exception;

    public List<Property> getPropertiesByType(int tid) throws Exception;

    public List<Property> getPropertiesByFiter(String keyword, int lastestTime,
            int lowestPrice, double maxPrice, double minPrice, double area) throws Exception;

    public Property getPropertyById(int pid) throws Exception;

    /**
     *
     * @param newProperty
     * @throws Exception
     */
    public int insertProperty(Property newProperty) throws Exception;

    public int getAvailableByPID(int pid) throws Exception;

    public int getAvailableProperty(int uid) throws Exception;

    public int getNumberOfProperty(int uid) throws Exception;

    public int getNumberOfRentedProperty(int uid) throws Exception;

    public List<Property> getPropertyByPage(List<Property> list, int start, int end) throws Exception;

    public List<Property> getPropertyByHostId(int id) throws Exception;
}
