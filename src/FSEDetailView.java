
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markymark1346
 */
public class FSEDetailView extends JFrame {
    FSEController theFSECntl;
    int selectedRow; //For edit of a row selected in the FoodTableUI
    FSE theCurrentFSE;
    
    JPanel buttonPanel;
    JPanel topFieldPanel;
    JPanel infoFieldPane;
    JPanel textAreaPanel;
    JPanel widgetAreaPanel;
    
    JButton backButton;
    JButton deleteButton;
    JButton cancelButton;
    JButton saveButton;
    
    JLabel foodNumberLabel;
    JLabel foodDateLabel;
    JLabel foodNameLabel;
    JLabel foodDescriptionLabel;
    
    JTextField foodNumber;
    JTextField foodName;
    JTextArea fseDescription;
    JScrollPane theTextAreaScroller;
    
    JRadioButton meatButton;
    JRadioButton diaryButton;
    JRadioButton grainButton;
    JRadioButton vegButton;
    JRadioButton fruitButton;
    ButtonGroup foodGroup;
    JPanel foodGroupPanel;
    
    JCheckBox isVegetarian;
    JCheckBox isVegan;
    JCheckBox isGlutenFree;
    JPanel foodLimiterPanel;
    
    JPanel foodGenrePanel;
    JComboBox foodGenreCombo;
    
    public FSEDetailView(FSEController parentFSECntl, int theSelectedRow, FSE theSelectedFSE){
        theFSECntl = parentFSECntl;
        selectedRow = theSelectedRow;
        theCurrentFSE = theSelectedFSE;
        this.initComponents();
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Food Serving Establishment");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        foodName.requestFocusInWindow();
    }
    
    public void initComponents(){
        buttonPanel = new JPanel();
        topFieldPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Back");
        backButton.addActionListener(new FSEDetailView.BackButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new FSEDetailView.SaveButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new FSEDetailView.DeleteButtonListener());
        if(theCurrentFSE == null)deleteButton.setEnabled(false);
        
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        
        foodNumberLabel = new JLabel("Food Number");
        foodNameLabel = new JLabel("Food Name");
        foodDescriptionLabel = new JLabel("Food Description");
        
        foodNumber = new JTextField();
        foodNumber.setText(getFSENumber());
        foodNumber.setEditable(false);
        foodName = new JTextField();
        
        fseDescription = new JTextArea(10, 20);
        fseDescription.setEditable(true);
        theTextAreaScroller = new JScrollPane(fseDescription);
        theTextAreaScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        infoFieldPane = new JPanel(new GridLayout(2,2));
        infoFieldPane.add(foodNumberLabel);
        infoFieldPane.add(foodNumber);
        infoFieldPane.add(foodNameLabel);
        infoFieldPane.add(foodName);     
        topFieldPanel.add(infoFieldPane, BorderLayout.NORTH);
        
        textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.add(foodDescriptionLabel, BorderLayout.NORTH);
        textAreaPanel.add(theTextAreaScroller, BorderLayout.SOUTH);
        
        topFieldPanel.add(textAreaPanel, BorderLayout.SOUTH);
        
        meatButton = new JRadioButton("Meat");
        diaryButton = new JRadioButton("Diary");
        grainButton  = new JRadioButton("Grain");
        vegButton  = new JRadioButton("Veg");
        fruitButton  = new JRadioButton("Fruit");
        foodGroup = new ButtonGroup();
        foodGroup.add(meatButton);
        foodGroup.add(diaryButton);
        foodGroup.add(grainButton);
        foodGroup.add(vegButton);
        foodGroup.add(fruitButton);
        fruitButton.setSelected(true);
        foodGroupPanel = new JPanel();
        foodGroupPanel.add(meatButton);
        foodGroupPanel.add(diaryButton);
        foodGroupPanel.add(grainButton);
        foodGroupPanel.add(vegButton);
        foodGroupPanel.add(fruitButton);
        foodGroupPanel.setBorder(new TitledBorder(new EtchedBorder(),"Food Group"));
        
        isVegetarian = new JCheckBox("Vegetarian");
        isVegan = new JCheckBox("Vegan");
        isGlutenFree = new JCheckBox("Gluten Free");
        foodLimiterPanel = new JPanel();
        foodLimiterPanel.add(isVegetarian);
        foodLimiterPanel.add(isVegan);
        foodLimiterPanel.add(isGlutenFree);
        foodLimiterPanel.setBorder(new TitledBorder(new EtchedBorder(),"Food Limiter"));
        
        foodGenreCombo = new JComboBox();
        foodGenreCombo.addItem("General");
        foodGenreCombo.addItem("American");
        foodGenreCombo.addItem("French");
        foodGenreCombo.addItem("Chinese");
        foodGenreCombo.addItem("Mongolian");
        foodGenreCombo.setSelectedIndex(0);
        foodGenrePanel = new JPanel();
        foodGenrePanel.add(foodGenreCombo);
        foodGenrePanel.setBorder(new TitledBorder(new EtchedBorder(),"Food Genres"));
        
        widgetAreaPanel = new JPanel(new BorderLayout());
        widgetAreaPanel.add(foodGroupPanel, BorderLayout.NORTH);
        widgetAreaPanel.add(foodLimiterPanel, BorderLayout.CENTER);
        widgetAreaPanel.add(foodGenrePanel, BorderLayout.SOUTH);
        
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        this.getContentPane().add(topFieldPanel, BorderLayout.CENTER);
        this.getContentPane().add(widgetAreaPanel, BorderLayout.SOUTH);
        
        if(theCurrentFSE != null){
            initCurrentFSE();
        }
    }
    
