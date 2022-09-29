package dal.impl;

import java.util.List;
import model.Property;
import model.PropertyImage;
import model.PropertyType;
import model.PropertyUtility;

/**
 *
 * @author totipham
 */
public interface PropertyDAOImpl {

    public List<Property> getAllProperties();

    public List<Property> getPropertiesByKeyword(String keyword);

    public List<Property> getPropertiesByOwner(int uid);

    public List<Property> getPropertiesByType(int tid);

    public List<Property> getPropertiesByFiter(String keyword, int lastestTime,
            int lowestPrice, double maxPrice, double minPrice, double area);

    public Property getPropertyById(int pid);

    public void insertProperty(Property newProperty);

    public int getAvailableByPID(int pid);

    public int getAvailableProperty(int uid);

    public int getNumberOfProperty(int uid);

    public int getNumberOfRentedProperty(int uid);

    public List<Property> getPropertyByPage(List<Property> list, int start, int end);
}
