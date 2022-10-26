/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.report;

import dao.IReportTypeDAO;
import dao.impl.ReportTypeDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ReportType;
import model.User;

/**
 * This is a Servlet responsible for handling view report type function 
 * /dashboard/viewreporttype is the URL
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class ViewReportTypeController extends HttpServlet {

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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //check if current user is null
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + request.getServletPath());
            return;
        }

        try {
            //check role of current user is admin or not
            if (user.getRole() == 3 || user.getRole()==2) {
                List<ReportType> listReportType = new ArrayList<ReportType>();
                IReportTypeDAO reportTypeDAO = new ReportTypeDAOImpl();
                listReportType = reportTypeDAO.getAllReportTypes();
                request.setAttribute("allreporttype", listReportType);
                request.getRequestDispatcher("*").forward(request, response);
            } else {
                request.setAttribute("message", "You don't have permission to access this function");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewReportTypeController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
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
        //processRequest(request, response);
        
    }

}
