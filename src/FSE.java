
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
public class FSE implements Serializable {
    private String fseNumber;
    private String fseDescription;
    protected String fseName;
    private String fseAddress;
    private String fseGroup;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private String fseGenre;
    private double price;
    private int calories;
    private ArrayList<Food> theFSEMenu = new ArrayList(); //Because we only really care about the names
    private ArrayList<Food> theFoodList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodList().getListOfFoods();
    
	public FSE(){
		
	}
        
      public FSE(String importFoodString){
        String delimiter = "~";
        String[] tempFSEArray = importFoodString.split(delimiter);
        this.fseName = tempFSEArray[1];
        this.fseAddress = tempFSEArray[3];
        this.theFSEMenu = buildFSEMenu();
    }
    
    public FSE(String newFoodNumber, String newFoodName, String newFoodDescription){
        this.fseNumber = newFoodNumber;
        this.fseName = newFoodName;
        this.fseAddress = fseAddress;
        this.fseGroup = "Fruit";
        this.vegetarian = true;
        this.vegan = true;
        this.glutenFree = true;
        this.fseGenre = "American";
        //this.theFSEMenu = buildFSEMenu();

    }
    
    public ArrayList<Food> buildFSEMenu(){
        for(int i = 0; i < 10; i++){
            int foodNumber = (int)((Math.random() * theFoodList.size()));
            theFSEMenu.add(theFoodList.get(foodNumber));
        }
        return theFSEMenu;
    }
    
    public void setFSEMenu(ArrayList<Food> newFSEMenu){
        theFSEMenu = newFSEMenu;
    }
    
    public void setFSENumber(String newFSENumber){
        fseNumber = newFSENumber;
    }
    
    public void setFSEDescription(String newFSEDescription){
        fseDescription = newFSEDescription;
    }
    
    public void setFSEName(String newFSEName){
        fseName = newFSEName;
    }
    
    public void setFSEAddress(String newFSEAddress){
        fseAddress = newFSEAddress;
    }
    
    public ArrayList<Food> getFSEMenu(){
        return theFSEMenu;
    }
    
    public String getFSENumber(){
        return fseNumber;
    }
    
    public String getFSEName(){
        return fseName;
    }
    
    public String getFSEDescription(){
        return fseAddress;
    }
    
    public String getFSEGroup(){
        return fseGroup;
    }
        
    public boolean getVegetarian(){
        return vegetarian;
    }
    
    public boolean getVegan(){
        return vegan;
    }
    
    public String setFSEDescription(){
        return fseDescription;
    }
        
    public boolean getGlutenFree(){
        return glutenFree;
    }
            
    
    public String getFSEGenre(){
        return fseGenre;
    }
            

    //public  double getSize();
    
    public String toString(){
        return this.fseName;
    }
    
    public boolean equals(Object otherFood){
        return this.toString().equals(otherFood.toString());
    }
    
    public int compareTo(Object otherFood){
        int result = -1;
        Food foodToCompare = (Food) otherFood;
        result = this.fseName.compareTo(foodToCompare.foodName);
        return result;
    }
    
}
