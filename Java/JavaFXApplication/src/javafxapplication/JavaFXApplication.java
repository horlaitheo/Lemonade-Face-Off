/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.awt.Dimension;
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
import projet_inte.Projet_inte;
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
        
        /* ingrédient limonade */
        Ingredient cit = new Ingredient("citron", (float) 0.20);
        Ingredient suc = new Ingredient("sucre", (float) 0.20);
        Ingredient gla = new Ingredient("glace", (float) 0.02);
        Ingredient eau = new Ingredient("eau", (float) 0);
        
        /* Recette de la limonade */
        ArrayList<Ingredient> composition = new ArrayList();
        composition.add(cit);
        composition.add(suc);
        composition.add(gla);
        composition.add(eau);
        composition.add(eau);
        
        Recette limonade = new Recette("limonade", (float)0, (float)0, composition);
        
        /* Création de la prod */
        Prod prod = new Prod("limonade", 40, (float)1.50);
                
        /* Création de la map */
        ArrayList<Client> client = new ArrayList();
        ArrayList<Joueur> joueur = new ArrayList();
        
        Map carte = Map.getInstance(0, 0, 50, 50, joueur, client);
        
        ArrayList<Recette> recette = new ArrayList();
        recette.add(limonade);
        ArrayList<Prod> production = new ArrayList();
        production.add(prod);
        
        carte.createJoueur("player 1", production, recette);
        carte.tailleMap();
        carte.createJoueur("player 2", production, recette);
        carte.tailleMap();
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
        
        
        /* Création de la prod */
        for (int i=0; i<jou.size(); i++){
            jou.get(i).CalculProd();
        }
        
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
        Map carte = Map.getInstance(0, 0, 0, 0, joueur, client);
        
        // Récupère les dimensions de l'écran
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        System.out.println("taille écran:");
        System.out.println(height);
        System.out.println(width);
        
        //Create the StackPane
        StackPane holder = new StackPane();
        // Create the Canvas
        Canvas canvas = new Canvas(width, height);
        

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // création des stand et pub des joueurs
        for (int i=0; i<carte.getJoueur().size(); i++){
            for (int j=0; j<carte.getJoueur().get(i).getEmplacement().size(); j++){
                float x =  ((carte.getJoueur().get(i).getEmplacement().get(j).getLongitude() + carte.getLong_span())  * height)/carte.getLong_span();
                float y =  ((carte.getJoueur().get(i).getEmplacement().get(j).getLattitude() + carte.getLat_span()) * width)/carte.getLat_span();
                float z =  (carte.getJoueur().get(i).getEmplacement().get(j).getInfluence() * width)/carte.getLat_span();
                float z_bis =  (carte.getJoueur().get(i).getEmplacement().get(j).getInfluence() * height)/carte.getLong_span();
                System.out.println( x+" "+y+" "+z+" "+z_bis);
                gc.fillRect(x, y, z, z_bis);
            }
        }
        
        for (int i=0; i<carte.getClient().size(); i++){
            float x =  carte.getClient().get(i).getLongitude() + carte.getLong_span();
            float y =  carte.getClient().get(i).getLattitude() + carte.getLat_span();
            
            gc.setFill(Color.RED);
            gc.fillRect(x, y, 2, 2);
                
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
        // Display the Stage
        stage.show();
    }
    
}
