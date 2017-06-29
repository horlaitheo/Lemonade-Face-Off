/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_inte;

import java.util.ArrayList;

/**
 *
 * @author Théo
 */
public class Client {
    private boolean already = false ;

    private double longitude;
    private double latitude;
    private ArrayList<Joueur> joueur;
    
    public void setAlready(boolean already) {
        this.already = already;
    }

    public boolean isAlready() {
        return already;
    }
    
    /**
     * Constructeur de Client
     * @param longitude
     * @param lattitude
     * @param joueur 
     */
    public Client(double longitude, double latitude, ArrayList<Joueur> joueur) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.joueur = joueur;
    }

    /**
     * 
     * @return la longitude du client
     */
    public double getLongitude() {
        return longitude;
    }
    
    /**
     * Définit la longitude d'un client
     * @param longitude 
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return la liste de joueur
     */
    public ArrayList<Joueur> getJoueur() {
        return joueur;
    }
    
    /**
     * Définit la liste de joueur 
     * @param joueur 
     */
    public void setJoueur(ArrayList<Joueur> joueur) {
        this.joueur = joueur;
    }
    
    public void chooseCloser(ArrayList<Joueur> joueur){
       double lon=600.0;
       double lat= 600.0;
       double lonkept =0.0;
       double latkept =0.0;
       if(joueur!= null){
        for(int i =0;i<joueur.size();i++){
            for(int j =0;j<joueur.get(i).getItems().size();j++){
                
            if((joueur.get(i).getItems().get(j).getKind()).compareTo("stand")==0 ){
                
            if((joueur.get(i).getItems().get(j).getLongitude()-longitude)<lon || (longitude-joueur.get(i).getItems().get(j).getLongitude())<lon){
                lonkept=joueur.get(i).getItems().get(j).getLongitude();
                
            }
              if((joueur.get(i).getItems().get(j).getLatitude()-latitude)<lon || (latitude-joueur.get(i).getItems().get(j).getLatitude())<lon){
                latkept=joueur.get(i).getItems().get(j).getLatitude();
                
                             }        
                        }
                    }
             }
       }
        if(lonkept!=0 && latkept!=0){
        Move(lonkept,latkept);}
    }
    
    /**
     * 
     * @return la lattitude d'un client
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Définit la lattitude d'un client
     * @param lattitude 
     */
    public void setLattitude(double lattitude) {
        this.latitude = lattitude;
    }
    
   
    public void buy(){
        if(!already){
        for(int i=0; i<joueur.size();i++){
            for(int j=0;j<joueur.get(i).getItems().size();j++){
        if((this.longitude >joueur.get(i).getItems().get(j).getLongitude()+1 && this.longitude< joueur.get(i).getItems().get(i).getLongitude()-1) && (this.latitude>joueur.get(i).getItems().get(i).getLatitude()+1 && this.latitude<joueur.get(i).getItems().get(i).getLatitude()-1))
        {
           
            joueur.get(i).setQuantity(1);
            
            already=true;
            break;     
                
            }
          }
        }
      }
    }
    public void Move(double lo,double la){
       
        while((this.longitude >lo+1 && this.longitude< lo-1) && (this.latitude>la+1 && this.latitude<la-1)){
            if(this.longitude <lo && this.latitude<la){
            this.longitude=this.longitude+1;
            this.latitude=this.latitude+1;
                 }
            else if(this.longitude >lo && this.latitude<la){
            this.longitude=this.longitude-1;
            this.latitude=this.latitude+1;
            }
            else if(this.longitude >lo && this.latitude>la){
            this.longitude=this.longitude-1;
            this.latitude=this.latitude-1;
            }
            else if(this.longitude >lo && this.latitude<la){
            this.longitude=this.longitude+1;
            this.latitude=this.latitude-1;
            }
        }
        
        //déplacement du client jusqu'au stand
    }
    
    /* recherche tout les zones dans lesquelles ce trouve dans le client */
    public void analyse(){
       
    }
    
}
