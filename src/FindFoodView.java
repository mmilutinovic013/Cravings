
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author markymark1346
 */
public class FindFoodView extends JFrame {
    
    // Declare variables
    //MainMenuController theMainMenuController;
    JTextField theTextBox = new JTextField();
    
    JRadioButton searchByFoodServingEstablishment = new JRadioButton("Search by Establishment");
    JRadioButton searchByName = new JRadioButton("Search by Name");
    ButtonGroup theButtonGroup = new ButtonGroup();
        
    FindFoodController parentFindFoodController;
    JButton backToMainButton = new JButton("Back to Main Menu!");
    JButton searchButton = new JButton("Search");
    JLabel theTitleLabel = new JLabel("Find Food View");
    
    JPanel theJPanel = new JPanel();
   
    public FindFoodView(FindFoodController newFindFoodController){
        parentFindFoodController = newFindFoodController;
        initCustomComponents();
        this.getContentPane().add(theJPanel);
        this.setSize(800, 100);
        this.setLocationRelativeTo(null);
    }
    public void initCustomComponents(){
        FlowLayout theFlowLayout = new FlowLayout();
        this.getContentPane().setLayout(theFlowLayout);
        theTextBox.setPreferredSize(new Dimension(200, 24));
       // Add events
         backToMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainButtonActionPerformed(evt);
            }
        });
       theButtonGroup.add(searchByName);
       theButtonGroup.add(searchByFoodServingEstablishment);
       // Add Buttons to the Content Pane at the Appropriate Regions
       this.getContentPane().add(searchByFoodServingEstablishment);
       this.getContentPane().add(searchByName);
       this.getContentPane().add(theTextBox);
       this.getContentPane().add(searchButton);
       this.getContentPane().add(backToMainButton);
    }
    // Action Event Handling    
    private void backToMainButtonActionPerformed(ActionEvent e){
        MainMenuController theMainMenuController = new MainMenuController();
        this.dispose();
    }
    // To Do   
}

