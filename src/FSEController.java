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
    private FoodListView theFoodListUI;
    private FoodDetailView theFoodDetailUI;
    private FoodTableModel theFoodTableModel;
    
    public FSEController(MainMenuController theMainMenuCntl){
        parentMainMenuCntl = theMainMenuCntl;
        showFSEListUI();
    }
    
    public FSETableModel getFoodTableModel(){
        if(theFoodTableModel == null){
            theFoodTableModel = new FoodTableModel(this);
        }
        return theFoodTableModel;
    }
    
    public void showFSEDetailUI(int selectedRow, Food theFood){
        theFoodDetailUI = new FoodDetailView(this, selectedRow, theFood);
        theFoodDetailUI.setVisible(true);
    }
    
    public void showFSEListUI(){
        theFoodListUI = new FoodListView(this);
        theFoodListUI.setVisible(true);
    }
    
    public Food getFSE(int foodToGet){
        return theFoodTableModel.getFood(foodToGet);
    }
    
    public void addFSE(Food theNewFood){
        theFoodTableModel.addFood(theNewFood);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
   public void changeFSE(int selectedRow, Food theFoodToChange){
        theFoodTableModel.changeFood(selectedRow, theFoodToChange);
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
