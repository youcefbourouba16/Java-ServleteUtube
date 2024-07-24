/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlete;

import Model.User;
import Server.Db_connect;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login_Servlete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        if (Db_connect.login(email, password)) {
            
            User user1=new User();
            
            user1=Db_connect.getUserByID(email, password);
            
            HttpSession session=request.getSession();
            session.setAttribute("email", email);  /// hashpam  email||youcef@gmail
            
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
