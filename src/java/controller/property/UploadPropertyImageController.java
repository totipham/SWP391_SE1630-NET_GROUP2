/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 14, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.property;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utils.FileUtility;
import utils.ValidateUtility;

/**
 * The class contains method The method wil throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
@MultipartConfig
public class UploadPropertyImageController extends HttpServlet {

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
        ValidateUtility validate = new ValidateUtility();
        FileUtility fileUtils = new FileUtility();
        String folder = request.getServletContext().getRealPath("/assets/images");

        String filename = null;
        try {

            Part part = validate.getFieldAjaxFile(request, "thumbnail", true);

            //check if file size is not equal to 0
            if (part.getSize() != 0) {

                filename = fileUtils.upLoad(part, folder); //upload avatar file to path
            }
        } catch (Exception e) {
            request.setAttribute("message", e);
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }
}
