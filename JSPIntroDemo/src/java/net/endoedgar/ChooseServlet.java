package net.endoedgar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChooseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] choiceParameters = {"radioJSPCool", "JSFwayCool", "moonCheese" };
        HttpSession s = request.getSession();
        for(String choice : choiceParameters) {
            String choiceValue = request.getParameter(choice);
            if (choiceValue != null) {
                RadioState radioState = new RadioState();
                if(choiceValue.equals("1")) {
                    radioState.setYes();
                } else {
                    radioState.setNo();
                }
                s.setAttribute(choice, radioState);
            } else {
                s.removeAttribute(choice);
            }
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
}