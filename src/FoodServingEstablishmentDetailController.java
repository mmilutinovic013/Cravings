/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodServingEstablishmentDetailController {
    
    public FoodServingEstablishmentDetailController(){
        this.showMenu();
    }
    
    public void showMenu(){
        FoodServingEstablishmentDetailView theFoodServingEstablishmentDetailView = new FoodServingEstablishmentDetailView(this);
        theFoodServingEstablishmentDetailView.setVisible(true);
    }
    
}
