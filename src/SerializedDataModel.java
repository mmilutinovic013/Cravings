/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHaynes
 */
public class SerializedDataModel {
    
    private UserList theUserList;
    private FoodList theFoodList;
    private long nextFoodNumber;
    
    
    public SerializedDataModel(){
       if(nextFoodNumber == 0){
           nextFoodNumber = 1000;
       }
       if(theFoodList == null){
           createTestSerializedDataModel();
       } 
    }
    
    public long getNextFoodNumber(){
        nextFoodNumber = nextFoodNumber + 1;
        return nextFoodNumber;
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public FoodList getFoodList(){
        return theFoodList;
    }
    
    private void createTestSerializedDataModel(){
        if(theFoodList == null){
            theFoodList = new FoodList();
            for(int i = 0; i < 100; i++){
                Food tmpFood = new Food(i, "Test"+i, "Test"+i+" Description");
                theFoodList.getListOfFoods().add(tmpFood);
            }
        }
    }
    
}
