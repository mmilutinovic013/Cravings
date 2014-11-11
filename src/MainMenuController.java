/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class MainMenuController {
    
    
    
    public MainMenuController(){
        this.showMenu();
    }
    
    public void showMenu(){
        MainMenuView theMainMenu = new MainMenuView(this);
        theMainMenu.setVisible(true);
        
    }
    
}
