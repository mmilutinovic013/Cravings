import javax.swing.*;


public class SplashUI extends JFrame {
	
	private JPanel theImagePanel = new JPanel();
	private JLabel theImageLabel = new JLabel();
	private JLabel textLabel = new JLabel("Cravings: Your Fried Pickle Finder!");
	private ImageIcon theSplashImage; 

	public SplashUI(){
		initCustomComponents();
		this.setSize(640, 450);
		this.setLocationRelativeTo(null);
	}
	
	public void initCustomComponents(){
		theSplashImage = new ImageIcon("CravingsSplashImage.jpg");
		theImageLabel.setIcon(theSplashImage);
		theImagePanel.add(theImageLabel);
		theImagePanel.add(textLabel);
		this.getContentPane().add(theImagePanel);
		this.setResizable(false);
		//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
