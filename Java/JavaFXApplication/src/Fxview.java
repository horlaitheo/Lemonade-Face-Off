/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javax.swing.JPanel;
import org.json.JSONObject;
import projet_inte.*;

/**
 *
 * @author imerir
 */
public class Fxview extends Application {
    
        Communication com =new Communication();
        JSONObject composantCarte= new JSONObject();
        int heure;
        JSONObject weather= new JSONObject();
       
       public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
      
        weather = com.GetWeather();
        composantCarte = com.Getmap();
         
        int heure;
        String current_weather;
        String next_weather;
        JSONObject weather= new JSONObject();
        ArrayList<Joueur> joueur= new ArrayList<Joueur>();
      
        ArrayList<Recette> recette= new ArrayList<Recette>();
        ArrayList<MapItems> Items= new ArrayList<MapItems>();
        Map carte;
        
        
      for (int i = 0; i < composantCarte.getJSONObject("map").getJSONArray("ranking").length(); i++) {
            for(int j =0; j < composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).length();j++){
                  
               Items.add(new MapItems(composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("kind"),composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("owner"),composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getJSONObject("location").getDouble("longitude"),composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getJSONObject("location").getDouble("latitude"),composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getDouble("influence")));
                
               //if(composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i))!=null){
                        recette.add(new Recette( composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("name")  ,  composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getDouble("price")  ) );
                 //}
                         }
            joueur.add(new Joueur(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i),composantCarte.getJSONObject("map").getJSONObject("playerInfo").getJSONObject(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getDouble("cash"),recette,Items));
       }
       
       carte = new Map(composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("center").getDouble("longitude"),composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("center").getDouble("latitude"),composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("span").getDouble("longitudeSpan"),composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("span").getDouble("latitudeSpan"),joueur);
        
        
        
      carte.NombreClient();
     
       
        
        StackPane root = new StackPane();
        
        BorderPane temps =new BorderPane();
   //     Canvas canvas =new Canvas(carte.getLong_span(),200);
        Canvas canvasB = new Canvas(carte.getLong_span(),carte.getLat_span());
      
        //System.out.println(carte.getLong_span()+""+carte.getLat_span());
        
      
        GraphicsContext gb = canvasB.getGraphicsContext2D();
       //  GraphicsContext time = canvas.getGraphicsContext2D();
        gb.setFill(Color.RED);
       for(int i=0; i<carte.getJoueur().size();i++)
        {for(int j=0;j<carte.getJoueur().get(i).getItems().size();j++){
         gb.fillRect(carte.getJoueur().get(i).getItems().get(j).getLongitude(), carte.getJoueur().get(i).getItems().get(j).getLatitude(), 10, 10);
                    System.out.println(carte.getJoueur().get(i).getItems().get(j).getLongitude()+" "+ carte.getJoueur().get(i).getItems().get(j).getLatitude());
        }
        }
       gb.setFill(Color.BLUE);
       for(int i=0; i<carte.getClient().size();i++){
         gb.fillRect(carte.getClient().get(i).getLongitude(),carte.getClient().get(i).getLatitude(), 5, 5);
                    System.out.println(carte.getClient().get(i).getLongitude()+" "+carte.getClient().get(i).getLatitude());
        
        }
       gb.fillRect(500, 500, 10, 10);
     
      
       
       
      //  System.out.println(weather.getJSONArray("weather").getJSONObject(0).getString("weather"));
       
        root.getChildren().addAll(/*canvas,*/canvasB);
        
        
        
        primaryStage.setTitle("visuel");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                
            }
        }, 0, 3000);
    }

    }

    /**
     * @param args the command line arguments
     */
 
    

