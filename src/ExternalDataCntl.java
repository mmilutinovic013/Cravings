/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author srh10
 */
public class ExternalDataCntl {
    
    private final String EXTERNAL_DATA_PATH = "cravings_data\\";
    private final String FOOD_GROUP_FILE_NAME = "FD_GROUP.TXT";
    private final String FOOD_DESC_FILE_NAME = "FD_DESC.TXT";
    
    public ExternalDataCntl(){
        if(confirmImport()){
            getExternalFood();
        }
    }
    
    public void getExternalFood(){
        getFoodGroup();
        // getFood();
    }
    
    public void getFoodGroup(){
        String filePath = EXTERNAL_DATA_PATH+FOOD_GROUP_FILE_NAME;
        File foodGroupFile = new File(filePath);
        try{
            Scanner in = new Scanner(foodGroupFile);
            String nextLine = "";
        
            while(in.hasNextLine()){
                nextLine = in.nextLine();
                System.out.println(nextLine);
                FoodGroup tmpFoodGroup = new FoodGroup(nextLine);
                SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodGroupList().getListOfFoodGroups().add(tmpFoodGroup);
            }
            // Simply prints the size of the newly imported FoodGroupList
            System.out.println(SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodGroupList().getListOfFoodGroups().size());
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        // Write the newly imported FoodGroupList to disk.
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
        // Read it back in.
        SerializedDataCntl.getSerializedDataCntl().readSerializedDataModel();
        // Test print to see if it worked.
        SerializedDataCntl.getSerializedDataCntl().testPrintSerializedDataModel();
        
    }
    
    public boolean confirmImport(){
            boolean importConfirmed = false;
            String message = "Are you sure you want to import foods?";
            String title = "Import Foods";
            // display the JOptionPane showConfirmDialog
            int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                importConfirmed = true;
            }
            return importConfirmed;
    }
    
}
