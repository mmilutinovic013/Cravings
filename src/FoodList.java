/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;

public class FoodList implements Serializable{
    
    private ArrayList<Food> theListOfFoods = new ArrayList();
    
    public FoodList(){
     
    }
    public ArrayList<Food> getListOfFoods(){
        return theListOfFoods;
    }   
}
