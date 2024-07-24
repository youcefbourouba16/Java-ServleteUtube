/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package produit;

import Models.Produit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author youcef
 */
@WebServlet(name = "Produit_Servlete", urlPatterns = {"/Produit_Servlete"})
public class Produit_Servlete extends HttpServlet {

    
    List<Produit> prduits= new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String code_produit= req.getParameter("code_produit");
        String nom_produit= req.getParameter("Nom_produit"); 
        int Qts=Integer.parseInt(req.getParameter("Qts_produit")) ;
        
        
        Produit pr=new Produit(
                 code_produit,
                 nom_produit,
                 Qts
        );
        prduits.add(pr);
        
        
        RequestDispatcher rd= req.getRequestDispatcher("index.html");
        
        PrintWriter out=resp.getWriter();
        // Write HTML content to the response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        rd.include(req, resp);
        out.println("<center>");
        out.println("<h1> Les informations de produit envoyées  :</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Code</th><th>Nom</th><th>Quantité</th><th>Prix Total</th></tr>");

        // Loop through each product and create a table row
        for (Produit item : prduits) {
            out.println("<tr>");
            out.println("<td>" + item.getCode_produit() + "</td>");
            out.println("<td>" + item.getNom_produit() + "</td>");
            out.println("<td>" + item.getQts_produit() + "</td>");
            out.println("<td>" + item.getQts_produit()*500 + "</td>");
            out.println("</tr>");
        }
        
        

        out.println("</table>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
        
        
       
    }

}
