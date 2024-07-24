/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author youcef
 */
@WebServlet(name = "FirstServlet", urlPatterns = {"/FirstServlet"})
public class FirstServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/html");
        String nom=req.getParameter("nom");
        String prenom=req.getParameter("prenom");
        PrintWriter out=resp.getWriter();
        // Write HTML content to the response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("le nom est : " + nom);
        out.println("<br>");
        out.println("le prenom est : " + prenom);
        out.println("</body>");
        out.println("</html>");
        out.close();
        
    }
    

}
