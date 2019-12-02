package net.endoedgar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServlet extends HttpServlet {  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Quiz q = (Quiz)request.getSession().getAttribute("quiz");
        if(q == null) {
            q = new Quiz();
            request.getSession().setAttribute("quiz", q);
        }
        
        if(request.getParameter("guess") != null) {
            try {
                int guess = Integer.parseInt(request.getParameter("guess"));
                q.guess(guess);
            } catch(NumberFormatException nfe) {}
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizServlet</title>");  
            out.println("<meta charset=\"utf-8\" />"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The Number Quiz</h1>");
            
            List<String> currentQuestionText = q.getCurrentQuestion();
            currentQuestionText.forEach((line) -> {
                out.println("<p>" + line + "</p>");
            });
            
            if(!q.isFinished()) {
                out.println("<form method=\"POST\">");
                out.println("<p><label>Your answer: <input type=\"text\" name=\"guess\" /></label></p>");  
                out.println("<p><input type=\"submit\" value=\"Submit\" /></p>"); 
                out.println("</form>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for the Quiz Lab";
    }

}
