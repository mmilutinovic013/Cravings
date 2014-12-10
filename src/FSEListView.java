
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
public class FSEListView extends JFrame {
    FSEController parentFSEController;
    JPanel buttonPanel;
    JPanel tablePanel;
    JTable theFSETable;
    JScrollPane theScrollPane;
    JButton backButton;
    JButton deleteButton;
    JButton editButton;
    JButton newButton;
    
    TableRowSorter<TableModel> fseTableSorter;
    
    JPanel filterPanel;
    JButton searchButton;
    JLabel filterLabel;
    JTextField filterTextField;
    JComboBox filterFieldList;

    
    public FSEListView(FSEController theFSEController){
        parentFSEController = theFSEController;
        this.initCustomComponents();
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Food Serving Establishment List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initCustomComponents(){
        buttonPanel = new JPanel();
        tablePanel = new JPanel();
        filterPanel = new JPanel();
        
        backButton = new JButton("Back");
        backButton.addActionListener(new FSEListView.BackButtonListener());
        newButton = new JButton("New");
        newButton.addActionListener(new FSEListView.NewButtonListener());
        editButton = new JButton("Edit");
        editButton.addActionListener(new FSEListView.EditButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new FSEListView.DeleteButtonListener());

        //Table initialization
        theFSETable = new JTable(parentFSEController.getFSETableModel());
        
        //This fixes the unserializable inner class but need to implement a cleaner solution.
        //theFoodCntl.getFoodTableModel().addTableModelListener(new KludgeTableModelListener());
        
        theFSETable.getColumnModel().getColumn(0).setPreferredWidth(25);
        theFSETable.getColumnModel().getColumn(1).setPreferredWidth(50);
 
        //Put everything together
        theScrollPane = new JScrollPane(theFSETable);
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setPreferredSize(new Dimension(350,400));
        theFSETable.setFillsViewportHeight(true);
        
        //FSE table sorter
        fseTableSorter = new TableRowSorter<TableModel>(theFSETable.getModel());
        theFSETable.setRowSorter(fseTableSorter);
        
        tablePanel.add(theScrollPane);  
        
        // FSE table filter (search)
        filterLabel = new JLabel("Search (Filter)");
        filterTextField = new JTextField(15);
        filterTextField.addActionListener(new FSEListView.FilterTextFieldListener());
        
        //Need to initialize the JComboBox after the table to get the columns.
        String[] columnNames = new String[theFSETable.getModel().getColumnCount()];
        for(int i = 0; i < columnNames.length; i++){
            columnNames[i] = theFSETable.getModel().getColumnName(i);
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
            FSEListView.this.fseTableSorter.setRowFilter(rowFilter);
        }
    }
    
    
   public class EditButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFSETable.getSelectedRow();
            int selectedModelRow = theFSETable.convertRowIndexToModel(selectedTableRow);
            FSE selectedFSE = FSEListView.this.parentFSEController.getFSE(selectedModelRow);
            FSEListView.this.setVisible(false);
            FSEListView.this.parentFSEController.showFSEDetailUI(selectedModelRow, selectedFSE);
        }
    }
   
    
    public class NewButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){     
            //Food tmpFood = new Food(99999, "Test Create Food", "Test Create Food Description");
            //FoodListUI.this.parentFoodCntl.getFoodTableModel().addFood(tmpFood);
            FSEListView.this.setVisible(false);
            FSEListView.this.parentFSEController.showFSEDetailUI(-1, null);
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int selectedTableRow = theFSETable.getSelectedRow();
            int selectedModelRow = theFSETable.convertRowIndexToModel(selectedTableRow);
            FSEListView.this.parentFSEController.deleteFSE(selectedModelRow);
        }
    }
    
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){        
            FSEListView.this.dispose();
            FSEListView.this.setVisible(false);
            FSEListView.this.parentFSEController.getMainMenuCntl().showMenu();
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
      FSEListView.this.theFSETable.removeNotify();
      FSEListView.this.theFSETable.addNotify();
    }
  }
}
