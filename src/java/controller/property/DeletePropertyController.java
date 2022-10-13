/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 13, 2022         1.0           ThuongTTHE163555     First Implement
 */

package controller.property;

import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**				
 * The class contains method find update, delete, insert staff information from				
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author ThuongTTHE163555				
 */

public class DeletePropertyController extends HttpServlet {
   
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
        //get id from front end
        String pid = request.getParameter("pid");
        int id= Integer.parseInt(pid);
         // delete property  
        try {
            PropertyDAOImpl pDAO = new PropertyDAOImpl();
            pDAO.DeleteProperty(id);
            //re-load
            request.getRequestDispatcher("views/dashboard/host/dashboard.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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