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
public class Joueur {
    /**
     * structure permettant de définir la production
     */
    class Prod{public String recette;
                public int quantité;}
    
    private String nom;
    private float budget;
    private Prod production[];
    private Recette recette[];
    
    /**
     * Constructeur du joueur
     * @param nom
     * @param budget
     * @param production
     * @param recette 
     */
    public Joueur(String nom, float budget, Prod[] production, Recette[] recette) {
        this.nom = nom;
        this.budget = budget;
        this.production = production;
        this.recette = recette;
    }
    
    /**
     * 
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom du joueur
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * 
     * @return le budget du joueur 
     */
    public float getBudget() {
        return budget;
    }

    /**
     * Définit le buget du joueur
     * @param budget 
     */
    public void setBudget(float budget) {
        this.budget = budget;
    }

    /**
     * 
     * @return la production du joueur 
     */
    public Prod[] getProduction() {
        return production;
    }

    /**
     * Définit la production du joueur
     * @param production 
     */
    public void setProduction(Prod[] production) {
        this.production = production;
    }

    /**
     * 
     * @return les recettes du joueur
     */
    public Recette[] getRecette() {
        return recette;
    }

    /**
     * Définit les recettes du joueur
     * @param recette 
     */
    public void setRecette(Recette[] recette) {
        this.recette = recette;
    }
    
    public void CalculProd(){
        
    }
    
    public void CalculVente(){
        
    }
    
    public void CalculBudget(){
        
    }
}
