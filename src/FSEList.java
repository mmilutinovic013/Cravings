
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
    
    public FSEList(){
     
    }
    public ArrayList<FSE> getListOfFSE(){
        return theFSEList;
    } 
    
}
