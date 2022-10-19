/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 19, 2022       1.0           DucPTMHE160517     First Implement
 */

package controller.auth;

import dal.IUserDAO;
import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.MailUtility;
import utils.ValidateUtility;

/**				
 * The Servlet responsible for handling forget password function /forget is the URL			
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet			
 *				
 * @author DucPTMHE160517				
 */				

public class ForgetPasswordController extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        //check if user is not null
        if (user != null) {
            response.sendRedirect(request.getContextPath()); //redirect to home page 
        } else {
            request.getRequestDispatcher("*").forward(request, response); //redirect to XXXXXXXXXX
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        //check if user is not null
        if (user != null) {
            response.sendRedirect(request.getContextPath()); //redirect to home page 
        }
        
        IUserDAO userDAO = new UserDAOImpl();
        
        ValidateUtility validate = new ValidateUtility();
        
        try {
            String email = validate.getFieldByType(request, "email", "email", true, 5, 30);
            
            //check if user with inputed email existed or not
            if (userDAO.getUserByEmail(email) != null) {
                MailUtility mailUtils = new MailUtility();
                String token = mailUtils.generateTokenString(); //generate token string from mailUtils
                user.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail(user); //send mail to user, if success then do next action
                
                
                
            } else {
                request.setAttribute("error", "User with this email isn't existed!");
                request.getRequestDispatcher("*").forward(request, response); //forward to XXXXXXXXXXX
            }
            
            
            
            request.getRequestDispatcher("*").forward(request, response); //forward to XXXXXXXXXXX
        } catch (Exception ex) {
            request.setAttribute("message", ex); //set exception for message
            request.getRequestDispatcher("views/error.jsp").forward(request, response); //forward to error page
        }
    }

}
