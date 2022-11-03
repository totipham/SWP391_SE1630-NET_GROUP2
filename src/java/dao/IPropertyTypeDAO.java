/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 13, 2022       1.0           LanBTHHE160676     First Implement
*/
package dao;

import java.sql.SQLException;
import java.util.List;
import model.PropertyType;


/**				
 * The class contains method find update, delete, insert property type						
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676		
 */
public interface IPropertyTypeDAO {

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public PropertyType getTypeByID(int id) throws SQLException;

    /**
     *
     * @param newPropertyType
     * @throws SQLException
     */
    public void insertPropertyType(String newPropertyType) throws SQLException;

    /**
     *
     * @return
     * @throws Exception
     */
    public List<PropertyType> getAllPropertyType() throws Exception;
}
