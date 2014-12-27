import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.border.TitledBorder;
import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JMenuItem;


public class mainMenu {

	public JFrame frame;
	private JButton btnHighScores;
	private JButton btnHelp;
	private JButton btnStartGame;
	private JButton btnCreateAccount;
	private JButton btnLogIn;
	private JButton btnExit;
	private JLabel lblManMenu;
	private JLabel lblNewLabel;
	private JPanel panel;
	private boolean ll = false;
	private boolean LChoice = false;
	/**
	 * @wbp.nonvisual location=40,-21
	 */
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public mainMenu() {
		initialize();
	}
	
	
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\workspace\\Dirty3_Final\\src\\img\\background.jpg"));
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JPanel contentPane;
		contentPane = new JPanel(); 
		contentPane = new JPanel() {  
			                 public void paintComponent(Graphics g) {  
			                      Image img = Toolkit.getDefaultToolkit().getImage(  
		                                Frame.class.getResource(".jpg"));  
			                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                }  
			            };
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnSettings.setForeground(Color.BLUE);
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSettings.setBounds(10, 61, 129, 35);
		frame.getContentPane().add(btnSettings);
		
		btnHighScores = new JButton("High Scores");
		btnHighScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL url1;
				try {
					url1 = new URL("http://localhost/dirty3/highscore.php");
					openWebpage(url1);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnHighScores.setForeground(Color.BLUE);
		btnHighScores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHighScores.setBounds(10, 107, 129, 35);
		frame.getContentPane().add(btnHighScores);
		
		btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnHelp.setForeground(Color.BLUE);
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHelp.setBounds(10, 153, 129, 35);
		frame.getContentPane().add(btnHelp); 
		
		btnStartGame = new JButton("START GAME");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					/*lchoice dialog = new lchoice();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					frame.hide();*/
					LChoice = true;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnStartGame.setForeground(Color.BLUE);
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStartGame.setBounds(216, 61, 150, 54);
		frame.getContentPane().add(btnStartGame);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL url1;
				try {
					url1 = new URL("http://localhost/dirty3/signup.php");
					openWebpage(url1);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}
		});
			
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreateAccount.setForeground(Color.BLUE);
		btnCreateAccount.setBounds(216, 203, 150, 46);
		frame.getContentPane().add(btnCreateAccount);
		
		btnLogIn = new JButton("LOG IN");
		
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL url1;
				try {
					url1 = new URL("http://localhost/dirty3/login.php");
					openWebpage(url1);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setForeground(Color.BLUE);
		btnLogIn.setBounds(216, 138, 150, 41);
		frame.getContentPane().add(btnLogIn);
		
		btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setForeground(Color.BLUE);
		btnExit.setBounds(10, 199, 129, 35);
		frame.getContentPane().add(btnExit); 
		
		lblManMenu = new JLabel("MAIN MENU");
		lblManMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblManMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblManMenu.setForeground(Color.WHITE);
		lblManMenu.setBackground(new Color(255, 255, 255));
		lblManMenu.setBounds(117, 11, 180, 33);
		frame.getContentPane().add(lblManMenu);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -16, 446, 285);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 16, 434, 262);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\workspace\\Dirty3_Final\\src\\img\\background.jpg"));
		
		
	}
	public boolean getLevel(){
		return ll;
	}
	public boolean getLChoice(){
		return LChoice;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
