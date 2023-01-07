import java.io.*;

public class Admin implements Serializable {
    private int id;
    private String password;

    Admin(int id, String password)
    {
        this.id = id;
        this.password = encryptPassword(password);
    }

    public int getId() {
        return id;
    }

    public boolean authenticate(String password)
	{
		password = encryptPassword(password);
		return password.equals(this.password);
	}

    public String encryptPassword(String password)
	{
		String encrypted = "";
		
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(password.charAt(i) == 'z') encrypted += "a";
			else if(password.charAt(i) == 'Z') encrypted += "A";
			else if(password.charAt(i) == '9') encrypted += "0";
			else encrypted += (char)(password.charAt(i) + 1);			
 		}
		
		return encrypted;
	}
}
