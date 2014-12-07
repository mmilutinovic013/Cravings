
import java.io.Serializable;


public class Food implements Serializable{
	
    private String foodNumber;
    protected String foodName;
    private String foodDescription;
    private String foodGroup;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private String foodGenre;
    private double price;
    private int calories;
	
	public Food(){
		
	}
        
      public Food(String importFoodString){
        String delimiter = "~";
        String[] tempFoodArray = importFoodString.split(delimiter);
        this.foodNumber = tempFoodArray[1];
        this.foodGroup = tempFoodArray[3];
        this.foodDescription = tempFoodArray[7];
        this.foodName = tempFoodArray[5];
    }
    
    public Food(String newFoodNumber, String newFoodName, String newFoodDescription){
        this.foodNumber = newFoodNumber;
        this.foodName = newFoodName;
        this.foodDescription = newFoodDescription;
        this.foodGroup = "Fruit";
        this.vegetarian = true;
        this.vegan = true;
        this.glutenFree = true;
        this.foodGenre = "American";
    }
    
    public void setFoodNumber(String newFoodNumber){
        foodNumber = newFoodNumber;
    }
    
    public void setFoodName(String newFoodName){
        foodName = newFoodName;
    }
    
    public void setFoodDescription(String newFoodDescription){
        foodDescription = newFoodDescription;
    }
    
    
    public String getFoodNumber(){
        return foodNumber;
    }
    
    public String getFoodName(){
        return foodName;
    }
    
    public String getFoodDescription(){
        return foodDescription;
    }
    
    public String getFoodGroup(){
        return foodGroup;
    }
        
    public boolean getVegetarian(){
        return vegetarian;
    }
    
    public boolean getVegan(){
        return vegan;
    }
        
    public boolean getGlutenFree(){
        return glutenFree;
    }
            
    
    public String getFoodGenre(){
        return foodGenre;
    }
            

    //public  double getSize();
    
    public String toString(){
        return this.foodName;
    }
    
    public boolean equals(Object otherFood){
        return this.toString().equals(otherFood.toString());
    }
    
    public int compareTo(Object otherFood){
        int result = -1;
        Food foodToCompare = (Food) otherFood;
        result = this.foodName.compareTo(foodToCompare.foodName);
        return result;
    }

}
