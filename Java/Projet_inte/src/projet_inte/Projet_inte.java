/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_inte;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Théo
 */
public class Projet_inte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
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
        Prod production = new Prod("limonade", 40, (float)1.50);
                
        /* Création de la map */
        ArrayList<Client> client = new ArrayList();
        
        Map carte = new Map((float)0, (float)0, (float)0, (float)0, );
    }
    
}
