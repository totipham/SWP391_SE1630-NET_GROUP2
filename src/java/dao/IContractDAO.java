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

package dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import model.User;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public interface IContractDAO {

    /**
     *
     * @param propertyId
     * @param userId
     * @param beginDate
     * @throws Exception
     */
    public void insertContract(int propertyId, int userId, Date beginDate) throws Exception;
    
    /**
     *
     * @param hostId
     * @param begin
     * @param end
     * @return
     * @throws Exception
     */
    public int getNumberOfContractInRange(int hostId, Date begin, Date end) throws Exception;
    
    /**
     *
     * @param hostId
     * @param date
     * @return
     * @throws Exception
     */
    public List<User> getRenterListByDate(int hostId, Date date) throws Exception;
    
    /**
     *
     * @param hostId
     * @param begin
     * @param end
     * @return
     * @throws Exception
     */
    public Map<Date, Double> getIncomeInRange(int hostId, Date begin, Date end) throws Exception;
}
