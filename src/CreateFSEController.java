/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class CreateFSEController {
    
    public CreateFSEController(){
        this.showMenu();
    }
    
    public void showMenu(){
        CreateFSEView theCreateFSEView = new CreateFSEView(this);
        theCreateFSEView.setVisible(true);
    }
}


