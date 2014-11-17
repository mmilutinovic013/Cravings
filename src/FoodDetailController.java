/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodDetailController {
    
    public FoodDetailController(){
        this.showMenu();
    }
    
    public void showMenu(){
        FoodDetailView theFoodDetailView = new FoodDetailView(this);
        theFoodDetailView.setVisible(true);
    }
}
