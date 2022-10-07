/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * RequestStatusController
 * Record of change:
 *      DATE: Oct 7, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
package controller.property;

import dal.IRequestDAO;
import dal.impl.RequestDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author LANBTHHE160676
 */
public class RequestStatusController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int requestID = Integer.parseInt(request.getParameter("rid"));
        int requestStatusID = Integer.parseInt(request.getParameter("rstatusID"));
        //user choose delete renting request
        if (action.equalsIgnoreCase("delete")) {
            deleteRequest(requestID);
        }
        //user choose update renting request status
        if (action.equalsIgnoreCase("update")) {
            updateRequest(requestID,requestStatusID);
        }
        request.setAttribute("message", action +" successful");
        request.getRequestDispatcher("*").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    IRequestDAO requestDAO = new RequestDAOImpl();

    private void deleteRequest(int rid) {
        requestDAO.deleteRequestByRID(rid);
    }

    private void updateRequest(int rid, int newStatus) {
        
        requestDAO.updateStatusByRID(rid, newStatus);
    }
}
