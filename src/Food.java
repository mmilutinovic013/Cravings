
public class Food {
	
        protected int foodNumber;
	protected String foodName;
	private double price;
	private int foodID;
        private String foodDescription;
	
	public Food(){
		
	}
	
	public Food(String newFoodName){
		this.foodName = newFoodName;
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
        
        public int getFoodID(){
            return foodID;
        }
        
        public String getFoodDescription(){
            return foodDescription;
        }
        
        
	
	//public abstract double getSize(); //basically all subclasses have this method defined in it.

}
