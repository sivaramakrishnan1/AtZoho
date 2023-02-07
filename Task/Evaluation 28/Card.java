import java.io.*;	
class Card implements Serializable
{
	int id;
	String name, description;
	User assignedUser;
	
	Card(int id, String name)
	{
		this.id = id;
		this.name = name;
		System.out.println("Card created : " + this.id);
	}
	
	public String toString()
	{
		return "Id : C" + this.id + " Card Name : " + name + " Description : " + description + " AssignedUser : " + assignedUser.email;
	}
	
}