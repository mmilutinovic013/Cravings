import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FoodServingEstablishmentDetailView extends JFrame {
    FoodServingEstablishmentDetailController parentFoodServingEstablishmentDetailController;
    JLabel theFoodName = new JLabel("The Food Name");  //This will get passed a parameter once models are enabled
    // The Description would also be passed in via models
    String sampleText = 
        ("this is sample text"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "\n"
            + "this is sample text"
            + ""
            + ""
                 + "\n"
            + "this is sample text"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "\n"
            + "this is sample text"
            + ""
            + ""
                 + "\n"
            + "this is sample text"
            + "\n"
            + "this is sample text iuesfiushguhfuishfdoijfispofjiofhoushfisdhioshf"
            + "this is sample text"
    );
    JTextArea theFoodDescription = new JTextArea(sampleText);
    ImageIcon theImageField;
    private String[] foodGroups = { "Fruit", "Vegetable", "Meat", "Grain", "Snack" };
    JComboBox theFoodGroupComboBox = new JComboBox(foodGroups);
    JLabel theComboBoxLabel = new JLabel("My Food Group"); //Changeable because you can classify it yourself
    JLabel theImageLabel = new JLabel();
    JButton backToMain = new JButton("Back to Main Menu!");
    JButton editButton = new JButton("Edit");
    JButton deleteButton = new JButton("Delete");
        
    public FoodServingEstablishmentDetailView(FoodServingEstablishmentDetailController newFoodServingEstablishmentDetailController){
        parentFoodServingEstablishmentDetailController = newFoodServingEstablishmentDetailController;
        initCustomComponents();
        this.setSize(800, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }
    
    public void initCustomComponents(){

        theFoodDescription.setSize(100, 100);
        theImageField = new ImageIcon("38ceaa2e17aadb8bb325ad0e4928bd6e.jpeg");
        theImageLabel.setIcon(theImageField);
        theFoodGroupComboBox.setName("Food Group");

        JPanel thePanel = new JPanel();
        theFoodName.setAlignmentX(CENTER_ALIGNMENT);
        theImageLabel.setAlignmentX(CENTER_ALIGNMENT);
        theFoodDescription.setAlignmentX(CENTER_ALIGNMENT);
        theFoodGroupComboBox.setAlignmentX(CENTER_ALIGNMENT);
        theComboBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
        backToMain.setAlignmentX(CENTER_ALIGNMENT);


        BoxLayout theBoxLayout = new BoxLayout(thePanel, BoxLayout.PAGE_AXIS);
        thePanel.setLayout(theBoxLayout);
        thePanel.add(theFoodName);
        thePanel.add(theImageLabel);
        thePanel.add(theFoodDescription);
        thePanel.add(theComboBoxLabel);
        thePanel.add(theFoodGroupComboBox);
        thePanel.add(backToMain);
        thePanel.add(editButton);
        thePanel.add(deleteButton);
        theFoodGroupComboBox.setSelectedIndex(0);
        theFoodGroupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theFoodGroupComboBoxActionPerformed(evt);
            }
        });
         backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainButtonActionPerformed(evt);
            }
        });
         editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
         deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        this.getContentPane().add(thePanel);
        
        
    }
    
        private void theFoodGroupComboBoxActionPerformed(ActionEvent e){
        JComboBox cb = (JComboBox)e.getSource();
        String currentGroup = (String)cb.getSelectedItem();
    }
    
        private void backToMainButtonActionPerformed(ActionEvent e){
        MainMenuController theMainMenuController = new MainMenuController();
        this.dispose();
    }
        private void editButtonActionPerformed(ActionEvent e){
        //MainMenuController theMainMenuController = new MainMenuController();
        this.dispose();
    }
        private void deleteButtonActionPerformed(ActionEvent e){
        //MainMenuController theMainMenuController = new MainMenuController();
        this.dispose();
    }        
    
    
    
}