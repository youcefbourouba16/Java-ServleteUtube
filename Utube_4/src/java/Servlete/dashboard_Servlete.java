/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlete;

import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author youcef
 */
@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class dashboard_Servlete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
        if (session!=null) {
            String email=(String) session.getAttribute("email");
            User user1=new User();
            user1.setEmail(email);
            user1.setUserName("fjsdfksdjl");
            user1.setPassword("123");
            
            request.setAttribute("user", user1);
            
            
            RequestDispatcher dispatcher= request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
            
        }else 
        {
            RequestDispatcher dispatcher= request.getRequestDispatcher("login.html");
            dispatcher.forward(request, response);
        }
    }

}
