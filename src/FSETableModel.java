
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FSETableModel extends AbstractTableModel {
    private FSEController theFSEController; // do I need? 
    private static String[] columnNames = {"ID", "Name", "Description"};
    private ArrayList<FSE> fseTableData;
    
    private int nextFSENumber;

    public FSETableModel(FSEController parentFSECntl){
        //buildTestFoodTable(10000);
        fseTableData = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFSEList().getListOfFSE();
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return fseTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        switch(col){
            case 0: objectToReturn = fseTableData.get(row).getFSEName();break;
            case 1: objectToReturn = fseTableData.get(row).getFSEDescription();break;
            case 2: objectToReturn = fseTableData.get(row).getFSEDescription();break;
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
        //FSE that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setfseTableData(ArrayList<FSE> thefseTableData){
        fseTableData = thefseTableData;
    }
    
    public ArrayList<FSE> getfseTableData(){
        return this.fseTableData;
    }
    
    /*
    public void buildTestFoodTable(int count){
        for(int i = 0; i < count; i++){
            //EssayFood newFood = new EssayFood(getNextFoodNumber(), Integer.parseInt(SwagDate.getSwagDate()), "Test Food "+i, "Test note "+i+" blah blah blah");
            Food newFood = new Food(1000, "Test"+i, "Test"+i+" Description");
            fseTableData.add(newFood);
        }
    }
    */
    public void changeFSE(int selectedFSE, FSE theFSEToChange){
        fseTableData.set(selectedFSE, theFSEToChange);
        this.fireTableDataChanged(); // figure out why lolololololololololol
    }
    
    public FSE getFSE(int fseToGet){
        return fseTableData.get(fseToGet);
    }
    
    public void addFSE(FSE fseToAdd){
        this.fseTableData.add(fseToAdd);
        this.fireTableDataChanged(); // This is what updates it
    }
    
    public void deleteFSE(int fseToDelete){
        this.fseTableData.remove(fseToDelete);
        this.fireTableRowsDeleted(fseToDelete, fseToDelete);
    }
    
    public  int getNextFSENumber(){
        if(nextFSENumber == 0)nextFSENumber = 1; //Start numbering at 1 rather than 0.
        int numberToReturn = nextFSENumber;
        nextFSENumber++;
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
