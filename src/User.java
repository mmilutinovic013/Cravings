
public class User implements Printable{
	
	private String username = "";
	private char[] password;
	
	public User(){
		username = "Undefined";
		String objectString = this.toString();
		System.out.println(objectString);
	}
	
	public User(String newUsername, char[] newPassword){
		username = newUsername;
                password = newPassword;
	}
	
	/* Public interface of this class
	 * 
	 * public String getUsername()
	 * public char[] getPassword()
	 * public void setUsername(String newUsername)
	 * public void setUsername(StringBuffer newUsername){
	 */
	
        // need to override the equals method
      
        
	public String toString(){
		return this.getUsername();
	}
	public String getUsername(){
		return this.username;
	}

	public char[] getPassword(){
		return this.password;
	}
	
	public void setUsername(String newUsername){
		username = newUsername;
	}
	
	public void setUsername(StringBuffer newUsername){
		username = new String(newUsername);
	}

	public void print() {
		
	}

	public void preview() {
		
	}

	public void format() {
		
	}	
}
