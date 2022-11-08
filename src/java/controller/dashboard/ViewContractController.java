/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 27, 2022         1.0           AnhVHHE160580     First Implement
 */
package controller.dashboard;

import controller.auth.SendTokenController;
import dao.IContractDAO;
import dao.IPropertyDAO;
import dao.impl.ContractDAOImpl;
import dao.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contract;
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
 * @author AnhVHHE160580
 */
public class ViewContractController extends HttpServlet {

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
        IContractDAO cDao = new ContractDAOImpl();
        User user = (User) session.getAttribute("user");

        //if user is not login
        if (user == null) {
            String redirect = request.getServletPath() + "?" + request.getQueryString();
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString()));
            return;
        }

        try {
            List<Contract> listContract = cDao.getContractByRenter(user.getId());
            request.setAttribute("listContract", listContract);
            request.getRequestDispatcher("views/user/rented_history.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ViewContractController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);

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

    }

}
