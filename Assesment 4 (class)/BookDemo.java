// imoprt java.util.Scanner;

class BookDemo
{
	public static void main(String args[])
	{
		// Scanner s = new Scanner(System.in);
		
		Author author = new Author("Russel", "Winderland");
		Book book = new Book("Developing Java Software", author, 79.75);
		
		System.out.println(book.toString());
		// s.close();		
	}
}