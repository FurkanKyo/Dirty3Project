import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Winner {
	
	WinnerManager wm;
	JLabel l1, l2, l3, l4;
	JFrame frame;
	int[] arr;
	int index;
	int penalty;
	
	public Winner(User u, Computer c1, Computer c2, Computer c3){
		
	
		wm = new WinnerManager(u, c1, c2, c3);
		arr = wm.CalculatePenalties();
		index = wm.GetWinnerIndex();
		penalty = wm.GetWinnerPenalty();
	}
	 
	public int getIndex(){
		return index;
	}
	
	public int getPenalty(){
		return penalty;
	}
	
	public int[] getPenalties(){
		return arr;
	}


}
