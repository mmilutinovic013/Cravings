
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FSEList implements Serializable {
    
    private ArrayList<FSE> theFSEList = new ArrayList();
    private ArrayList<Food>theFSEMenu = new ArrayList();
    
    public FSEList(){
     
    }
    public ArrayList<FSE> getListOfFSE(){
        return theFSEList;
    } 
    public ArrayList<Food> buildFSEMenu(){
        for(int i = 0; i < 10; i++){
            int foodNumber = (int)(Math.random() * theFSEMenu.size());
            theFSEMenu.add(theFoodList.get(foodNumber));
        }
        return theFSEMenu;
    }
    
}
