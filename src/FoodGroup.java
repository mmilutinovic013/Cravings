/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author SHaynes
 */
public class FoodGroup implements Serializable{
    
    private String foodGroupCode;
    private String foodGroupDesc;
    
    // This constructor takes a string representing one line in the import file
    // and converts it to a FoodGroup object.
    public FoodGroup(String importString){
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        foodGroupCode = tokens[1]; // From the file format at the FDA site position 1 is the code.
        foodGroupDesc = tokens[3]; // From the file format at the FDA site position 3 is the description.
    }
    
    public String getFoodGroupDesc(){
        return foodGroupDesc;
    }
}
