import java.io.*;	
class User implements Serializable
{
	int id;
	String name, email;
	
	User(int id, String name, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		System.out.println("User created : " + this.id);
	}
}