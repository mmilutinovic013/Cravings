/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodController {
    
    private MainMenuController parentMainMenuCntl;
    private FoodListView theFoodListUI;
    private FoodDetailView theFoodDetailUI;
    private FoodTableModel theFoodTableModel;
    
    public FoodController(MainMenuController theMainMenuCntl){
        parentMainMenuCntl = theMainMenuCntl;
        showFoodListUI();
    }
    
    public FoodTableModel getFoodTableModel(){
        if(theFoodTableModel == null){
            theFoodTableModel = new FoodTableModel(this);
        }
        return theFoodTableModel;
    }
    
    public void showFoodDetailUI(int selectedRow, Food theFood){
        theFoodDetailUI = new FoodDetailView(this, selectedRow, theFood);
        theFoodDetailUI.setVisible(true);
    }
    
    public void showFoodListUI(){
        theFoodListUI = new FoodListView(this);
        theFoodListUI.setVisible(true);
    }
    
    public Food getFood(int foodToGet){
        return theFoodTableModel.getFood(foodToGet);
    }
    
    public void addFood(Food theNewFood){
        theFoodTableModel.addFood(theNewFood);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
   public void changeFood(int selectedRow, Food theFoodToChange){
        theFoodTableModel.changeFood(selectedRow, theFoodToChange);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
   
       
    public void deleteFood(int foodToDelete){
        theFoodTableModel.deleteFood(foodToDelete);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
    }
    
    
    public MainMenuController getMainMenuCntl(){
        return parentMainMenuCntl;
    }
}
