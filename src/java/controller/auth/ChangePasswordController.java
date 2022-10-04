

package controller.auth;

import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Asus
 */
public class ChangePasswordController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
        } else {
            request.getRequestDispatcher("views/auth/chgpwd.jsp").forward(request, response);
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
        UserDAOImpl udb = new UserDAOImpl();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        
        String oldpwd = request.getParameter("oldpassword");
        String newpwd = request.getParameter("password");
        String renewpwd = request.getParameter("repassword");
        
        if (oldpwd.equals(u.getPassword())) {
            if (newpwd.equals(renewpwd)) {
                System.out.println("newpwd: " + newpwd);
                udb.updateNewPassword(u.getId(), newpwd);
            } else {
                request.setAttribute("result", "Passwords do not matching!");
                request.getRequestDispatcher("views/auth/chgpwd.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("result", "Password you entered is not correct!");
            request.getRequestDispatcher("views/auth/chgpwd.jsp").forward(request, response);
        }
        request.setAttribute("result", "Change password successfully!");
        request.getRequestDispatcher("views/auth/chgpwd.jsp").forward(request, response);
    }

}
