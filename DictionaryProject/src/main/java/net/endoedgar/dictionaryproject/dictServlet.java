package net.endoedgar.dictionaryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class dictServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("application/json;charset=UTF-8");
        String word = request.getParameter("word");
        if(word != null) {
            DbConnection con = new DbConnection();
            
            PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM entries WHERE word = ?");
            ps.setString(1, word);
            
            ResultSet rs = ps.executeQuery();

            JSONArray ja = new JSONArray();

            while(rs.next()) {
                JSONObject jo = new JSONObject();
                jo.put("word", rs.getString("word"));
                jo.put("wordType", rs.getString("wordType"));
                jo.put("definition", rs.getString("definition"));
                ja.add(jo);
            }

            try (PrintWriter out = response.getWriter()) {
                out.print(ja.toJSONString());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(dictServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(dictServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
