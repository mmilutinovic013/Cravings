/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class ReccomendedController {
    
        public ReccomendedController(){
        showReccomendedControllerUI();
    }
    

    public void showReccomendedControllerUI(){
		ReccomendedUI theReccomendedUI = new ReccomendedUI(this);
                theReccomendedUI.setVisible(true); 
	}
}

