import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class MainStarter extends JFrame{
	
	public static void main(String[] args) {
		
		boolean newGame = true;
		while(newGame){
			mainMenu window = new mainMenu();
			window.frame.setVisible(true);
			while(!window.getLChoice()){
				System.out.println();
			}
			if(window.getLChoice()){
				lchoice dialog = new lchoice();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				window.frame.hide();
				dialog.setVisible(true);
				
				while(!dialog.getStarter()){
					System.out.println();
				}
				
				if(dialog.getEasy()){
					Game g = new EasyGame();
					g.playGame();
					while(!g.isNewGame()){
						System.out.println();
					}
					newGame = g.isNewGame();
				}
				if(dialog.getHard()){
					Game g = new HardGame();
					g.playGame();
					while(!g.isNewGame()){
						System.out.println();
					}
					newGame = g.isNewGame();
				}
			}
	
		}
				
	}
	
}


