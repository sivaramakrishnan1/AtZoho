package BookShop;

// java bookshop.Interface.Interface
import BookShop.Data;
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
				System.out.println("Enter the Title, Author name, Genre and rate of the book:");
				String name = s.next();
				String author = s.next();
				String genre = s.next();
				System.out.println(name +  genre + author);
				double rate = s.nextDouble();

				bookData[b++] = new Books(name, author, genre, rate);
			}
			else 
			{
				System.out.println("Enter the Title, Artist name, Genre, duration and rate of the album:");
				String name = s.nextLine(), artist = s.nextLine(), genre = s.nextLine();
				double duration = s.nextDouble(), rate = s.nextDouble();

				albumData[a++] = new Album(name, artist, genre, duration, rate);
			}
		}

		System.out.println("Books ... ");
		for (int i = 0; bookData[i] != null; i++) {
			System.out.println(bookData[i].toString());
		}

		System.out.println("Albums ... ");
		for (int i = 0; albumData[i] != null; i++) {
			System.out.println(albumData[i].toString());
		}
		s.close();
	}
}