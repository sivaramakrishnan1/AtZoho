import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String password;
    private Book[] borrowedBooks = new Book[5];

    User(int id, String password) {
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

    public boolean addBook(Book b)
    {
        for(int i = 0 ; i < borrowedBooks.length ; i++)
        {
            if(borrowedBooks[i] == null)
            {
                updateFile(b.toStringUser() + "\tBorrowed");
                borrowedBooks[i] = b;
                return true;
            }
        }
        return false;
    }

    public Book removeBook(String copyId)
    {
        for(int i = 0 ; i < borrowedBooks.length ; i++)
        {
            if(borrowedBooks[i] != null && borrowedBooks[i].getCopyId().equals(copyId))
            {
                updateFile(borrowedBooks[i].toStringUser() + "\tReturned");
                Book b = borrowedBooks[i];
                borrowedBooks[i] = null;
                return b;
            }
        }
        return null;
    }

    public boolean isFull()
    {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if(borrowedBooks[i] == null)
                return false;
        }
        return true;
    }

    public void viewBorrowedBooks() 
    {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if(borrowedBooks[i] != null)
                System.out.println(borrowedBooks[i].toStringUser());
        }
    }

    public void updateFile(String msg)
    {
        try (FileWriter writer = new FileWriter("Files\\" + id + ".txt", true)) {
            writer.write(msg);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error with updating file : " + e);
        }
    }
}
