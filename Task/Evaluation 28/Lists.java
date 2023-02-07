import java.util.HashMap;
import java.io.*;	

class Lists implements Serializable
{
	int id;
	String name;
	HashMap<Integer, Card> cards = new HashMap<>();
	
	Lists(int id, String name)
	{
		this.id = id;
		this.name = name;
		System.out.println("List created : " + this.id);
	}
	
	public boolean addCard(int id, Card card)
	{
		try {
			cards.put(id, card);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void printCards()
	{
		for(Card card : cards.values())
		{
			System.out.println(card.toString());
		}
	}
	
	public String toString()
	{
		return "ID : L" + this.id + " Name : " + this.name + " Total cards : " + cards.size();
	}
}