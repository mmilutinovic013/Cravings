
public class Food {
	
        protected String foodNumber;
        protected String foodGroup;
	protected String foodName;
	private double price;
	private String foodID;
        private String foodDescription;
	
	public Food(){
		
	}
        
      public Food(String importString){
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        foodID = tokens[1].toString(); // From the file format at the FDA site position 1 is the code.        
        foodGroup = tokens[3]; // From the file format at the FDA site position 3 is the food group.
        foodDescription = tokens[5]; // From the file format at the FDA site position 7 is the description. 
    }
        
        public Food(int newFoodNumber, String newFoodName, String newDescription){
		this.foodName = newFoodName;
	}
	
	public String toString(){
		return this.foodName;
	}
	
	public boolean equals(Object otherFood){
		return this.toString().equals(otherFood.toString());
		
	}
	
	public String getFoodName(){
		return foodName;
	}
        
        public String getFoodID(){
            return foodID;
        }
        
        public String getFoodDescription(){
            return foodDescription;
        }
        
        public String getFoodGroup(){
            return foodGroup;
        }
        
        
	
	//public abstract double getSize(); //basically all subclasses have this method defined in it.

}
