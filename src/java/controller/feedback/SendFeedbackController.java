/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 16, 2022         1.0           NgocCMHE161386     First Implement
 */
package controller.feedback;

import dal.IFeedbackDAO;
import dal.impl.FeedbackDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;
import utils.ValidateUtility;

/**
 * The class contains method find update, delete, insert staff information from
 *
 * The method wil throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author NgocCMHE161386
 */
public class SendFeedbackController extends HttpServlet {

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
        IFeedbackDAO feedbackDAO = new FeedbackDAOImpl();
        int userId, propertyId;
        String userId_raw = request.getParameter("uid_raw");
        String propertyId_raw = request.getParameter("pid_raw");
        try {
            userId = Integer.parseInt(userId_raw);
            propertyId = Integer.parseInt(propertyId_raw);
            String comment = validate.getField(request, "comment", true, 20, 180);
            Feedback newFeedback = feedbackDAO.sendFeedback(propertyId, userId);
            request.setAttribute("newFeedback", newFeedback);
            request.getRequestDispatcher("views/property/property.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(SendFeedbackController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
    }
}
