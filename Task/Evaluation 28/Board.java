import java.util.HashMap;
import java.io.*;	

class Board implements Serializable
{
	int id;
	String name, url;
	boolean isPrivate = false;
	HashMap<Integer, User> members = new HashMap<>();
	HashMap<Integer, Lists> lists = new HashMap<>();
	
	Board(int id, String name)
	{
		this.id = id;
		this.name = name;
		System.out.println("Board created : " + this.id);
	}
	
	public void addMembers(int id, User user)
	{
		members.put(id, user);
	}
	
	public void addList(int id, Lists list)
	{
		lists.put(id, list);
	}
	
	public void printLists()
	{
		for(Lists list : lists.values())
		{
			System.out.println(list.toString());
		}
	}
	
	public String toString()
	{
		return "Id : " + id + " Board name : " + name + " Privacy : " + ((isPrivate) ? "PRIVATE" : "PUBLIC") +" URL : " + url + " Members count : " + members.size() + " Lists count : " + lists.size();
	}
}