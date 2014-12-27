
import java.util.LinkedList;



public class User {

	LinkedList<Card> mycards,mypenalties;
	int score;
	boolean turn;
	String level;
	
	
	public User()
	{
		mycards=new LinkedList<Card>();
		mypenalties=new LinkedList<Card>();
		score = 0;
		turn = false;
		level = "easy";
		
	}
	public String getLevel()
	{
		return level;
	}
	public void setLevel(String lev)
	{
		level = lev;
	}
	public void getCard(Card c)
	{
		mycards.add(c);
		
	}
	public void giveCard(Card c)
	{
		mycards.remove(c);
		turn = false;
	}
	public Card giveLastCard()
	{
		Card c = mycards.getLast();
		mycards.removeLast();
		return c;
		
	}
	public void getPenalties(LinkedList<Card> g)
	{	
		mypenalties.addAll(g);
		
	}
	public Card getLastCard()
	{
		return mycards.getLast();
		
	}
	public LinkedList<Card> getAllCards(){
		return mycards;
	}
	public LinkedList<Card> getAllPenalties(){
		return mypenalties;
	}
	public int getScore()
	{
		return score;
	}
	public void selectCard(Card c)
	{
		for(int i=0; i < mycards.size(); i++)
		{
			if(mycards.get(i)==c){
				mycards.get(i).setSelected(true);
			}
		}
	}
	public boolean getTurn()
	{
		return turn;
	}
	public void setTurn(boolean boo)
	{
		turn = boo;
	}
	
	
}