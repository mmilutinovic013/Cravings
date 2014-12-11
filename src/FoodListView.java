
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @code referenced from author SHaynes
 */
public class FoodListView extends JFrame{
        
    FoodController parentFoodCntl;
    JPanel buttonPanel;
    JPanel tablePanel;
    JTable theFoodTable;
    JScrollPane theScrollPane;
    JButton backButton;
    JButton deleteButton;
    JButton editButton;
    JButton newButton;
    JButton addToMenuButton;
    ArrayList<FSE> fseTableData = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFSEList().getListOfFSE();
    
    TableRowSorter<TableModel> foodTableSorter;
    
    JPanel filterPanel;
    JButton searchButton;
    JLabel filterLabel;
    JComboBox filterFieldList;

    
    public FoodListView(FoodController theFoodCntl){
        parentFoodCntl = theFoodCntl;
        this.initCustomComponents();
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Foods List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initCustomComponents(){
        buttonPanel = new JPanel();
        tablePanel = new JPanel();
        filterPanel = new JPanel();
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        newButton = new JButton("New");
        newButton.addActionListener(new NewButtonListener());
        editButton = new JButton("Edit");
        editButton.addActionListener(new EditButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new AddToMenuButtonListener());
        addToMenuButton = new JButton("Add To Menu");
        addToMenuButton.addActionListener(new AddToMenuButtonListener());

        //Table initialization
        theFoodTable = new JTable(parentFoodCntl.getFoodTableModel());
        
        //This fixes the unserializable inner class but need to implement a cleaner solution.
        //theFoodCntl.getFoodTableModel().addTableModelListener(new KludgeTableModelListener());
        
        theFoodTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        theFoodTable.getColumnModel().getColumn(1).setPreferredWidth(50);
 
        //Put everything together
        theScrollPane = new JScrollPane(theFoodTable);
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setPreferredSize(new Dimension(350,400));
        theFoodTable.setFillsViewportHeight(true);
        
        //Food table sorter
        foodTableSorter = new TableRowSorter<TableModel>(theFoodTable.getModel());
        theFoodTable.setRowSorter(foodTableSorter);
        
        tablePanel.add(theScrollPane);  
        
        // Food table filter (search)
        filterLabel = new JLabel("Search (Filter)");

        
        //Need to initialize the JComboBox after the table to get the columns.
        ArrayList<String> columnNames = new ArrayList();
        for(int i = 0; i < fseTableData.size(); i++){
            columnNames.add(fseTableData.get(i).getFSEName());
        }
       
        filterFieldList = new JComboBox(columnNames.toArray());      
        
        filterPanel.add(filterFieldList);
        filterPanel.add(filterLabel);
        
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(newButton);
        buttonPanel.add(addToMenuButton);


        
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(filterPanel, BorderLayout.SOUTH);
    } 
    
   public class EditButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFoodTable.getSelectedRow();
            int selectedModelRow = theFoodTable.convertRowIndexToModel(selectedTableRow);
            Food selectedFood = FoodListView.this.parentFoodCntl.getFood(selectedModelRow);
            FoodListView.this.setVisible(false);
            FoodListView.this.parentFoodCntl.showFoodDetailUI(selectedModelRow, selectedFood);
        }
    }
   
    
    public class NewButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){     
            //Food tmpFood = new Food(99999, "Test Create Food", "Test Create Food Description");
            //FoodListUI.this.parentFoodCntl.getFoodTableModel().addFood(tmpFood);
            FoodListView.this.setVisible(false);
            FoodListView.this.parentFoodCntl.showFoodDetailUI(-1, null);
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFoodTable.getSelectedRow();
            int selectedModelRow = theFoodTable.convertRowIndexToModel(selectedTableRow);
            FoodListView.this.parentFoodCntl.deleteFood(selectedModelRow);
        }
    }
    
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){        
            FoodListView.this.dispose();
            FoodListView.this.setVisible(false);
            FoodListView.this.parentFoodCntl.getMainMenuCntl().showMenu();
        }
    }
    
    public class AddToMenuButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){ 
            // Get the Food 
            int selectedTableRow = theFoodTable.getSelectedRow();
            int selectedModelRow = theFoodTable.convertRowIndexToModel(selectedTableRow);
            Food selectedFood = FoodListView.this.parentFoodCntl.getFood(selectedModelRow);
            // Get Value in Dropdown Menu
            int fseToAddToIndex = FoodListView.this.filterFieldList.getSelectedIndex();
            fseTableData.get(fseToAddToIndex).getFSEMenu().add(selectedFood);
            FoodListView.this.dispose();
            FoodListView.this.setVisible(false);
            FoodListView.this.parentFoodCntl.getMainMenuCntl().showMenu();
        }
    }

    
    
   /**
   * This is from https://forums.oracle.com/thread/2131409
   * SRH 11/19/2013
   * This class is created only for the purpose of assisting with the 
   * serialization of Java Swing components.  It turns out that the JTable
   * class occasionally instantiates an inner class which is not serializable.
   * This code gets around that problem.
   */
  private class KludgeTableModelListener implements TableModelListener
  {

    /**
     * This method sets that inner class (private member editorRemover) to null 
     * by calling removeNotify() but then still allows you to edit the table by 
     * calling addNotify(), which, interestingly, does not instantiate 
     * editorRemover again.  This may have side effects of which I am unaware.
     */
    public void tableChanged(TableModelEvent e)
    {
      FoodListView.this.theFoodTable.removeNotify();
      FoodListView.this.theFoodTable.addNotify();
    }
  }
    
    
}