/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youcef
 */
public class Db_connect {
    
    
    private static final String URL="jdbc:mysql://localhost:3306/utube_web";
    private static final String USER="root";
    private static final String Passwrod="";
    
    public static Connection con;
    
    
    public static void  connecter(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Db_connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("didnt work 1");
        }
        
        try {
            con = DriverManager.getConnection(URL,USER,Passwrod);
        } catch (SQLException ex) {
            Logger.getLogger(Db_connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("didnt work 2");
        }
        
            
            System.out.println("connect");
    }
    
    public static void deconnecter ()
    {
        if (con!=null) {
            try {
                con.close();
                System.out.println("disconected");
            } catch (SQLException ex) {
                Logger.getLogger(Db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static boolean login(String email,String password) 
    {
        connecter();
        
        String reqSql="select * from user where email=? and password=?;";
        try(PreparedStatement ps= con.prepareStatement(reqSql))
        {
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs= ps.executeQuery();
            boolean check=false;
            if (rs.next()) {
                System.out.println("User exist ");
                check=true;
                
            }
            deconnecter();
            return check;
            
            
        }catch (SQLException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
    public static User getUserByID(String email,String password){
        String sql="select * from user where email=? and password=?;";
        User user=new User();
        connecter();    
        try(PreparedStatement ps= con.prepareStatement(sql))
        {
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs= ps.executeQuery();
            if (rs.next()) {
                System.out.println("User exist ");
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
            }
            deconnecter();
            return user;
            
        }catch (SQLException ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    public static boolean addNewUser(User user){
        connecter();
        String sql="insert into user (email,userName,password) VALUES(?,?,?);";
        try(PreparedStatement ps= con.prepareStatement(sql))
        {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            
            int rowsAffected= ps.executeUpdate();
            boolean check= false;
            if (rowsAffected>0) {
                System.out.println("user added succsfully");
                check=true;
            }else System.out.println("user cannout be added");
            deconnecter();
            return check;
            
            
        }catch (SQLException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean UpdateUser(User user){
        connecter();
        String sql="UPDATE user set userName=?, password=?  where email=?";
        try(PreparedStatement ps= con.prepareStatement(sql))
        {
            
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            
            int rowsAffected= ps.executeUpdate();
            boolean check= false;
            if (rowsAffected>0) {
                System.out.println("user added succsfully");
                check=true;
            }else System.out.println("user cannout be added");
            deconnecter();
            return check;
            
            
        }catch (SQLException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
}
