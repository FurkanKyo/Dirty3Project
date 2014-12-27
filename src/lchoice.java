import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import java.io.IOException;

public class lchoice extends JDialog {

	boolean hard = false;
	boolean easy = false;
	boolean starter = false;
	

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public lchoice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\workspace\\Dirty3_Final\\src\\img\\10877580_10204569843338470_160263962_n.jpg"));
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("EASY");
			chckbxNewCheckBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(easy)
						easy = false;
					else
						easy = true;
							
				}
			});
			
			chckbxNewCheckBox.setForeground(Color.BLUE);
			chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			chckbxNewCheckBox.setBounds(44, 75, 142, 61);
			chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(chckbxNewCheckBox);
		}
		{
			JLabel lblNewLabel = new JLabel("Please Select the Game Mode");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBounds(78, 10, 304, 22);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("HARD");
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(hard)
					hard = false;
				else
					hard = true;
			}
		});
		chckbxNewCheckBox_1.setForeground(Color.BLUE);
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		chckbxNewCheckBox_1.setBounds(274, 98, 97, 23);
		contentPanel.add(chckbxNewCheckBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						//
						
						
						if(easy == true &&  hard == true)
							JOptionPane.showMessageDialog(contentPanel, "Please select one game mode");
						else if(easy == false &&  hard == false)
							JOptionPane.showMessageDialog(contentPanel, "Please select one game mode");
						else if(easy){
							starter = true;
							hide();					

						}
						
						else if(hard){
							hide();	
							starter = true;
						}
						
						
					} 
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean getEasy()
	{
		return easy;
	}
	public boolean getHard()
	{
		return hard;
	}
	public boolean getStarter(){
	
		return starter;
	}
}
