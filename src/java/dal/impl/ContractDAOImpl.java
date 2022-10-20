/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal.impl;

import dal.DBContext;
import dal.IContractDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ContractDAOImpl extends DBContext implements IContractDAO{

    @Override
    public void insertContract(int propertyId, int userId, Date beginDate) throws Exception {
        String sql = "INSERT INTO Contract (property_id ,user_id ,begin_date, cstatus_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, propertyId);
            statement.setInt(2, userId);
            statement.setDate(3, beginDate);
            statement.setInt(4, 1);
            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

}
