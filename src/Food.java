
public class Food {
	
	protected String foodName;
	private double price;
	private int calories;
	
	public Food(){
		
	}
	
	public Food(String newFoodName){
		this.foodName = newFoodName;
	}
        
        public Food(int num, String newFoodName, String newDescription){
		this.foodName = newFoodName;
	}
	
	public String toString(){
		return this.foodName;
	}
	
	public boolean equals(Object otherFood){
		return this.toString().equals(otherFood.toString());
		
	}
	
	public String getName(){
		return foodName;
	}
	
	//public abstract double getSize(); //basically all subclasses have this method defined in it.

}
