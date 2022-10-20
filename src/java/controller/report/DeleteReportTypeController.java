/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.report;

import dal.IReportTypeDAO;
import dal.impl.ReportTypeDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.ValidateUtility;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method will
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class DeleteReportTypeController extends HttpServlet {

    private ValidateUtility validate = new ValidateUtility();

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
            if (user.getRole() == 3) {
                request.getRequestDispatcher("*").forward(request, response);
            } else {
                request.setAttribute("message", "You don't have permission to access this function");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(DeleteReportTypeController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            int reportTypeId = validate.fieldInt(request, "reporttypeid", 1, 100);
            IReportTypeDAO reportTypeDAO = new ReportTypeDAOImpl();
            reportTypeDAO.deleteReportType(reportTypeId);
            request.setAttribute("message", "Delete report type successful");
        } catch (Exception ex) {
            Logger.getLogger(DeleteReportTypeController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

}
