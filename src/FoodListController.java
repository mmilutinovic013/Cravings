/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodListController {
    
    public FoodListController(){
        this.showList();
    }
    
    public void showList(){
        FoodListView theFoodListView = new FoodListView(this);
        theFoodListView.setVisible(true);
    }
    
}
