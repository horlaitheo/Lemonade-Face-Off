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
public class Map {
    private float longitude;
    private float lattitude;
    private float long_span;
    private float lat_span;
    private Joueur joueur[];
    private static Map INSTANCE = null;
    
    /**
     * Constructeur de la map
     * @param longitude
     * @param lattitude
     * @param long_span
     * @param lat_span
     * @param joueur 
     */
    public Map(float longitude, float lattitude, float long_span, float lat_span, Joueur[] joueur) {
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.long_span = long_span;
        this.lat_span = lat_span;
        this.joueur = joueur;
    }
    
    /**
     * Creer une instance de map
     * @param longitude
     * @param lattitude
     * @param long_span
     * @param lat_span
     * @param joueur
     * @return l'instance de la map
     */
    public static Map getInstance(float longitude, float lattitude, float long_span, float lat_span, Joueur[] joueur){
        if (INSTANCE == null){
            INSTANCE = new Map( longitude, lattitude, long_span, lat_span, joueur);
        }
        return INSTANCE;
    }
    
    /**
     * 
     * @return la longitude de la map 
     */
    public float getLongitude() {
        return longitude;
    }
    
    /**
     * Définit la longitude de la map
     * @param longitude 
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    /**
     * 
     * @return la lattitude de la map
     */
    public float getLattitude() {
        return lattitude;
    }
    
    /**
     * Définit la lattitude de la map
     * @param lattitude 
     */
    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }
    
    /**
     * 
     * @return le span de la map
     */
    public float getLong_span() {
        return long_span;
    }
    
    /**
     * Définit le span de la map
     * @param long_span 
     */
    public void setLong_span(float long_span) {
        this.long_span = long_span;
    }
    
    /**
     * 
     * @return le span de la map
     */
    public float getLat_span() {
        return lat_span;
    }
    
    /**
     * Définit le span de la map
     * @param lat_span 
     */
    public void setLat_span(float lat_span) {
        this.lat_span = lat_span;
    }
    
}
