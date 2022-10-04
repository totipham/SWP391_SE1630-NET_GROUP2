package controller.user;

import dal.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.User;
import utils.FileUtility;
import utils.ValidateUtility;

/**
 *
 * @author totipham
 */
@MultipartConfig
public class UpdateAvatarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditAvatarController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAvatarController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
        }

        UserDAOImpl userDB = new UserDAOImpl();
        ValidateUtility validate = new ValidateUtility();

        FileUtility fileUtils = new FileUtility();
        String folder = request.getServletContext().getRealPath("/assets/images");
        
        System.out.println(folder);
        
        String filename = null;
        try {

            Part part = validate.getFieldAjaxFile(request, "avatar", true);
            if (part.getSize() != 0) {
                if (u.getAvatar() != null && !u.getAvatar().isEmpty()) {
                    fileUtils.delete(u.getAvatar(), folder);
                }
                filename = fileUtils.upLoad(part, folder);
            }
            if (filename != null) {
                u.setAvatar(filename);
            }
            userDB.updateAvatar(u);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        response.sendRedirect("profile");
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
