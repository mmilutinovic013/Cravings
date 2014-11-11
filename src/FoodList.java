/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class FoodList {
    private static ArrayList<Food> theListOfFoods = new ArrayList();
    
    public FoodList(){
        for (int i = 0; i < 100; i++) {
            // load Foods (from serialized stuffs)?
        }
    }
    
    public static ArrayList<Food> getListOfFoods(){
        return theListOfFoods;
    }
}
