/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class CreateFoodController {
    
    public CreateFoodController(){
        this.showMenu();
    }
    
    public void showMenu(){
        CreateFoodView theCreateFoodView = new CreateFoodView(this);
        theCreateFoodView.setVisible(true);
    }
}


