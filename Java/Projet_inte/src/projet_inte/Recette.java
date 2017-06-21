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
public class Recette {
    private String nom;
    private float cout;
    private float prix;
    private Ingredient composition[];
    
    /**
     * Constructeur
     * @param nom
     * @param cout
     * @param composition 
     */
    public Recette(String nom, float cout, float prix, Ingredient[] composition) {
        this.prix = prix;
        this.nom = nom;
        this.cout = cout;
        this.composition = composition;
    }
    
    /**
     * 
     * @return le prix de la recette
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Définit le prix de la recette
     * @param prix 
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    /**
     * 
     * @return le nom de la recette
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom de la recette
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * 
     * @return le cout de la recette
     */
    public float getCout() {
        return cout;
    }

    /**
     * Définit le cout de la recette
     * @param cout 
     */
    public void setCout(float cout) {
        this.cout = cout;
    }
    
    /**
     * 
     * @return le tableau d'ingrédient de la recette
     */
    public Ingredient[] getComposition() {
        return composition;
    }
    
    /**
     * Définit le tableau d'ingrédient de la recette
     * @param composition 
     */
    public void setComposition(Ingredient[] composition) {
        this.composition = composition;
    }
    
    /**
     * Calcul le nouveau cout de la recette
     */
    public void CalculCout(){
        float newCout =0;
        for(int i = 0; this.composition.length>i; i++ ){
            newCout += this.composition[i].getPrix();
        }
        this.cout = newCout;
    }
}
