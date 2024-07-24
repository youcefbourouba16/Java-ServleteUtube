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
@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class singup_Servlete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        String email= request.getParameter("email");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String confPas=request.getParameter("confirmpassword");
        if (!password.equals(confPas)) {
             RequestDispatcher dispatcher= request.getRequestDispatcher("signup1.html");
            dispatcher.forward(request, response);
        }else{
            User user1=new User();
            user1.setEmail(email);
            user1.setPassword(password);
            user1.setUserName(userName);

            boolean check=Db_connect.addNewUser(user1);
            if (check) {
                RequestDispatcher dispatcher= request.getRequestDispatcher("login.html");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher= request.getRequestDispatcher("signup.html");
                dispatcher.forward(request, response);
            }
        }
        
    }

}
