import java.util.ArrayList;


public class UserList {

	private ArrayList<User> theListOfUsers = new ArrayList(); // declare static to ensure 1 and only 1 userlist
	
        public UserList(){
            for(int i = 0; i < 100; i++){
                String username = "test" + i;
                char[] password = username.toCharArray();
                User newUser = new User(username, password);
                theListOfUsers.add(newUser);
            }
        }
        
	public ArrayList<User> getTheListOfUsers(){
		return theListOfUsers;
	}
}
