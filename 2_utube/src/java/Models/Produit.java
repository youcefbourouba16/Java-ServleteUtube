/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author youcef
 */
public class Produit {

     String code_produit;
    String nom_produit;
    int Qts_produit;
    
    public Produit(String code_produit, String nom_produit, int Qts_produit) {
        this.code_produit = code_produit;
        this.nom_produit = nom_produit;
        this.Qts_produit = Qts_produit;
    }
    
    
   

    public String getCode_produit() {
        return code_produit;
    }

    public void setCode_produit(String code_produit) {
        this.code_produit = code_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getQts_produit() {
        return Qts_produit;
    }

    public void setQts_produit(int Qts_produit) {
        this.Qts_produit = Qts_produit;
    }
}
