/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.scene.paint.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import projet_inte.Client;
import projet_inte.Communication;
import projet_inte.Ingredient;
import projet_inte.Joueur;
import projet_inte.Map;
import projet_inte.Prod;
import projet_inte.*;
import projet_inte.Recette;

/**
 *
 * @author Théo
 */
public class JavaFXApplication extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*        
        *   SETUP
        */
        
       
        /* Création de la map */
        ArrayList<Client> client = new ArrayList();
        ArrayList<Joueur> joueur = new ArrayList();
        
        Map carte = Map.getInstance(double longitude, double lattitude, double long_span, double lat_span, ArrayList<Joueur> joueur);
        
        
       
      
        
      
        carte.NombreClient();
        
        Communication com = new Communication();
        
        /*
        *  JEU DE TEST
        */
        
        /* affichage taille map */
        System.out.println("Taille map :");
        System.out.println(carte.getLat_span());
        System.out.println(carte.getLong_span());
        System.out.println(carte.getLattitude());
        System.out.println(carte.getLongitude());
        System.out.println();
        
        ArrayList<Joueur> jou = carte.getJoueur();
        /* Affichage des positions des stands des joueurs */
        System.out.println("Affichage des positions des joueurs");
        for (int i=0; i<jou.size(); i++){
            System.out.println(jou.get(i).getEmplacement().get(0).getLattitude());
            System.out.println(jou.get(i).getEmplacement().get(0).getLongitude());
        }
        System.out.println();
        
        limonade.CalculCout();
        
        
      
        
        /* Affichage du budget */
        System.out.println("Affichage des budget: ");
        for (int i=0; i<jou.size(); i++){
            System.out.println(jou.get(i).getBudget());
        }
        System.out.println();
        
        /* Récupération de la météo et lancement des ventes */
        //ArrayList<String> weather = new ArrayList();
        //weather.add("sunny");
        try {
            carte.LancerVente(com.GetWeather());
        } catch (Exception ex) {
            Logger.getLogger(Projet_inte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Affichage du budget */
        System.out.println("Affichage des budget: ");
        for (int i=0; i<jou.size(); i++){
            System.out.println(jou.get(i).getBudget());
        }
        System.out.println();
        
        launch(args);
    }
    
    /**
     * 
     * @param stage 
     */
    @Override
    public void start(Stage stage) {
        
        ArrayList<Client> client = new ArrayList();
        ArrayList<Joueur> joueur = new ArrayList();
        Map carte = Map.getInstance(0, 0, 0, 0);
        
        //Create the StackPane
        StackPane holder = new StackPane();
        // Create the Canvas
        Canvas canvas = new Canvas(carte.getLattitude(), carte.getLongitude());
        // Set the width of the Canvas
        canvas.setWidth(carte.getLat_span()*2);
        // Set the height of the Canvas
        canvas.setHeight(carte.getLong_span()*2);

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // création des stand et pub des joueurs
        for (int i=0; i<carte.getJoueur().size(); i++){
            for (int j=0; j<carte.getJoueur().get(i).getEmplacement().size(); j++){
                float x =  carte.getJoueur().get(i).getEmplacement().get(j).getLongitude() + carte.getLong_span();
                float y =  carte.getJoueur().get(i).getEmplacement().get(j).getLattitude() + carte.getLat_span();
                float z =  carte.getJoueur().get(i).getEmplacement().get(j).getInfluence() ;
                
                System.out.println( x+" "+y+" "+z);
                gc.fillRect(x, y, z, z);
            }
        }
        
        for (int i=0; i<carte.getClient().size(); i++){
            float x =  carte.getClient().get(i).getLongitude() + carte.getLong_span();
            float y =  carte.getClient().get(i).getLattitude() + carte.getLat_span();
            
            gc.setFill(Color.RED);
            gc.fillRect(x, y, 5, 5);
            
                
        }
        
        // Create the Pane
        Pane root = new Pane();
        
        // Add the Canvas to the Pane and the holder
        holder.getChildren().add(canvas);
        root.getChildren().add(holder);
        
        holder.setStyle("-fx-background-color: green");
        
        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("Creation of a Canvas");
        stage.setFullScreen(true);
        // Display the Stage
        stage.show();
    
          
    }
    
    }
    

