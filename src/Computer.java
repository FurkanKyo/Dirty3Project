import java.util.LinkedList;


public class Computer{

	LinkedList<Card> comcards,compenalties;
	int score;
	
	public Computer()
	{
		comcards=new LinkedList<Card>();
		compenalties=new LinkedList<Card>();
		score = 0;
	}
	
	public void getCard(Card c)
	{
		comcards.add(c);
		
	}
	public void giveCard(Card c)
	{
		comcards.remove(c);
	}
	public Card giveLastCard()
	{
		Card c = comcards.getLast();
		comcards.removeLast();
		return c;
		
	}
	public void getPenalties(LinkedList<Card> g)
	{	
		compenalties.addAll(g);
		
	}
	public Card getLastCard()
	{
		return comcards.getLast();
		
	}
	public LinkedList<Card> getAllCards(){
		return comcards;
	}
	public LinkedList<Card> getAllPenalties(){
		return compenalties;
	}
	public int getScore()
	{
		return score;
	}
	
}