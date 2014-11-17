
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodListView extends JFrame implements Serializable {
    
    FoodListController parentFoodListController;
    
    FoodServingEstablishmentListController parentFoodEstablishmentController;
    JButton backToMainButton = new JButton("Back to Main Menu!");
    Boolean saveItForLater = false;
    String[] columnNames = {"Food Name", "Food Description", "Favorited!"};
    SerializedDataModel theSerializedDataModel = new SerializedDataModel();
    Object[][] testData;
    // DefaultTableModel model = new DefaultTableModel(testData, columnNames);
    DefaultTableModel model;
    protected JTable table;
    protected JTable theFoodTable; // This will be based on the FoodTable Model
    JButton createFoodButton = new JButton("Create New FSE!");
    FoodController theFoodController = new FoodController();

    
    public FoodListView(FoodListController newFoodListController){
        parentFoodListController = newFoodListController;
        initCustomComponents();
        this.setSize(600, 100);
        this.setLocationRelativeTo(null);
    }
    public void initCustomComponents(){
       FoodList theFoodList = theSerializedDataModel.getFoodList();
       FoodTableModel theFoodTableModel = new FoodTableModel(theFoodController);
       DefaultTableModel theDefaultTableModel = new DefaultTableModel(columnNames, 0); // This makes number of rows equal to 0
       for(int i = 0; i < theFoodList.getListOfFoods().size(); i++){
            Object theFoodID = theFoodTableModel.getValueAt(i, 0);
            Object theFoodName = theFoodTableModel.getValueAt(i, 1);
            Object theFoodDescription = theFoodTableModel.getValueAt(i, 2);           
            Object[] theDataArray = {theFoodID, theFoodName,  theFoodDescription};
            theDefaultTableModel.addRow(theDataArray);
       }
       //theFoodTableModel.buildTestFoodTable(1000);
        //model = new DefaultTableModel(testData, columnNames);

        table = new JTable(theDefaultTableModel);
        
       BorderLayout theBorderLayout = new BorderLayout();
       this.getContentPane().setLayout(theBorderLayout);
       // Define Layout = BorderLayout and set the ContentPane to be as such
       JScrollPane scrollPane = new JScrollPane(table);
       table.setFillsViewportHeight(true);
       //BorderLayout theBorderLayout = new BorderLayout();
       //this.getContentPane().setLayout(theBorderLayout);
       // Add Action Listeners
       backToMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainButtonActionPerformed(evt);
            }
        });  
       createFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFoodButtonActionPerformed(evt);
            }
        });
       table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    //open food detail
                    FoodDetailController theFoodDetailController = new FoodDetailController();
                    FoodListView.this.dispose();
                }
            }
        });
       
       // Add Buttons to the Content Pane at the Appropriate Regions
       this.getContentPane().add(scrollPane, BorderLayout.CENTER);
       this.getContentPane().add(backToMainButton, BorderLayout.LINE_START);//
       this.getContentPane().add(createFoodButton, BorderLayout.LINE_END);
       

    }
    // Action Event Handling
    private void backToMainButtonActionPerformed(ActionEvent e){
        MainMenuController theMainMenuController = new MainMenuController();
        this.dispose();
    }
    
    private void foodDetailsButtonActionPerformed(ActionEvent e){
        // Create new food Details window
        this.dispose();
    }
    
    private void createFoodButtonActionPerformed(ActionEvent e){
        // Create new CreateFood window
        CreateFoodController theCreateFoodController = new CreateFoodController();
        this.dispose();
    }
    
}
