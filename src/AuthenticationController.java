
import java.util.ArrayList;
import java.util.Arrays;


public class AuthenticationController {
	
        private int loginAttempts = 0;
        private UserList theUserList = new UserList();
        
	public AuthenticationController(){
		this.showSplash();
                this.showLoginUI();
	}
        
        public boolean authenticate(String newUsername, char[] newPassword){
            loginAttempts++;
            boolean isAuthenticated = false; // not set to false for debug purpose
            // see if can found
            System.out.println(newUsername);
            System.out.println(newPassword);
            
            UserList theUserList = new UserList();
            
            ArrayList<User> theListOfUsers = theUserList.getTheListOfUsers();
            
            for(int i = 0; i < theListOfUsers.size(); i++){

                if(newUsername.equals(theListOfUsers.get(i).getUsername()) && this.checkPassword(newPassword, theUserList)){
                    isAuthenticated = true;
                    break;
                }
            }
            System.out.println("");
            System.out.println(isAuthenticated);
            
            
            
            return isAuthenticated;
        }
        
       
       
	
	public void showSplash(){
		SplashUI splashy = new SplashUI(); // or call it theSplashUI
		splashy.setVisible(true);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splashy.setVisible(false);
	}
	
	public void showLoginUI(){
		LoginUI loggy = new LoginUI(this);
                loggy.setVisible(true); 
	}
	
	public void getUserList(){
		
	}
        
        public int getLoginAttempts(){
            return loginAttempts; 
        }
          
        public void resetLoginAttempts(){
             loginAttempts = 0; 
        }
        
        
        public boolean checkPassword(char[] thePassword, UserList theUserList){
            boolean isTrue = false;
            String passwordAsString = String.valueOf(thePassword);
            ArrayList<User> theListOfUsers = theUserList.getTheListOfUsers();
            String currentUserListPassword;
            
            for(int i = 0; i < theListOfUsers.size(); i++){
                // This returns the current User's password in the iteration.
                currentUserListPassword = String.valueOf(theListOfUsers.get(i).getPassword());
                // Begin check.
                if(passwordAsString.equals(currentUserListPassword)){
                    isTrue = true;
                }
            }
            return isTrue;
        }

}
