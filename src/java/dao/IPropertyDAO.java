/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 10, 2022         1.0           ThuongTTHE163555     First Implement
 */
package dao;

import java.util.List;
import java.util.Map;
import model.Property;

/**				
 * The class contains method find update, delete, insert property from DB			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author ThuongTTHE163555				
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
     * @return 
     * @throws Exception
     */
    public int insertProperty(Property newProperty) throws Exception;

    /**
     *
     * @param pid
     * @return
     * @throws Exception
     */
    public int getAvailableByPID(int pid) throws Exception;

    /**
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public int getAvailableProperty(int uid) throws Exception;

    /**
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public int getNumberOfProperty(int uid) throws Exception;

    /**
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public int getNumberOfRentedProperty(int uid) throws Exception;

    /**
     *
     * @param list
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public List<Property> getPropertyByPage(List<Property> list, int start, int end) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<Property> getPropertyByHostId(int id) throws Exception;
    
    /**
     *
     * @param id
     * @throws Exception
     */
    public void deletePropertyByID(int id) throws Exception;
    
    /**
     *
     * @param hostId
     * @return
     * @throws Exception
     */
    public Map<Property, Integer> getTrendingRentProperty(int hostId) throws Exception;
    
    
    public void updateProperty(Property property) throws Exception;

  
}
