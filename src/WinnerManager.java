import java.util.LinkedList;


public class WinnerManager {
	
	User u;
	Computer c1, c2, c3;
	int[] penalties;
	
	public WinnerManager(User u, Computer c1, Computer c2, Computer c3){
		this.u = u;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		penalties = new int[4];
	}
	
	public int[] CalculatePenalties()
	{
		for(int i = 0; i < u.getAllPenalties().size(); i++)
		{
			penalties[0] += u.getAllPenalties().get(i).getId();
		}
		for(int i = 0; i < c1.getAllPenalties().size(); i++)
		{
			penalties[1] += c1.getAllPenalties().get(i).getId();
		}
		for(int i = 0; i < c2.getAllPenalties().size(); i++)
		{
			penalties[2] += c2.getAllPenalties().get(i).getId();
		}
		for(int i = 0; i < c3.getAllPenalties().size(); i++)
		{
			penalties[3] += c3.getAllPenalties().get(i).getId();
		}
		return penalties;
		
	}
	
	public int GetWinnerIndex()
	{
		int minIndex = 0;
		int min = 1000000000;
		for(int i = 0; i < 4; i++)
		{
			if(penalties[i]<min){
				min = penalties[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public int GetWinnerPenalty()
	{
		//int minIndex = 0;
		int min = 1000000000;
		for(int i = 0; i < 4; i++)
		{
			if(penalties[i]<min){
				min = penalties[i];
				//minIndex = i;
			}
		}
		return min;
	}

}

