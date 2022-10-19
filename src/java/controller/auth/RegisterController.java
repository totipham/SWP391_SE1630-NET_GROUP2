/*
* Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 5, 2022         1.0           LanBTHHE160676     First Implement
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
import utils.ValidateUtility;

/**				
 * The class contains method insert user to DB			
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Still have some issues related to search staff by address				
 *				
 * @author LanBTHHE160676				
 */	
public class RegisterController extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        //Check if user is logged in or not
        if (loggedIn) {
            response.sendRedirect(request.getContextPath());
        } else {
            request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
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
        //get and check information registed 
        try {
            IUserDAO userDAO = new UserDAOImpl();

            String name = validate.getField(request, "name", true, 3, 20);
            String phone = validate.getFieldByType(request, "phone", "phone", true, 9, 11);
            String email = validate.getFieldByType(request, "email", "email", true, 11, 200);
            String address = validate.getField(request, "address", true, 10, 30);
            String username = validate.getField(request, "username", true, 3, 20);
            String password = validate.getField(request, "password", true, 3, 20);

            //check if user with username is existed
            if (userDAO.getUserByUsername(username) != null) {
                throw new Exception("Username " + username + " is existed!");
            }
            
            //check if user with email is existed
            if (userDAO.getUserByEmail(email) != null) {
                throw new Exception("Email " + email + " is existed!");
            }

            String message = userDAO.insertUser(name, phone, email, address, username, password);
            request.setAttribute("success", message);
            request.getRequestDispatcher("views/auth/register.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("views/auth/register.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
