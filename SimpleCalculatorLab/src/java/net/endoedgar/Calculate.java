/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.endoedgar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class Calculate extends HttpServlet {


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
        PrintWriter out = response.getWriter();
        
        if(request.getParameter("a1").length() > 0) {
            int a1 = Integer.parseInt(request.getParameter("a1"));
            int b1 = Integer.parseInt(request.getParameter("b1"));
            out.println(a1 + " + " + b1 + " = " + (a1+b1));
        }
        
        if(request.getParameter("a2").length() > 0) {
            int a2 = Integer.parseInt(request.getParameter("a2"));
            int b2 = Integer.parseInt(request.getParameter("b2"));
            out.println(a2 + " * " + b2 + " = " + (a2*b2));
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
