/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
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

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                
                Platform.runLater(() -> {
                    try {
                        Fxview view = new Fxview();
                        
                        view.weather = view.com.GetWeather();
                        view.composantCarte = view.com.Getmap();
                        
                        int heure;
                        String current_weather;
                        String next_weather;
                        JSONObject weather= new JSONObject();
                        ArrayList<Joueur> joueur= new ArrayList<Joueur>();

                        ArrayList<Recette> recette= new ArrayList<Recette>();
                        ArrayList<MapItems> Items= new ArrayList<MapItems>();
                        Map carte;


                      for (int i = 0; i < view.composantCarte.getJSONObject("map").getJSONArray("ranking").length(); i++) {
                            for(int j =0; j < view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).length();j++){

                               Items.add(new MapItems(view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("kind"),view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("owner"),view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getJSONObject("location").getDouble("longitude"),view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getJSONObject("location").getDouble("latitude"),view.composantCarte.getJSONObject("map").getJSONObject("itemsByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getDouble("influence")));

                               //if(composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i))!=null){
                                        recette.add(new Recette( view.composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getString("name")  ,  view.composantCarte.getJSONObject("map").getJSONObject("drinksByPlayer").getJSONArray(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getJSONObject(j).getDouble("price")  ) );
                                 //}
                                         }
                            joueur.add(new Joueur(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i),view.composantCarte.getJSONObject("map").getJSONObject("playerInfo").getJSONObject(view.composantCarte.getJSONObject("map").getJSONArray("ranking").getString(i)).getDouble("cash"),recette,Items));
                       }

                       carte = new Map(view.composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("center").getDouble("longitude"),view.composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("center").getDouble("latitude"),view.composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("span").getDouble("longitudeSpan"),view.composantCarte.getJSONObject("map").getJSONObject("region").getJSONObject("span").getDouble("latitudeSpan"),joueur);

                        carte.setCurrent_weather(view.weather.getJSONArray("weather").getJSONObject(0).getString("weather"));
                        carte.setCurrent_weather(view.weather.getJSONArray("weather").getJSONObject(1).getString("weather"));
                        System.out.println(view.weather.getJSONArray("weather").getJSONObject(0).getString("weather"));
                        System.out.println(view.weather.getJSONArray("weather").getJSONObject(1).getString("weather"));
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
                        carte.movement();
                    } catch (Exception ex) {
                        Logger.getLogger(Fxview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }, 0, 3000);
    }

    }

    /**
     * @param args the command line arguments
     */
 
    

