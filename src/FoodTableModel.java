/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;

/**
 *
 * @author SHaynes
 */
public class FoodTableModel extends AbstractTableModel{
    private FoodController theFoodController;
    private static String[] columnNames = {"ID", "Name", "Description"};
    private ArrayList<Food> foodTableData;
    
    private int nextFoodNumber;

    public FoodTableModel(FoodController parentFoodCntl){
        //buildTestFoodTable(10000);
        foodTableData = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodList().getListOfFoods();
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return foodTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        switch(col){
            case 0: objectToReturn = foodTableData.get(row).getFoodID();break;
            case 1: objectToReturn = foodTableData.get(row).getFoodName();break;
            case 2: objectToReturn = foodTableData.get(row).getFoodDescription();break;
        }
        return objectToReturn;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Food that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setFoodTableData(ArrayList<Food> theFoodTableData){
        foodTableData = theFoodTableData;
    }
    
    public ArrayList<Food> getFoodTableData(){
        return this.foodTableData;
    }
    
    /*
    public void buildTestFoodTable(int count){
        for(int i = 0; i < count; i++){
            //EssayFood newFood = new EssayFood(getNextFoodNumber(), Integer.parseInt(SwagDate.getSwagDate()), "Test Food "+i, "Test note "+i+" blah blah blah");
            Food newFood = new Food(1000, "Test"+i, "Test"+i+" Description");
            foodTableData.add(newFood);
        }
    }
    */
    public void changeFood(int selectedFood, Food theFoodToChange){
        foodTableData.set(selectedFood, theFoodToChange);
        this.fireTableDataChanged();
    }
    
    public Food getFood(int foodToGet){
        return foodTableData.get(foodToGet);
    }
    
    public void addFood(Food foodToAdd){
        this.foodTableData.add(foodToAdd);
        this.fireTableDataChanged(); // This is what updates it
    }
    
    public void deleteFood(int foodToDelete){
        this.foodTableData.remove(foodToDelete);
        this.fireTableRowsDeleted(foodToDelete, foodToDelete);
    }
    
    public  int getNextFoodNumber(){
        if(nextFoodNumber == 0)nextFoodNumber = 1; //Start numbering at 1 rather than 0.
        int numberToReturn = nextFoodNumber;
        nextFoodNumber++;
        return numberToReturn;
    }
 
    /*
     * Don't need to implement this method unless your table's
     * data can change.
     
    public void setValueAt(Object value, int row, int col) {
        this[row][col] = value;
        fireTableCellUpdated(row, col);
    }
      */
   
   
    
}
