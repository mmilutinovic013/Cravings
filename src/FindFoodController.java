/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FindFoodController {
    
    public FindFoodController(){
        this.showFindFoodUI();
    }
    
    public void showFindFoodUI(){
      FindFoodView theFindFoodView = new FindFoodView(this);
      theFindFoodView.setVisible(true);
      
    }
    
}
