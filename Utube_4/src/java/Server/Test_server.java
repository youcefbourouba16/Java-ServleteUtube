/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Model.User;

/**
 *
 * @author youcef
 */
public class Test_server {
    
    public static void main(String[] args) {
        
        
       
        User user=new User();
        user=Db_connect.getUserByID("koko@gmail", "koko");
        System.out.println(user.getUserName());
    }
    
}
