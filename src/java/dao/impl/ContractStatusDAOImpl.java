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

package dao.impl;

import dao.DBContext;
import dao.IContractStatusDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ContractStatus;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ContractStatusDAOImpl extends DBContext implements IContractStatusDAO{

    @Override
    public ContractStatus getContractStatusById(int contractStatusId) throws Exception {
        String sql = "SELECT * FROM ContractStatus WHERE cstatus_id=?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, contractStatusId);
            result = statement.executeQuery();
            while (result.next()) {
                ContractStatus contractStatus = new ContractStatus();
                contractStatus.setId(result.getInt("cstatus_id"));
                contractStatus.setStatus(result.getString("cstatus"));

                return contractStatus;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }
        return null;
    }
}
