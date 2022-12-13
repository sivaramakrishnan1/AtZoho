package BookShop;

// java bookshop.Interface.Interface
import BookShop.Books;
import BookShop.Album;
import java.util.Scanner;

 class Interface
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		Books bookData[] = new Books[10];
		Album albumData[] = new Album[10];
		int b = 0, a = 0;

		for (int i = 0; i < 3; i++) {
			System.out.println("1. Book 2. Album");
			if(s.nextInt() == 1)
			{
				s.nextLine();
				System.out.println("\nEnter the Title: ");
				String name = s.nextLine();
				System.out.println("\nEnter the Author: ");
				String author = s.nextLine();
				System.out.println("\nEnter the Genre: ");
				String genre = s.nextLine();
				System.out.println("\nEnter the Price: ");
				double rate = s.nextDouble();

				bookData[b++] = new Books(name, author, genre, rate);
			}
			else 
			{
				s.nextLine();
				System.out.println("Enter the Title: ");
				String name = s.nextLine();
				System.out.println("\nEnter the Author: ");
				String artist = s.nextLine();
				System.out.println("\nEnter the Genre: ");
				String genre = s.nextLine();
				System.out.println("\nEnter the Duration: ");
				double duration = s.nextDouble();
				System.out.println("\nEnter the Price: ");
				double rate = s.nextDouble();

				albumData[a++] = new Album(name, artist, genre, rate, duration);
			}
		}
		String temp = "=========================================";
		
		System.out.format("%10s", temp);
		System.out.println("\nBooks ... ");
		for (int i = 0; bookData[i] != null; i++) {
			System.out.println(bookData[i].toString());
		}

		System.out.format("%10s", temp);

		System.out.println("\n\nAlbums ... ");
		for (int i = 0; albumData[i] != null; i++) {
			System.out.println(albumData[i].toString());
		}
		
		System.out.format("%10s", temp);
		
		s.close();
	}
}