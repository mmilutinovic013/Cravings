/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class RecentSelectionsController {
   
    public RecentSelectionsController(){
        this.showRecentSelectionsUI();
    }
    

    public void showRecentSelectionsUI(){
		RecentSelectionsUI theRecentSelectionsUI = new RecentSelectionsUI(this);
                theRecentSelectionsUI.setVisible(true); 
	}
}
