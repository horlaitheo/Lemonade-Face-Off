/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_inte;

/**
 *
 * @author Théo
 */
public class Ingredient {
    private String nom;
    private float prix;
    
    /**
     * constructeur d'ingrédient
     * @param nom
     * @param prix 
     */
    public Ingredient(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }
    
    /**
     * retourne le nom de l'ingrédient  
     * @return 
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * définit le nom de l'ingrédient
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * 
     * @return le prix de l'ingrédient
     */
    public float getPrix() {
        return prix;
    }
     /**
      *  définit le prix de l'ingrédient
      * @param prix 
      */
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    /**
     * calcul la nouveau prix des ingrédients
     */
    public void fluctuation(){
        //TODO
    }
}
