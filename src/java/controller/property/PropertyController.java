package controller.property;

import dal.PropertyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Property;
import model.User;

/**
 *
 * @author Asus
 */
public class PropertyController extends HttpServlet {

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
            out.println("<title>Servlet PropertyController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PropertyController at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        if (id_raw == null || id_raw.equals("")) {
            response.sendRedirect("properties");
            return;
        }

        PropertyDAO pd = new PropertyDAO();
        int id = 0;

        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        Property p = pd.getPropertyById(id);
//        RequestDAO rd = new ReservationDAO();
        if (p != null) {

            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("user");

            if (u != null) {
                if (p.getHost().getId() == u.getId()) {
                    request.setAttribute("is_owner", true);
                } else {
//                    ReservationState rstate = rd.checkReservationState(id, u.getId());
//
//                    if (rstate != null) {
//                        request.setAttribute("state", rstate);
//                    }
                }
            }
//            if (pd.getAvailableByPID(id) <= 0) {
//                request.setAttribute("is_available", "true");
//            }

            request.setAttribute("property", p);
            request.getRequestDispatcher("views/property/property.jsp").forward(request, response);
        } else {
            response.sendRedirect("properties");
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
        processRequest(request, response);
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
