/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * DeletePropertyController
 * Record of change:
 *      DATE: Oct 13, 2022            
 *      VERSION: 1.0
 *      AUTHOR: ThuongTTHE163555         
 */

package controller.property;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author ThuongTTHE163555
 */

@WebServlet(name="DeletePropertyController", urlPatterns={"/delproperty"})
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