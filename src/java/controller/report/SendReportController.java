/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 15, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.report;

import dal.IPropertyDAO;
import dal.IReportDAO;
import dal.IUserDAO;
import dal.impl.PropertyDAOImpl;
import dal.impl.ReportDAOImpl;
import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;
import model.Property;
import model.User;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class SendReportController extends HttpServlet {

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
        String target = request.getParameter("target");
        int targetId = Integer.parseInt(request.getParameter("targetid"));
        try {
            switch (target) {
                case "property": {
                    IPropertyDAO propertyDAO = new PropertyDAOImpl();
                    Property reportedProperty = propertyDAO.getPropertyById(targetId);
                    request.setAttribute("target", reportedProperty);
                    request.getRequestDispatcher("/views/report/report.jsp").forward(request, response);
                    break;
                }
                case "user": {
                    IUserDAO userDAO = new UserDAOImpl();
                    User reportedUser = userDAO.getUserById(targetId);
                    request.setAttribute("target", reportedUser);
                    request.getRequestDispatcher("/views/report/report.jsp").forward(request, response);
                    break;
                }
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex);
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
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        String target = request.getParameter("target");
        int targetId = Integer.parseInt(request.getParameter("targetid"));
        String header = request.getParameter("header");
        String content = request.getParameter("content");
        Date reportDate = new Date(Calendar.getInstance().getTimeInMillis());
        try {
            IReportDAO reportDAO = new ReportDAOImpl();
            int currentUserId = currentUser.getId();
            switch (target) {
                case "property": {
                    reportDAO.insertReportProperty(currentUserId, targetId, reportDate, header, content);
                    break;
                }
                case "user": {
                    reportDAO.insertReportUser(currentUserId, targetId, reportDate, header, content);
                    break;
                }
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

}
