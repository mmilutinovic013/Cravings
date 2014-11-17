
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHaynes
 */
public class SerializedDataModel implements Serializable {
    
    private UserList theUserList;
    private FoodList theFoodList;
    private FoodGroupList theFoodGroupList; // unsure what is happening with this atm
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
    
    public void setFoodList(FoodList newFoodList){
        theFoodList = newFoodList;
    }
    
    public FoodList getFoodList(){
        if(theFoodList == null){
            theFoodList = new FoodList();
        }
        return theFoodList;
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    
    public void setFoodGroupList(FoodGroupList newFoodGroupList){
        theFoodGroupList = newFoodGroupList;
    }
    
    public FoodGroupList getFoodGroupList(){
        if(theFoodGroupList == null){
            theFoodGroupList = new FoodGroupList();
        }
        return theFoodGroupList;
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
