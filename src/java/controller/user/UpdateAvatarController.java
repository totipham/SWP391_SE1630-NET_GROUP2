/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 10, 2022         1.0           DucPTMHE160517     First Implement
 */
package controller.user;

import dal.impl.UserDAOImpl;
import java.io.IOException;
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
 * The class contains method do post			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */
@MultipartConfig
public class UpdateAvatarController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        
        //check if user is not null
        if (u == null) {
            response.sendRedirect("login");
        }

        UserDAOImpl userDB = new UserDAOImpl();
        ValidateUtility validate = new ValidateUtility();

        FileUtility fileUtils = new FileUtility();
        String folder = request.getServletContext().getRealPath("/assets/images");

        String filename = null;
        try {

            Part part = validate.getFieldAjaxFile(request, "avatar", true);
            
            //check if file size is not equal to 0
            if (part.getSize() != 0) {
                
                //check if current avatar of user is exist
                if (u.getAvatar() != null && !u.getAvatar().isEmpty()) {
                    fileUtils.delete(u.getAvatar(), folder); //delete user avatar
                }
                
                filename = fileUtils.upLoad(part, folder); //upload avatar file to path
            }
            
            //check if file name of avatar is not null
            if (filename != null) {
                u.setAvatar(filename); 
            }
            
            userDB.updateAvatar(u); //insert avatar file name to DB
            
            response.sendRedirect("profile");
        } catch (Exception e) {
            request.setAttribute("message", e);
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }

}