        // This is for reading and updating existing notes...
    public void initCurrentFSE(){
        this.foodNumber.setText(theCurrentFSE.getFSENumber());
        this.foodName.setText(theCurrentFSE.getFSEName());
        this.fseDescription.setText(theCurrentFSE.getFSEDescription());   
        this.isVegetarian.setSelected(theCurrentFSE.getVegetarian());
        this.isVegan.setSelected(theCurrentFSE.getVegan());
        this.isGlutenFree.setSelected(theCurrentFSE.getGlutenFree());
        this.meatButton.setSelected(this.meatButton.getText().equals(theCurrentFSE.getFSEGroup()));
        this.diaryButton.setSelected(this.diaryButton.getText().equals(theCurrentFSE.getFSEGroup()));
        this.vegButton.setSelected(this.vegButton.getText().equals(theCurrentFSE.getFSEGroup()));
        this.grainButton.setSelected(this.grainButton.getText().equals(theCurrentFSE.getFSEGroup()));
        this.fruitButton.setSelected(this.fruitButton.getText().equals(theCurrentFSE.getFSEGroup()));
        for(int i = 0; i < foodGenreCombo.getItemCount(); i++){
            String tempFoodGenre = (String)foodGenreCombo.getItemAt(i);
            if(tempFoodGenre.equals(theCurrentFSE.getFSEGenre())){
                foodGenreCombo.setSelectedIndex(i);
            }
        }
    }

        public class SaveButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent evt){
                // If it's a new Food
                if(theCurrentFSE == null){               
                    String newFoodNumber = FSEDetailView.this.foodNumber.getText();
                    String newFoodName = FSEDetailView.this.foodName.getText();
                    String newFoodDescription = FSEDetailView.this.fseDescription.getText();

                    FSEDetailView.this.theCurrentFSE = new FSE(newFoodNumber, newFoodName, newFoodDescription); // Change these values

                    FSEDetailView.this.theFSECntl.addFSE(theCurrentFSE); // add FSE
                    
                    FSEDetailView.this.setVisible(false);
                    FSEDetailView.this.dispose();
                    FSEDetailView.this.theFSECntl.showFSEListUI();

                }else{ //If it's a Food being edited...
                    FSEDetailView.this.theCurrentFSE.setFSENumber(FSEDetailView.this.foodNumber.getText());;
                    FSEDetailView.this.theCurrentFSE.setFSEName(FSEDetailView.this.foodName.getText());
                    FSEDetailView.this.theCurrentFSE.setFSEDescription(FSEDetailView.this.fseDescription.getText());
                
                    FSEDetailView.this.theFSECntl.changeFSE(selectedRow, theCurrentFSE);
                
                    FSEDetailView.this.setVisible(false);
                    FSEDetailView.this.dispose();
                    FSEDetailView.this.theFSECntl.showFSEListUI();
                }
            }
        }
        
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
                FSEDetailView.this.dispose();
                FSEDetailView.this.setVisible(false);
                FSEDetailView.this.theFSECntl.showFSEListUI();
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
                FSEDetailView.this.theFSECntl.deleteFSE(selectedRow);
                FSEDetailView.this.dispose();
                FSEDetailView.this.setVisible(false);
                FSEDetailView.this.theFSECntl.showFSEListUI();
        }
    }
        
    public String getFSENumber(){
        long newFSENumber = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getNextFSENumber();
        return Long.toString(newFSENumber);
    }
    
}
