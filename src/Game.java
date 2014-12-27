import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public interface Game {

	/*JPanel userCardsPanel;
	JPanel deskPanel;
	JPanel com1Panel;
	JPanel com2Panel;
	JPanel com3Panel;
	Computer[] coms;
	User me;
	Desk desk;
	LinkedList<Card> allCards,penalties;
	Card card;*/
	/*Timer timer;
	boolean wait;
	JButton button;
	JButton ng, exB;
	JLabel label;
	JLabel label_1;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	int round;
	JPanel contentPane;
	JFrame f;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;*/
	boolean ex = false;
	boolean nn = false;
	static boolean flag=true;
	boolean winner = false;
	/**
	 * Launch the application.
	 */
	
	public void initGame();
	
	public void playGame();
	public void showWinner();
	public boolean isNewGame();
	
}
