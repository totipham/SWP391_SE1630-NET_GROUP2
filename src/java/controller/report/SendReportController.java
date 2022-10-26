/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 15, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.report;

import dao.IPropertyDAO;
import dao.IReportDAO;
import dao.IReportTypeDAO;
import dao.IUserDAO;
import dao.impl.PropertyDAOImpl;
import dao.impl.ReportDAOImpl;
import dao.impl.ReportTypeDAOImpl;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Property;
import model.ReportType;
import model.User;

/**
 * This is a Servlet responsible for handling send report function 
 * /sendreport is the URL
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
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        //check if current user is null
        if (currentUser == null) {
            String redirect = request.getServletPath() + "?" + request.getQueryString();
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString()));
            return;
        }

        String target = request.getParameter("target");
        int targetId = Integer.parseInt(request.getParameter("targetid"));

        try {
            IReportTypeDAO reportTypeDAO = new ReportTypeDAOImpl();
            List<ReportType> reportTypeList = reportTypeDAO.getAllReportTypes();
            switch (target) {
                case "property": {
                    IPropertyDAO propertyDAO = new PropertyDAOImpl();
                    Property reportedProperty = propertyDAO.getPropertyById(targetId);
                    request.setAttribute("reportedProperty", reportedProperty);

                    break;
                }
                case "user": {
                    if (currentUser.getId() != targetId) {
                        IUserDAO userDAO = new UserDAOImpl();
                        User reportedUser = userDAO.getUserById(targetId);
                        request.setAttribute("reportedUser", reportedUser);
                    } else {
                        request.setAttribute("message", "You can't report yourself");
                        request.getRequestDispatcher("/views/error.jsp").forward(request, response);
                    }
                    break;
                }
            }
            request.setAttribute("target", target);
            request.setAttribute("targetid", targetId);
            request.setAttribute("reportTypeList", reportTypeList);
            request.getRequestDispatcher("/views/report/report.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SendReportController.class.getName()).log(Level.SEVERE, null, ex);
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
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        int reportTypeId = Integer.parseInt(request.getParameter("type"));
        String target = request.getParameter("target");
        int targetId = Integer.parseInt(request.getParameter("targetid"));
        String header = request.getParameter("header");
        String content = request.getParameter("content");
        Date reportDate = Date.valueOf(LocalDate.now());
        try {
            IReportDAO reportDAO = new ReportDAOImpl();
            int currentUserId = currentUser.getId();
            boolean isReported = reportDAO.isReported(currentUserId, target, targetId);
            //check current user reported this property/user
            if (isReported == true) {
                request.setAttribute("message", "You reported this " + target);
            } else {
                reportDAO.insertReport(reportTypeId, currentUserId, targetId, target, reportDate, header, content);
                request.setAttribute("message", "Report successfully!");
            }

            IReportTypeDAO reportTypeDAO = new ReportTypeDAOImpl();
            List<ReportType> reportTypeList = reportTypeDAO.getAllReportTypes();
            switch (target) {
                case "property": {
                    IPropertyDAO propertyDAO = new PropertyDAOImpl();
                    Property reportedProperty = propertyDAO.getPropertyById(targetId);
                    request.setAttribute("reportedProperty", reportedProperty);

                    break;
                }
                case "user": {
                    if (currentUser.getId() != targetId) {
                        IUserDAO userDAO = new UserDAOImpl();
                        User reportedUser = userDAO.getUserById(targetId);
                        request.setAttribute("reportedUser", reportedUser);
                    } else {
                        request.setAttribute("message", "You can't report yourself");
                        request.getRequestDispatcher("/views/error.jsp").forward(request, response);
                    }
                    break;
                }
            }
            request.setAttribute("target", target);
            request.setAttribute("targetid", targetId);
            request.setAttribute("reportTypeList", reportTypeList);
            request.getRequestDispatcher("/views/report/report.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SendReportController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

}
