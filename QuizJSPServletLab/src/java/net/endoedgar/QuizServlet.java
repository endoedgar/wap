package net.endoedgar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizServlet extends HttpServlet {  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz q = (Quiz)session.getAttribute("quiz");
        if(q == null) {
            q = new Quiz();
            session.setAttribute("quiz", q);
        }
        
        if(request.getParameter("age") != null) {
            try {
                int age = Integer.parseInt(request.getParameter("age"));
                if(age >= 4 && age <= 100)
                    session.setAttribute("age", age);
                else {
                    session.removeAttribute("age");
                    request.setAttribute("ageMessage", "This field requires a number between 4 and 100.");
                }
            } catch(NumberFormatException nfe) {
                request.setAttribute("ageMessage", "This field is required and you have to enter an integer.");
            }
        }
        
        if(session.getAttribute("age") != null) {
            if(request.getParameter("guess") != null) {
                try {
                    int guess = Integer.parseInt(request.getParameter("guess"));
                    q.guess(guess);
                } catch(NumberFormatException nfe) {}
            }
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("showQuiz.jsp");
        request.setAttribute("quiz", q);
        dispatcher.forward(request, response);
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
