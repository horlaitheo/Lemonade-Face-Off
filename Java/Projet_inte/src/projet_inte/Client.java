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
public class Client {
    private float longitude;
    private float lattitude;
    private Joueur  joueur[];
    
    /**
     * Constructeur de Client
     * @param longitude
     * @param lattitude
     * @param joueur 
     */
    public Client(float longitude, float lattitude, Joueur[] joueur) {
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.joueur = joueur;
    }
    
    /**
     * 
     * @return la longitude du client
     */
    public float getLongitude() {
        return longitude;
    }
    
    /**
     * Définit la longitude d'un client
     * @param longitude 
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return les joueurs
     */
    public Joueur[] getJoueur() {
        return joueur;
    }

    /**
     * Définit les joueurs
     * @param joueur 
     */
    public void setJoueur(Joueur[] joueur) {
        this.joueur = joueur;
    }
    
    
    /**
     * 
     * @return la lattitude d'un client
     */
    public float getLattitude() {
        return lattitude;
    }

    /**
     * Définit la lattitude d'un client
     * @param lattitude 
     */
    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }
    
    
    public void Target(){
        
    }
    
    public void Move(){
        
    }
    
    public void analyse(){
        
    }
}
