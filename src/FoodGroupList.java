/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author SHaynes
 */
public class FoodGroupList implements Serializable{
    
    private ArrayList<FoodGroup> theFoodGroupList;
    
    public FoodGroupList(){
        theFoodGroupList = new ArrayList<FoodGroup>();
    }
    
    public ArrayList<FoodGroup> getListOfFoodGroups(){
        return theFoodGroupList;
    }
    
    public void setListOfFoodGroups(ArrayList<FoodGroup> theNewFoodGroupList){
        theFoodGroupList = theNewFoodGroupList;
    }
       
}
