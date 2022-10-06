/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * RequestDAOImpl
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal.impl;

import dal.DBContext;
import dal.IRequestDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Desciption:
 *
 * @author LANBTHHE160676 
 */
public class RequestDAOImpl extends DBContext implements IRequestDAO{

    @Override
    public void insertRequest(int user_id, int property_id, Date requestDate) {
        String sql = "INSERT INTO Request (user_id ,property_id ,request_date, rstatus_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, user_id);
            st.setInt(2, property_id);
            st.setDate(3, requestDate);
            st.setInt(4, 1);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
