
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class CreateFoodView extends JFrame {
    
    CreateFoodController theCreateFoodController;
    JTextField foodNameTextField = new JTextField();
    JLabel foodNameText = new JLabel("Food Name?");
    JTextField foodDescriptionTextField = new JTextField();
    JLabel foodDescriptionText = new JLabel("Food Description?");
    JCheckBox isFavorite = new JCheckBox("Is Favorite?");
    JButton backToMainButton = new JButton("Back to Main Menu!");
    JButton submitButton = new JButton("Submit");


   

    
    public CreateFoodView(CreateFoodController newCreateFoodController){
        theCreateFoodController = newCreateFoodController;
        initCustomComponents();
        this.setSize(800, 100);
        this.setLocationRelativeTo(null);
    }
    
    public void initCustomComponents(){
        FlowLayout theFlowLayout = new FlowLayout();
        foodNameTextField.setPreferredSize(new Dimension(200, 24));
        foodDescriptionTextField.setPreferredSize(new Dimension(200, 24));
        this.getContentPane().setLayout(theFlowLayout);
        // Set Action Performed
        backToMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainButtonActionPerformed(evt);
            }
        });
        // Begin Panel Adding
        this.getContentPane().add(foodNameText);
        this.getContentPane().add(foodNameTextField);
        this.getContentPane().add(foodDescriptionText);
        this.getContentPane().add(foodDescriptionTextField);
        this.getContentPane().add(isFavorite);
        this.getContentPane().add(submitButton);
        this.getContentPane().add(backToMainButton);


        
        
    }

        private void backToMainButtonActionPerformed(ActionEvent e){
            MainMenuController theMainMenuController = new MainMenuController();
            this.dispose();
        }

    }
