/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FSE {
        private String fseNumber;
    protected String fseName;
    private String fseDescription;
    private String fseGroup;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private String fseGenre;
    private double price;
    private int calories;
	
	public FSE(){
		
	}
        
      public FSE(String importFoodString){
        String delimiter = "~";
        String[] tempFoodArray = importFoodString.split(delimiter);
        this.fseNumber = tempFoodArray[1];
        this.fseGroup = tempFoodArray[3];
        this.fseDescription = tempFoodArray[7];
        this.fseName = tempFoodArray[5];
    }
    
    public FSE(String newFoodNumber, String newFoodName, String newFoodDescription){
        this.fseNumber = newFoodNumber;
        this.fseName = newFoodName;
        this.fseDescription = newFoodDescription;
        this.fseGroup = "Fruit";
        this.vegetarian = true;
        this.vegan = true;
        this.glutenFree = true;
        this.fseGenre = "American";
    }
    
    public void setFSENumber(String newFoodNumber){
        fseNumber = newFoodNumber;
    }
    
    public void setFSEName(String newFoodName){
        fseName = newFoodName;
    }
    
    public void setFSEDescription(String newFoodDescription){
        fseDescription = newFoodDescription;
    }
    
    
    public String getFSENumber(){
        return fseNumber;
    }
    
    public String getFSEName(){
        return fseName;
    }
    
    public String getFSEDescription(){
        return fseDescription;
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
        
    public boolean getGlutenFree(){
        return glutenFree;
    }
            
    
    public String getFoodGenre(){
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
