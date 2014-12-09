
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodServingEstablishmentListView extends JFrame {
    
    FoodController parentFoodCntl;
    JPanel buttonPanel;
    JPanel tablePanel;
    JTable theFoodTable;
    JScrollPane theScrollPane;
    JButton backButton;
    JButton deleteButton;
    JButton editButton;
    JButton newButton;
    
    TableRowSorter<TableModel> foodTableSorter;
    
    JPanel filterPanel;
    JButton searchButton;
    JLabel filterLabel;
    JTextField filterTextField;
    JComboBox filterFieldList;

    
    public FoodServingEstablishmentListView(FoodController theFoodCntl){
        parentFoodCntl = theFoodCntl;
        this.initCustomComponents();
        this.setSize(400, 600);
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
        backButton.addActionListener(new FoodServingEstablishmentListView.BackButtonListener());
        newButton = new JButton("New");
        newButton.addActionListener(new FoodServingEstablishmentListView.NewButtonListener());
        editButton = new JButton("Edit");
        editButton.addActionListener(new FoodServingEstablishmentListView.EditButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new FoodServingEstablishmentListView.DeleteButtonListener());

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
        filterTextField = new JTextField(15);
        filterTextField.addActionListener(new FoodServingEstablishmentListView.FilterTextFieldListener());
        
        //Need to initialize the JComboBox after the table to get the columns.
        String[] columnNames = new String[theFoodTable.getModel().getColumnCount()];
        for(int i = 0; i < columnNames.length; i++){
            columnNames[i] = theFoodTable.getModel().getColumnName(i);
        }
        filterFieldList = new JComboBox(columnNames);      
        
        filterPanel.add(filterFieldList);
        filterPanel.add(filterLabel);
        filterPanel.add(filterTextField);
        
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(newButton);

        
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(filterPanel, BorderLayout.SOUTH);
    }
    
        // More or less straight out of the Oracle JTable tutorial
    public class FilterTextFieldListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){        
            RowFilter<TableModel, Object> rowFilter = null;
            try {
                rowFilter = RowFilter.regexFilter(filterTextField.getText(), filterFieldList.getSelectedIndex());
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
            FoodServingEstablishmentListView.this.foodTableSorter.setRowFilter(rowFilter);
        }
    }
    
    
   public class EditButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFoodTable.getSelectedRow();
            int selectedModelRow = theFoodTable.convertRowIndexToModel(selectedTableRow);
            FSE selectedFSE = FoodServingEstablishmentListView.this.parentFoodCntl.getFood(selectedModelRow);
            FoodServingEstablishmentListView.this.setVisible(false);
            FoodServingEstablishmentListView.this.parentFoodCntl.showFoodDetailUI(selectedModelRow, selectedFood);
        }
    }
   
    
    public class NewButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){     
            //Food tmpFood = new Food(99999, "Test Create Food", "Test Create Food Description");
            //FoodListUI.this.parentFoodCntl.getFoodTableModel().addFood(tmpFood);
            FoodServingEstablishmentListView.this.setVisible(false);
            FoodServingEstablishmentListView.this.parentFoodCntl.showFoodDetailUI(-1, null);
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFoodTable.getSelectedRow();
            int selectedModelRow = theFoodTable.convertRowIndexToModel(selectedTableRow);
            FoodServingEstablishmentListView.this.parentFoodCntl.deleteFood(selectedModelRow);
        }
    }
    
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){        
            FoodServingEstablishmentListView.this.dispose();
            FoodServingEstablishmentListView.this.setVisible(false);
            FoodServingEstablishmentListView.this.parentFoodCntl.getMainMenuCntl().showMenu();
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
      FoodServingEstablishmentListView.this.theFoodTable.removeNotify();
      FoodServingEstablishmentListView.this.theFoodTable.addNotify();
    }
  }
    
}

