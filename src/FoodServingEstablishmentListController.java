/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodServingEstablishmentListController {
    
    public FoodServingEstablishmentListController(){
        this.showMenu();
    }
    
    public void showMenu(){
        FoodServingEstablishmentListView theFoodServingEstablishmentListView = new FoodServingEstablishmentListView(this);
        theFoodServingEstablishmentListView.setVisible(true);
        
    }
    
}
