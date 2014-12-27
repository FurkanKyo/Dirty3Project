import java.util.LinkedList;

public class Desk{
	
	//User me;
	//Computer[] coms;
	LinkedList<Card> cardsOnTable, penaltiesOnTable;
	int round;
	Card lastCardOnTable;
	
	public Desk()
	{
		cardsOnTable = new LinkedList<Card>();
		penaltiesOnTable = new LinkedList<Card>();
		round=0;
		lastCardOnTable = new Card(0,0);
	}
	public Card getLastCard()
	{
		return lastCardOnTable;
	}
	public LinkedList<Card> getAllCardsOnTable()
	{
		return cardsOnTable;
	}
	public LinkedList<Card> getAllPenaltiesOnTable()
	{
		return penaltiesOnTable;
	}
	public int getRound()
	{
		return round;
	}
	public void addCardToTable(Card c)
	{
		cardsOnTable.add(c);
		lastCardOnTable = c;
	}
	public void removeCardFromTable(Card c)
	{
		cardsOnTable.remove(c);
	}
	public void updateLastCard(Card c)
	{
		lastCardOnTable = c;
	}
	public void clearDesk()
	{
		cardsOnTable.clear();
	}



}