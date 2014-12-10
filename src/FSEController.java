
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FSEController {
    private MainMenuController parentMainMenuCntl;
    private FSEListView theFSEListUI;
    private FSEDetailView theFSEDetailUI;
    private FSETableModel theFSETableModel;
    
    public FSEController(MainMenuController theMainMenuCntl){
        parentMainMenuCntl = theMainMenuCntl;
        showFSEListUI();
    }
    
    public FSETableModel getFSETableModel(){ // Write this class...wooo!
        if(theFSETableModel == null){
            theFSETableModel = new FSETableModel(this);
        }
        return theFSETableModel;
    }
    
    public void showFSEDetailUI(int selectedRow, FSE theFSE){
        theFSEDetailUI = new FSEDetailView(this, selectedRow, theFSE); // figure this out
        theFSEDetailUI.setVisible(true);
    }
    
    public void showFSEListUI(){
        theFSEListUI = new FSEListView(this);
        theFSEListUI.setVisible(true);
    }
    
    public FSE getFSE(int fseToGet){
        return theFSETableModel.getFSE(fseToGet);
    }
    
    public void addFSE(FSE theNewFSE){
        theFSETableModel.addFSE(theNewFSE); // add the FSE Table Model
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
   public void changeFSE(int selectedRow, FSE theFSEToChange){
        theFSETableModel.changeFSE(selectedRow, theFSEToChange); // change to FSE table model
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
   
       
    public void deleteFSE(int fseToDelete){
        theFSETableModel.deleteFSE(fseToDelete);// Change to FSETableModel
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
    
    public MainMenuController getMainMenuCntl(){
        return parentMainMenuCntl;
    }
    
}
