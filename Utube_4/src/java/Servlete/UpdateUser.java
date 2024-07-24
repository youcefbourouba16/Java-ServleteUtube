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
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author youcef
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        
        
        String email=request.getParameter("email");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        User userl=new User();
        String updateStatus="";
        User user=new User(email,userName,password);
        if (Db_connect.UpdateUser(user)) {
            updateStatus="user Updated succesfully";
            
            userl=Db_connect.getUserByID(email, password);
        }else 
        {
            updateStatus="this user cannout be updated";
        }
        
        request.setAttribute("user", userl);
        request.setAttribute("updateStatus", updateStatus);
            
        RequestDispatcher dispatcher= request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
        
        
        
        
    }

}
