package controller.auth;

import dal.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.ValidateUtility;

/**
 *
 * @author Asus
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
        try {
            UserDAOImpl userDAO = new UserDAOImpl();

            String name = request.getParameter("name");
            String phone = validate.getFieldByType(request, "phone", "phone", true, 0, 11);
            String email = request.getParameter("email");
            String address = validate.getField(request, "address", true, 10, 30);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            //check if username is existed in database
            if (userDAO.isDuplicateUsername(username)) {
                throw new Exception("Username " + username + " is existed!");
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
