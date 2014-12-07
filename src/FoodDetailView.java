
import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
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
public class FoodDetailView extends JFrame {
    FoodController theFoodCntl;
    int selectedRow; //For edit of a row selected in the FoodTableUI
    Food theCurrentFood;
    
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
    JTextArea foodDescription;
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
    
    public FoodDetailView(FoodController parentFoodCntl, int theSelectedRow, Food theSelectedFood){
        theFoodCntl = parentFoodCntl;
        selectedRow = theSelectedRow;
        theCurrentFood = theSelectedFood;
        this.initComponents();
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Food");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        foodName.requestFocusInWindow();
    }
    
    public void initComponents(){
        buttonPanel = new JPanel();
        topFieldPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        if(theCurrentFood == null)deleteButton.setEnabled(false);
        
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        
        foodNumberLabel = new JLabel("Food Number");
        foodNameLabel = new JLabel("Food Name");
        foodDescriptionLabel = new JLabel("Food Description");
        
        foodNumber = new JTextField();
        foodNumber.setText(getFoodNumber());
        foodNumber.setEditable(false);
        foodName = new JTextField();
        
        foodDescription = new JTextArea(10, 20);
        foodDescription.setEditable(true);
        theTextAreaScroller = new JScrollPane(foodDescription);
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
        
        if(theCurrentFood != null){
            initCurrentFood();
        }
    }
    
        // This is for reading and updating existing notes...
    public void initCurrentFood(){
        this.foodNumber.setText(theCurrentFood.getFoodNumber());
        this.foodName.setText(theCurrentFood.getFoodName());
        this.foodDescription.setText(theCurrentFood.getFoodDescription());   
        this.isVegetarian.setSelected(theCurrentFood.getVegetarian());
        this.isVegan.setSelected(theCurrentFood.getVegan());
        this.isGlutenFree.setSelected(theCurrentFood.getGlutenFree());
        this.meatButton.setSelected(this.meatButton.getText().equals(theCurrentFood.getFoodGroup()));
        this.diaryButton.setSelected(this.diaryButton.getText().equals(theCurrentFood.getFoodGroup()));
        this.vegButton.setSelected(this.vegButton.getText().equals(theCurrentFood.getFoodGroup()));
        this.grainButton.setSelected(this.grainButton.getText().equals(theCurrentFood.getFoodGroup()));
        this.fruitButton.setSelected(this.fruitButton.getText().equals(theCurrentFood.getFoodGroup()));
        for(int i = 0; i < foodGenreCombo.getItemCount(); i++){
            String tempFoodGenre = (String)foodGenreCombo.getItemAt(i);
            if(tempFoodGenre.equals(theCurrentFood.getFoodGenre())){
                foodGenreCombo.setSelectedIndex(i);
            }
        }
    }

        public class SaveButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent evt){
                // If it's a new Food
                if(theCurrentFood == null){               
                    String newFoodNumber = FoodDetailView.this.foodNumber.getText();
                    String newFoodName = FoodDetailView.this.foodName.getText();
                    String newFoodDescription = FoodDetailView.this.foodDescription.getText();

                    FoodDetailView.this.theCurrentFood = new Food(newFoodNumber, newFoodName, newFoodDescription);

                    FoodDetailView.this.theFoodCntl.addFood(theCurrentFood);
                    
                    FoodDetailView.this.setVisible(false);
                    FoodDetailView.this.dispose();
                    FoodDetailView.this.theFoodCntl.showFoodListUI();

                }else{ //If it's a Food being edited...
                    FoodDetailView.this.theCurrentFood.setFoodNumber(FoodDetailView.this.foodNumber.getText());;
                    FoodDetailView.this.theCurrentFood.setFoodName(FoodDetailView.this.foodName.getText());
                    FoodDetailView.this.theCurrentFood.setFoodDescription(FoodDetailView.this.foodDescription.getText());
                
                    FoodDetailView.this.theFoodCntl.changeFood(selectedRow, theCurrentFood);
                
                    FoodDetailView.this.setVisible(false);
                    FoodDetailView.this.dispose();
                    FoodDetailView.this.theFoodCntl.showFoodListUI();
                }
            }
        }
        
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
                FoodDetailView.this.dispose();
                FoodDetailView.this.setVisible(false);
                FoodDetailView.this.theFoodCntl.showFoodListUI();
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
                FoodDetailView.this.theFoodCntl.deleteFood(selectedRow);
                FoodDetailView.this.dispose();
                FoodDetailView.this.setVisible(false);
                FoodDetailView.this.theFoodCntl.showFoodListUI();
        }
    }
        
    public String getFoodNumber(){
        long newFoodNumber = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getNextFoodNumber();
        return Long.toString(newFoodNumber);
    }
    
    
    
}
