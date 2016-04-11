import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RickRoll extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField URLYT;

	/**
	 * Hello! This is a tool for trolling, It will start a GUI that you can define a URL for a song or a video
	 * that and you can set how many times it will be opened in a new tab. Please make sure the default browser is open.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RickRoll dialog = new RickRoll();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RickRoll() {
		setBounds(100, 100, 590, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(59, 54, 124, 26);
		contentPanel.add(spinner);
		
		JLabel lblEnterHowMany = new JLabel("Enter How many times the tabs will be opened for the RICK ROLL!");
		lblEnterHowMany.setBounds(49, 12, 486, 42);
		contentPanel.add(lblEnterHowMany);
		
		JLabel lblWantADiffernt = new JLabel("URL (Defult is RICK ROLL!)");
		lblWantADiffernt.setBounds(26, 121, 436, 15);
		contentPanel.add(lblWantADiffernt);
		
		URLYT = new JTextField();
		URLYT.setText("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		URLYT.setBounds(22, 148, 426, 19);
		contentPanel.add(URLYT);
		URLYT.setColumns(10);
		
		JLabel lblBeforYouStart = new JLabel("Before You Start.... Have browser open so it can make multiple tabs....");
		lblBeforYouStart.setBounds(26, 0, 509, 15);
		contentPanel.add(lblBeforYouStart);
		
		JLabel lblHowManyMillaseconds = new JLabel("Delay in Milliseconds :: 1000 milliseconds is one second");
		lblHowManyMillaseconds.setBounds(61, 197, 630, 26);
		contentPanel.add(lblHowManyMillaseconds);
		
		JSpinner Delay = new JSpinner();
		Delay.setBounds(163, 226, 78, 20);
		contentPanel.add(Delay);
		
		JLabel lblNewLabel = new JLabel("If left at 0-100 the defalt is 100");
		lblNewLabel.setBounds(247, 228, 239, 15);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String URLYTString = URLYT.getText();
							int x = 0;
							int value = (Integer) spinner.getValue();
							int wait = (Integer) Delay.getValue();
							value = value-1;
							if(Desktop.isDesktopSupported()){
								if(wait <= 100){
									wait = 100;
									System.out.println("Wait has been changed to 100 becuase no defined in Spinner");
								}
								
								while(value >= x){
									try {
										Desktop.getDesktop().browse(new URI(URLYTString));
									} catch (IOException | URISyntaxException e1) {
										e1.printStackTrace();
									} //RICKROLL!
									x = x+1;
									try {
									    Thread.sleep(wait);                 //1000 milliseconds is one second.
									} catch(InterruptedException ex) {
									    Thread.currentThread().interrupt();}
								}
					}
					}});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);}{}}}	
}
