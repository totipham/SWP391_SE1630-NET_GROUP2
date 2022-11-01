/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Nov 1, 2022         1.0           ThuongTTHE163555     First Implement
 */

package controller.feedback;

import dao.IFeedbackDAO;
import dao.impl.FeedbackDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;
import model.User;

/**				
 * The class contains method find update, delete, insert staff information from				
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author ThuongTTHE163555		
 */

@WebServlet(name="ViewFeedbackController", urlPatterns={"/viewfeedback"})
public class ViewFeedbackController extends HttpServlet {
   
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
        try {
            //check if user has logged in
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
            // get list of feedback from database
            List<Feedback> list = new ArrayList<>();
            IFeedbackDAO feedbackDAO = new FeedbackDAOImpl();
            list = feedbackDAO.getAllFeedback();
            //send list of users to front end
            request.setAttribute("feedbackList", list);
            request.setAttribute("page", "Feedbacks");
            request.getRequestDispatcher("*.jsp").forward(request, response); //Thêm url vào đây nha!!!

        } catch (Exception e) {
            Logger.getLogger(ViewFeedbackController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
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