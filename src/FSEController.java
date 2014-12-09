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
    private FoodListView theFSEListUI;
    private FSEDetailView theFSEDetailUI;
    private FoodTableModel theFoodTableModel;
    
    public FSEController(MainMenuController theMainMenuCntl){
        parentMainMenuCntl = theMainMenuCntl;
        showFSEListUI();
    }
    
    public FSETableModel getFoodTableModel(){ // Write this class...wooo!
        if(theFoodTableModel == null){
            theFoodTableModel = new FoodTableModel(this);
        }
        return theFoodTableModel;
    }
    
    public void showFSEDetailUI(int selectedRow, Food theFood){
        theFSEDetailUI = new FSEDetailView(this, selectedRow, theFood); // figure this out
        theFSEDetailUI.setVisible(true);
    }
    
    public void showFSEListUI(){
        theFSEListUI = new FSEListView(this);
        theFSEListUI.setVisible(true);
    }
    
    public Food getFSE(int foodToGet){
        return theFoodTableModel.getFood(foodToGet);
    }
    
    public void addFSE(Food theNewFood){
        theFoodTableModel.addFood(theNewFood);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
   public void changeFSE(int selectedRow, FSE theFSEToChange){
        theFoodTableModel.changeFood(selectedRow, theFSEToChange);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
   
       
    public void deleteFSE(int foodToDelete){
        theFoodTableModel.deleteFood(foodToDelete);// Change to FSETableModel
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
    
    public MainMenuController getMainMenuCntl(){
        return parentMainMenuCntl;
    }
    
}
