/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * DashboardController
 * Record of change:
 *      DATE: Oct 10, 2022            
 *      VERSION: 1.0
 *      AUTHOR: DucPTMHE160517          
 */


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author DucPTMHE160517
 */

public class DashboardController extends HttpServlet {
   
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("page", "Dashboard");
        request.getRequestDispatcher("views/dashboard/host/dashboard.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
