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
        String a1 = request.getParameter("a1");
        String b1 = request.getParameter("b1");
        String res1 = "";
        String a2 = request.getParameter("a2");
        String b2 = request.getParameter("b2");
        String res2 = "";
        
        if(a1.length() > 0 && b1.length() > 0) {
            try {
                res1 = String.valueOf(Integer.parseInt(a1) + Integer.parseInt(b1));
            } catch(NumberFormatException nfe) {}
        }
        
        if(a2.length() > 0 && b2.length() > 0) {
            try {
                res2 = String.valueOf(Integer.parseInt(a2) * Integer.parseInt(b2));
            } catch(NumberFormatException nfe) {}
        }
        
        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Improved Calculator Lab</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form action=\"Calculate\" method=\"POST\">\n" +
                "            <div><input type=\"text\" name=\"a1\" value=\""+a1+"\"/> + <input type=\"text\" name=\"b1\" value=\""+b1+"\"/> = <input readonly type=\"text\" name=\"res1\" value=\""+res1+"\"/></div>\n" +
                "            <div><input type=\"text\" name=\"a2\" value=\""+a2+"\"/> * <input type=\"text\" name=\"b2\" value=\""+b2+"\"/> = <input readonly type=\"text\" name=\"res2\" value=\""+res2+"\"/></div>\n" +
                "            <div><input type=\"submit\" value=\"Submit\"></div>\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>\n");
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
