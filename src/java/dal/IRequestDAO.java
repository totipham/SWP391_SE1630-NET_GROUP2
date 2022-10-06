/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * IRequestDAO
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import java.sql.Date;
import java.util.Calendar;
/**
 * Desciption:
 *
 * @author LANBTHHE160676 
 */
public interface IRequestDAO {
    
    public void insertRequest(int user_id, int property_id, Date requestDate);
}
