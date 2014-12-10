/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 * 
 *  We are using listOfFoods in order to populate the table in the main menu
 *  The buttons will be assigned the label of the food name based on whatever is in
 *  the list of foods. 
 *  the Food List window, Food Serving Establishment List window, and Find Food window
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenuView extends JFrame {
    
    // Declare variables
    MainMenuController theMainMenuController;
    JButton foodListButton = new JButton("Food List");
    JButton foodServingEstablishmentListButton = new JButton("Food Serving Establishments List");
    JButton findFoodButton = new JButton("Find Food!");
    JPanel theJPanel = new JPanel();
    JLabel theTitleLabel = new JLabel("Welcome to Cravings! Please select a choice below!");
   
    public MainMenuView(MainMenuController newMainMenuController){
        theMainMenuController = newMainMenuController;
        initCustomComponents();
        this.setSize(600, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    // Begin custom setup!
    public void initCustomComponents(){
       // Define Layout = BorderLayout and set the ContentPane to be as such
       BorderLayout theBorderLayout = new BorderLayout();
       this.getContentPane().setLayout(theBorderLayout);
       // Set Alignment for Header Label
       theTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
       // Add ActionListeners to Buttons
       findFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFoodButtonButtonActionPerformed(evt);
            }
        });
       foodListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodListButtonActionPerformed(evt);
            }
        });
       foodServingEstablishmentListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodServingEstablishmentListButtonActionPerformed(evt);
            }
        });
       // Add Buttons to the Content Pane at the Appropriate Regions
       this.getContentPane().add(theTitleLabel, BorderLayout.PAGE_START);
       this.getContentPane().add(findFoodButton, BorderLayout.LINE_START);
       this.getContentPane().add(foodServingEstablishmentListButton, BorderLayout.CENTER);
       this.getContentPane().add(foodListButton, BorderLayout.LINE_END);  
    }
    // Action Event Handling
    private void findFoodButtonButtonActionPerformed(ActionEvent e){
        FindFoodController theFindFoodController = new FindFoodController();
        this.dispose();
    }
    
    private void foodListButtonActionPerformed(ActionEvent e){
        FoodController theFoodController = new FoodController(theMainMenuController);
        this.dispose();
    }
    
    private void foodServingEstablishmentListButtonActionPerformed(ActionEvent e){
        FSEController theFSEController = new FSEController(theMainMenuController);
        this.dispose();
    }
}
