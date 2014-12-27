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


public class EasyGame extends JFrame implements Game {

	JPanel userCardsPanel;
	JPanel deskPanel;
	JPanel com1Panel;
	JPanel com2Panel;
	JPanel com3Panel;
	Computer[] coms;
	User me;
	Desk desk;
	LinkedList<Card> allCards,penalties;
	Card card;
	Random rand = new Random();
	Timer timer;
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
	JButton btnNewButton_2;
	boolean ex = false;
	boolean nn = false;
	static boolean flag=true;
	boolean winner = false;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		mainMenu window = new mainMenu();
		window.frame.setVisible(true);
				
		while(flag){
			System.out.println("bekle");
		}
		
		
		
		if(flag == false){
			Game g = new Game();
			g.playGameHard();
		}
	}*/

	/**
	 * Create the frame.
	 */
	public EasyGame() {
		
		initGame();
	}
	
	public void initGame(){
		
		
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 671, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		f.setSize(800,500);
		f.setVisible(true);
		contentPane.setLayout(null);
		userCardsPanel = new JPanel();
		userCardsPanel.setBounds(10, 264, 740, 198);
		userCardsPanel.setLayout(new GridLayout(2,7));
		userCardsPanel.setBackground(new Color(248, 248, 255));
		
		
		deskPanel = new JPanel();
		deskPanel.setBackground(new Color(0, 100, 0));
		deskPanel.setBounds(131, 130, 490, 111);
		
		
		com1Panel = new JPanel();
		com1Panel.setBackground(new Color(0, 128, 0));
		com1Panel.setBounds(631, 110, 119, 111);
		
		
		com2Panel = new JPanel();
		com2Panel.setBackground(new Color(0, 128, 0));
		com2Panel.setBounds(313, 11, 104, 95);
		
		
		com3Panel = new JPanel();
		com3Panel.setBackground(new Color(0, 128, 0));
		com3Panel.setBounds(10, 117, 111, 104);
		
	
		
		me = new User();
		desk = new Desk();
		coms = new Computer[3];	
		coms[0]=new Computer();
		coms[1]=new Computer();
		coms[2]=new Computer();
		
		allCards = new LinkedList<Card>();
		
		for(int n=1;n<14;n++)
		{
			allCards.add(new Card(1,n));
			allCards.add(new Card(2,n));
			allCards.add(new Card(3,n));
			allCards.add(new Card(4,n));
		}
		
		Collections.shuffle(allCards);
		
		for(int i=0;i<13;i++)
		{
			coms[0].getCard(allCards.getFirst());			
			allCards.removeFirst();			
			coms[1].getCard(allCards.getFirst());			
			allCards.removeFirst();	
			coms[2].getCard(allCards.getFirst());			
			allCards.removeFirst();	
			me.getCard(allCards.getFirst());			
			allCards.removeFirst();	
		}
		
		for(int i=0;i<me.getAllCards().size();i++)
		{
			Card cc = me.getAllCards().get(i);
			cc.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					Card c = (Card) e.getSource();
					int id = c.getId();
					int no = c.getNo();
					Card newCard = new Card(no, id);
					//me.giveCard(c);
					//desk.addCardToTable(newCard);
					me.selectCard(c);
						
					userCardsPanel.removeAll();
					//deskPanel.removeAll();
						
					//card = desk.getLastCard();	
					//deskPanel.add(card);
					for(int i=0; i < me.getAllCards().size(); i++)
					{
						userCardsPanel.add(me.getAllCards().get(i));
					}
						
					//deskPanel.repaint();
					userCardsPanel.repaint();
					userCardsPanel.validate();
					}
				});
			
			
			userCardsPanel.add(cc);
		
		}
		card = desk.getLastCard();
		deskPanel.add(card);
		
		contentPane.add(userCardsPanel);
		contentPane.add(deskPanel);
		
		
		btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/0000.gif")));
		com1Panel.add(btnNewButton);
		
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/0001.gif")));
		com2Panel.add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/0002.gif")));
		com3Panel.add(btnNewButton_2);
		
		contentPane.add(com1Panel);
		contentPane.add(com2Panel);
		contentPane.add(com3Panel);
		f.revalidate();
		revalidate();
		
		
	}
	
	public void playGame()
	{
		round = 0;
		while(round < 13)
		{
			// ***COM1'S PLAY TURN***
			deskPanel.validate();
			f.revalidate();
			try {
			    Thread.sleep(1000);                
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			int checkId = -1;
			if(desk.getAllCardsOnTable().size() > 1 )
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[0].getAllCards().size(); i++)
				{
					if(coms[0].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[0].getAllCards().get(index);
					coms[0].giveCard(card0);
					System.out.println("1 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					if(desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-1).getId() == desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-2).getId())

					{
						coms[0].getPenalties(desk.getAllCardsOnTable());
						desk.clearDesk();
					}
					index =rand.nextInt(13-(round));
					Card card0 = coms[0].getAllCards().get(index);
					coms[0].giveCard(card0);
					System.out.println("1 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com1Panel.setBackground(Color.RED);
				com1Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				f.revalidate();
			}
			else if(desk.getAllCardsOnTable().size() == 1)
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[0].getAllCards().size(); i++)
				{
					if(coms[0].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[0].getAllCards().get(index);
					coms[0].giveCard(card0);
					System.out.println("1 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					index =rand.nextInt(13-(round));
					Card card0 = coms[0].getAllCards().get(index);
					coms[0].giveCard(card0);
					System.out.println("1 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com1Panel.setBackground(Color.RED);
				com1Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				f.revalidate();
			}
			else
			{
				int index =rand.nextInt(13-(round));
				Card card0 = coms[0].getAllCards().get(index);
				coms[0].giveCard(card0);
				System.out.println("1 Played******  " + card0.getId());
				desk.addCardToTable(card0);
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com1Panel.setBackground(Color.RED);
				com1Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				f.revalidate();
			}
		

			// ***COM2'S PLAY TURN***
			
			deskPanel.validate();
			f.revalidate();
			try {
			    Thread.sleep(1000);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			checkId = -1;
			if(desk.getAllCardsOnTable().size() > 1 )
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[1].getAllCards().size(); i++)
				{
					if(coms[1].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[1].getAllCards().get(index);
					coms[1].giveCard(card0);
					System.out.println("2 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					if(desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-1).getId() == desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-2).getId())

					{
						coms[1].getPenalties(desk.getAllCardsOnTable());
						desk.clearDesk();
					}
					index =rand.nextInt(13-(round));
					Card card0 = coms[1].getAllCards().get(index);
					coms[1].giveCard(card0);
					System.out.println("2 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com2Panel.setBackground(Color.RED);
				com2Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
			else if(desk.getAllCardsOnTable().size() == 1)
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[1].getAllCards().size(); i++)
				{
					if(coms[1].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[1].getAllCards().get(index);
					coms[1].giveCard(card0);
					System.out.println("2 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					index =rand.nextInt(13-(round));
					Card card0 = coms[1].getAllCards().get(index);
					coms[1].giveCard(card0);
					System.out.println("2 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com2Panel.setBackground(Color.RED);
				com2Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
			else
			{
				int index =rand.nextInt(13-(round));
				Card card0 = coms[1].getAllCards().get(index);
				coms[1].giveCard(card0);
				System.out.println("2 Played******  " + card0.getId());
				desk.addCardToTable(card0);
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com2Panel.setBackground(Color.RED);
				com2Panel.validate();
				com3Panel.setBackground(null);
				com3Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
		
			
			// ***COM3'S PLAY TURN***

			deskPanel.validate();
			f.revalidate();
			try {
			    Thread.sleep(1000);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			checkId = -1;
			if(desk.getAllCardsOnTable().size() > 1 )
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[2].getAllCards().size(); i++)
				{
					if(coms[2].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[2].getAllCards().get(index);
					coms[2].giveCard(card0);
					System.out.println("3 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					if(desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-1).getId() == desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-2).getId())
					{
						coms[2].getPenalties(desk.getAllCardsOnTable());
						desk.clearDesk();
					}
					index =rand.nextInt(13-(round));
					Card card0 = coms[2].getAllCards().get(index);
					coms[2].giveCard(card0);
					System.out.println("3 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com3Panel.setBackground(Color.RED);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
			else if(desk.getAllCardsOnTable().size() == 1)
			{
				checkId = desk.getLastCard().getId();
				int index = -1;
				boolean checked = false;
				for(int i = 0; i < coms[2].getAllCards().size(); i++)
				{
					if(coms[2].getAllCards().get(i).getId() == checkId)
					{
						index = i;
						checked = true;
					}
				}
				if(checked == true)
				{
					Card card0 = coms[2].getAllCards().get(index);
					coms[2].giveCard(card0);
					System.out.println("3 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				else
				{
					index =rand.nextInt(13-(round));
					Card card0 = coms[2].getAllCards().get(index);
					coms[2].giveCard(card0);
					System.out.println("3 Played******  " + card0.getId());
					desk.addCardToTable(card0);
				}
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com3Panel.setBackground(Color.RED);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
			else
			{
				int index =rand.nextInt(13-(round));
				Card card0 = coms[2].getAllCards().get(index);
				coms[2].giveCard(card0);
				System.out.println("3 Played******  " + card0.getId());
				desk.addCardToTable(card0);
				deskPanel.removeAll();
				card = desk.getLastCard();	
				deskPanel.add(card);
				deskPanel.repaint();
				com3Panel.setBackground(Color.RED);
				com3Panel.validate();
				com2Panel.setBackground(null);
				com2Panel.validate();
				com1Panel.setBackground(null);
				com1Panel.validate();
				f.revalidate();
			}
			
			
			//deskPanel.validate();
			
			try {
			    Thread.sleep(1000);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			com3Panel.setBackground(null);
			com3Panel.validate();
			com2Panel.setBackground(null);
			com2Panel.validate();
			com1Panel.setBackground(null);
			com1Panel.validate();
			f.revalidate();
			me.setTurn(true);
			while(me.getTurn() == true)
			{				
				if(desk.getAllCardsOnTable().size() > 1 ){
					
					for(int i=0; i < me.getAllCards().size(); i++)
					{
						if(me.getAllCards().get(i).getSelected() == true){
							Card c = me.getAllCards().get(i);
							me.giveCard(c);
							if((desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-1).getId() == desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-2).getId())&&(c.getId()!=desk.getAllCardsOnTable().get(desk.getAllCardsOnTable().size()-1).getId()))
							{
								me.getPenalties(desk.getAllCardsOnTable());
								desk.clearDesk();
							}
							System.out.println("Me Played******  " + c.getId());
							int id = c.getId();
							int no = c.getNo();
							Card newCard = new Card(no, id);
							desk.addCardToTable(newCard);
							break;
						}
					}
				}
				else{
					for(int i=0; i < me.getAllCards().size(); i++)
					{
						if(me.getAllCards().get(i).getSelected() == true){
							Card c = me.getAllCards().get(i);
							me.giveCard(c);
							System.out.println("Me Played******  " + c.getId());
							int id = c.getId();
							int no = c.getNo();
							Card newCard = new Card(no, id);
							desk.addCardToTable(newCard);
							break;
						}
					}
				}
				
			}
			
			deskPanel.removeAll();
			card = desk.getLastCard();	
			deskPanel.add(card);
			deskPanel.repaint();
			com3Panel.setBackground(null);
			com3Panel.validate();
			com2Panel.setBackground(null);
			com2Panel.validate();
			com1Panel.setBackground(null);
			com1Panel.validate();
			f.revalidate();
	
			round++;
			System.out.println();

		}
		
		
		System.out.println("END****Left cards: "+coms[0].getAllCards().size());
		System.out.println();
		System.out.print("Penalties of COM1 " );
		for(int i = 0; i < coms[0].getAllPenalties().size(); i++){
			System.out.print(coms[0].getAllPenalties().get(i).getId() + " ");
		}
		System.out.println();
		System.out.print("Penalties of COM2 " );
		for(int i = 0; i < coms[1].getAllPenalties().size(); i++){
			System.out.print(coms[1].getAllPenalties().get(i).getId() + " ");
		}
		System.out.println();
		System.out.print("Penalties of COM3 " );
		for(int i = 0; i < coms[2].getAllPenalties().size(); i++){
			System.out.print(coms[2].getAllPenalties().get(i).getId() + " ");
		}
		System.out.println();
		System.out.print("Penalties of ME " );
		for(int i = 0; i < me.getAllPenalties().size(); i++){
			System.out.print(me.getAllPenalties().get(i).getId() + " ");
		}
		
		showWinner();
		
		System.out.println("***EASY***");
	
	}
	
	public void showWinner()
	{
		Winner win = new Winner(me, coms[0], coms[1], coms[2]);
		int in = win.getIndex();
		int pe = win.getPenalty();
		int[] arr = win.getPenalties();
	
		if(in == 0){
			label= new JLabel("YOU WIN WITH " + pe + " PENALTY POINTS \t\t\t\t\n\n" );
			//label.setBounds(100, 100, 100, 100);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_1= new JLabel("Penalty of AHMET CAKAR \t" + arr[1] + "\t\t\t\t\n\n" );
			label_1.setForeground(Color.cyan);
			lblNewLabel= new JLabel("Penalty of YILMAZ VURAL \t" + arr[2] + "\t\t\t\t\n\n" );
			lblNewLabel.setForeground(Color.cyan);
			lblNewLabel_1= new JLabel("Penalty of ADNAN HOCA \t" + arr[3] + "\t\t\t\t\n\n" );
			lblNewLabel_1.setForeground(Color.cyan);
			winner = true;
		}
		else if(in == 2){
			label= new JLabel("YILMAZ VURAL WINS WITH " + pe + " PENALTY POINTS \t\t\t\t\n\n" );
			//label.setBounds(100, 100, 100, 100);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label_1= new JLabel("Your penalty \t" + arr[0] + "\t\t\t\t\n\n" );
			label_1.setForeground(Color.cyan);
			lblNewLabel= new JLabel("Penalty of AHMET CAKAR \t" + arr[1] + "\t\t\t\t\n\n" );
			lblNewLabel.setForeground(Color.cyan);
			lblNewLabel_1 = new JLabel("Penalty of ADNAN HOCA \t" + arr[3] + "\t\t\t\t\n\n" );
			lblNewLabel_1.setForeground(Color.cyan);
		}
		else if(in == 1){
			label = new JLabel("AHMET CAKAR WINS WITH " + pe + " PENALTY POINTS \t\t\t\t\n\n" );
			//label.setBounds(100, 100, 100, 100);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_1= new JLabel("Your penalty \t" + arr[0] + "\t\t\t\t\n\n" );
			label_1.setForeground(Color.cyan);
			lblNewLabel= new JLabel("Penalty of YILMAZ VURAL \t" + arr[2] + "\t\t\t\t\n\n" );
			lblNewLabel.setForeground(Color.cyan);
			lblNewLabel_1= new JLabel("Penalty of ADNAN HOCA \t" + arr[3] + "\t\t\t\t\n\n" );
			lblNewLabel_1.setForeground(Color.cyan);
		}
		else{
			label= new JLabel("ADNAN HOCA WINS WITH " + pe + " PENALTY POINTS \t\t\t\t\n\n" );
			//label.setBounds(100, 100, 100, 100);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_1= new JLabel("Your penalty \t" + arr[0] + "\t\t\t\t\n\n");
			label_1.setForeground(Color.cyan);
			lblNewLabel= new JLabel("Penalty of AHMET CAKAR \t" + arr[1] + "\t\t\t\t\n\n" );
			lblNewLabel.setForeground(Color.cyan);
			lblNewLabel_1= new JLabel("Penalty of YILMAZ VURAL \t" + arr[2] + "\t\t\t\t\n\n" );
			lblNewLabel_1.setForeground(Color.cyan);
		}	
		
		ng = new JButton("NEW GAME");
		ng.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				nn = true;
				f.dispose();
				if(winner == true){
					URL url1;
					try {
						url1 = new URL("http://localhost/dirty3/update.php");
						openWebpage(url1);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				}
				//f.hide();
				/*try {
					Process process = new ProcessBuilder("C:\\Users\\User\\Desktop\\furkan.jar","param1","param2").start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}*/
				}
			});
		//ng.addActionListener(this);
		exB = new JButton("EXIT");
		exB.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ex = true;
				if(winner == true){
					URL url1;
					try {
						url1 = new URL("http://localhost/dirty3/update.php");
						openWebpage(url1);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				}
				
				System.exit(1000);
			}
		});
		//exB.addActionListener(this);
		deskPanel.removeAll();
		//deskPanel.setLayout(new GridLayout());
		deskPanel.add(exB);
		deskPanel.add(ng);
		deskPanel.add(label);
		deskPanel.add(label_1);
		deskPanel.add(lblNewLabel);
		deskPanel.add(lblNewLabel_1);
		deskPanel.repaint();
		deskPanel.validate();
		f.revalidate();
		
	}
	public boolean isNewGame()
	{
		return nn;
	}
	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
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
}
