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
import java.util.ArrayList;
import model.PropertyImage;

/**				
 * The class contains method find update, delete, insert property image to/from DB			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */
public interface IPropertyImageDAO {

    /**
     *
     * @param pid
     * @return
     * @throws SQLException
     */
    public ArrayList<PropertyImage> getImagesByPID(int pid) throws SQLException;

    /**
     *
     * @param propertyImage
     * @throws SQLException
     */
    public void insertPropertyImage(PropertyImage propertyImage) throws SQLException;
}
