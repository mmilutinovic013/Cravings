/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class SearchController {
    
    public SearchController(){
        showSearchUI();
    }
    
    public void showSearchUI(){
      SearchUI theSearchUI = new SearchUI(this);
      theSearchUI.setVisible(true);
      
    }
}
