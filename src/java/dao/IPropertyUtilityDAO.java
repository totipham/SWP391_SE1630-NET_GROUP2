/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Sep 28, 2022         1.0           DucPTMHE160517     First Implement
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.PropertyUtility;

/**				
 * The class contains method find update, delete, insert property utility to/from DB			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */

public interface IPropertyUtilityDAO {

    /**
     *
     * @param pid
     * @return
     * @throws SQLException
     */
    public List<PropertyUtility> getUtilitiesByPID(int pid) throws SQLException;

    /**
     *
     * @param property_id
     * @param propertyUtility
     * @throws SQLException
     */
    public void insertPropertyUtility(PropertyUtility propertyUtility) throws SQLException;
}
