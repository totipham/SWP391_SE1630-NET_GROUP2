/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 5, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.request;

import dal.IPropertyDAO;
import dal.IRequestDAO;
import dal.IUserDAO;
import dal.impl.PropertyDAOImpl;
import dal.impl.RequestDAOImpl;
import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import model.User;
import utils.ValidateUtility;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a Servlet responsible for handling renting function /renting is the
 * URL of the web site Extend HttpServlet class
 *
 * @author LANBTHHE160676
 */
public class SendRentingController extends HttpServlet {

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
        HttpSession session = request.getSession();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        //check if user is logged in or not
        if (loggedIn) {
            //check if property id is null or not
            if (request.getParameter("pid") == null || request.getParameter("pid").equals("")) {
                request.setAttribute("message", "Property ID is missing");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            } else {
                try {
                    String pid_raw = request.getParameter("pid");
                    int pid = Integer.parseInt(pid_raw);
                    request.setAttribute("property", propertyDAO.getPropertyById(pid));
                    request.setAttribute("user", (User) session.getAttribute("user"));
                    request.getRequestDispatcher("/views/property/renting.jsp").forward(request, response);

                } catch (Exception ex) {
                    request.setAttribute("message", ex);
                    request.getRequestDispatcher("/views/error.jsp").forward(request, response);
                }
            }
        } else {
            String redirect = request.getServletPath() + "?" + request.getQueryString();
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString()));
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
        try {

            String fullname = validate.getField(request, "name", true, 3, 50);
            String phone = validate.getFieldByType(request, "phone", "phone", true, 9, 11);
            String email = validate.getFieldByType(request, "email", "email", true, 11, 200);
            String address = validate.getField(request, "address", true, 10, 30);
            int uid = Integer.parseInt(request.getParameter("uid"));
            int pid = Integer.parseInt(request.getParameter("pid"));
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            IRequestDAO requestDAO = new RequestDAOImpl();
            requestDAO.insertRequest(uid, pid, currentDate);

            IUserDAO userDAO = new UserDAOImpl();
            userDAO.updateUser(uid, fullname, phone, email, address);
            
            IPropertyDAO propertyDAO = new PropertyDAOImpl();
            request.setAttribute("user", userDAO.getUserById(uid));
            request.setAttribute("property", propertyDAO.getPropertyById(pid));
            request.setAttribute("message", "Request Successfully");
            request.getRequestDispatcher("/views/property/renting.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SendRentingController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/views/property/renting.jsp").forward(request, response);
        }
    }

}
