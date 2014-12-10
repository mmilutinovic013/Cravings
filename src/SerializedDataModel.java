
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @code reference from author SHaynes by Mark Milutinovic
 */
public class SerializedDataModel implements Serializable {
    
    private UserList theUserList;
    private FoodList theFoodList;
    private FoodGroupList theFoodGroupList;
    private FSEList theFSEList;
    private ArrayList<Food> theFSEMenu = new ArrayList();
    private long nextFoodNumber;
    private long nextFSENumber;
    
    
    public SerializedDataModel(){
       if(nextFoodNumber == 0){
           nextFoodNumber = 1000;
       }
       if(theFoodList == null){
           //createTestSerializedDataModel();
           theFoodList = new FoodList(); 
       } 
       if(theFoodGroupList == null){
           //createTestSerializedDataModel();
           theFoodGroupList = new FoodGroupList(); 
       } 
       if(theFSEList == null){
           theFSEList = new FSEList();
       }
    }
    
    public long getNextFoodNumber(){
        nextFoodNumber = nextFoodNumber + 1;
        return nextFoodNumber;
    }
    
    public long getNextFSENumber(){
        nextFSENumber = nextFSENumber + 1;
        return nextFSENumber;
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public FoodList getFoodList(){
        return theFoodList;
    }
    
    public void setFoodGroupList(FoodGroupList newFoodGroupList){
        theFoodGroupList = newFoodGroupList;
    }
    
    public FSEList getFSEList(){
        return theFSEList;
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
                Food tmpFood = new Food(String.valueOf(i), "Test"+i, "Test"+i+" Description");
                theFoodList.getListOfFoods().add(tmpFood);
            }
        }
    }    
   
}
