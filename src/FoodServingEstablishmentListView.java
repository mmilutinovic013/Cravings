
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
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
public class FoodServingEstablishmentListView extends JFrame {
    
    FoodServingEstablishmentListController parentFoodServingEstablishmentListController;
    
    FoodServingEstablishmentListController parentFoodEstablishmentController;
    JButton backToMainButton = new JButton("Back to Main Menu!");
    Boolean saveItForLater = false;
    JLabel title = new JLabel("FSE List View");
    String[] columnNames = {"FSE Name", "FSE Description", "Save it!"};
    Object[][] testData = {
        {"Hewigs", "It is really good ", saveItForLater}, // foodName, description, button
        {"Hoss's", "It is really good ", saveItForLater},
        {"Red Lobster", "It is really good ", saveItForLater},
        {"McDonalds", "It is really good ", saveItForLater},
        {"BK", "It is really good ", saveItForLater}, // foodName, description, button
        {"Organ Bobs", "It is really good ", saveItForLater},
        {"Lards R US", "It is really good ", saveItForLater},
        {"Lots of Cake", "It is really good ", saveItForLater},
        {"Green Beans and God", "It is really good ", saveItForLater}, // foodName, description, button
        {"Hewigs", "It is really good ", saveItForLater}, // foodName, description, button
        {"Hoss's", "It is really good ", saveItForLater},
        {"Red Lobster", "It is really good ", saveItForLater},
        {"McDonalds", "It is really good ", saveItForLater},
        {"BK", "It is really good ", saveItForLater}, // foodName, description, button
        {"Organ Bobs", "It is really good ", saveItForLater},
        {"Lards R US", "It is really good ", saveItForLater},
        {"Lots of Cake", "It is really good ", saveItForLater},
        {"Green Beans and God", "It is really good ", saveItForLater}, // foodName, description, button
        {"Hewigs", "It is really good ", saveItForLater}, // foodName, description, button
        {"Hoss's", "It is really good ", saveItForLater},
        {"Red Lobster", "It is really good ", saveItForLater},
        {"McDonalds", "It is really good ", saveItForLater},
        {"BK", "It is really good ", saveItForLater}, // foodName, description, button
        {"Organ Bobs", "It is really good ", saveItForLater},
        {"Lards R US", "It is really good ", saveItForLater},
        {"Lots of Cake", "It is really good ", saveItForLater},
        {"Green Beans and God", "It is really good ", saveItForLater}, // foodName, description, button
    };
    DefaultTableModel model = new DefaultTableModel(testData, columnNames);
    protected JTable table = new JTable(model);
    JButton createFSEButton = new JButton("Create New FSE!");

    
    public FoodServingEstablishmentListView(FoodServingEstablishmentListController newFoodServingEstablishmentListController){
        parentFoodServingEstablishmentListController = newFoodServingEstablishmentListController;
        initCustomComponents();
        this.setSize(600, 100);
        this.setLocationRelativeTo(null);
    }
    public void initCustomComponents(){
        
       // Define Layout = BorderLayout and set the ContentPane to be as such
       BorderLayout theBorderLayout = new BorderLayout();
       this.getContentPane().setLayout(theBorderLayout);
       
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
       createFSEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFSEButtonActionPerformed(evt);
            }
        }); 
       table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    //open food detail
                    //FoodDetailController theFoodDetailController = new FoodDetailController();
                    FoodServingEstablishmentListView.this.dispose();
                }
            }
        });
       
       // Add Buttons to the Content Pane at the Appropriate Regions
       //We are trying to add title and back menu button to the pane
       //this.getContentPane().add(title, BorderLayout.LINE_END);
       this.getContentPane().add(scrollPane, BorderLayout.CENTER);
       this.getContentPane().add(backToMainButton, BorderLayout.LINE_START);//
       this.getContentPane().add(createFSEButton, BorderLayout.LINE_END);

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
    
    private void createFSEButtonActionPerformed(ActionEvent e){
        // Create new FSE Item window
        CreateFSEController theFSEController = new CreateFSEController();
        this.dispose();
    }
    
}

