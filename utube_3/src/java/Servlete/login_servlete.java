/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlete;

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
public class login_servlete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp ) throws ServletException, IOException
    {
        String email=req.getParameter("email");
        String psw=req.getParameter("password");
        
        if (email.equals("youcef@gmail.com") &&
            psw.equals("youcef123")     ) {
            
            HttpSession session= req.getSession();
            session.setAttribute("Email",email);
            session.setAttribute("Password",psw);
            req.getRequestDispatcher("products.html").forward(req, resp);
            
        }else {
            req.getRequestDispatcher("sign-up.html").forward(req, resp);
        }
    }

}
