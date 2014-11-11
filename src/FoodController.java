/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodController {
    
    Food theFood = new Food();
    
    public FoodController(Food theFood2){
        theFood = theFood2;
    }
    public Food getListOfFoods(){
        return theFood;
    }
    
}
