/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 16, 2022         1.0           LanBTHHE160676     First Implement
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import java.sql.SQLException;
import java.util.List;
import model.ReportType;

/**				
 		
 *				
 * @author LanBTHHE160676				
 */
public interface IReportTypeDAO {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<ReportType> getAllReportTypes() throws Exception;

    /**
     *
     * @param newReportType
     * @throws Exception
     */
    public void insertReportType(String newReportType) throws Exception;

    /**
     *
     * @param reportType
     * @throws Exception
     */
    public void deleteReportType(int reportType) throws Exception;
}
