/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHaynes
 * This class manages all of the persistent data for the application
 */
public class SerializedDataCntl {
    
    private SerializedDataModel theSerializedDataModel;
    private static SerializedDataCntl theSerializedDataCntl;
    
    //Private to prevent instantiation.
    private SerializedDataCntl(){
        getSerializedDataModel();
    }
    
    //Singleton design pattern ensures there is only ever one SerializedCollectionCntl.
    public static SerializedDataCntl getSerializedDataCntl(){
        if(theSerializedDataCntl == null){
            theSerializedDataCntl = new SerializedDataCntl();
        }
        return theSerializedDataCntl;
    }
    
    // Returns the serialized data model
    // Creates test data if it is null
    public SerializedDataModel getSerializedDataModel(){
        if(theSerializedDataModel == null){
            //readSerializedCollectionFile();
            theSerializedDataModel = new SerializedDataModel();
        }
        return theSerializedDataModel;
    }
    
    // This method creates some test data if the serialized data model is null.
    private void createTestSerializedDataModel(){
        theSerializedDataModel = new SerializedDataModel();
    }
    protected void writeSerializedDataModel(){
        
    }
    
    protected void readSerializedDataModel(){
        
    }
    
    protected void testPrintSerializedDataModel(){
        
    }
}
