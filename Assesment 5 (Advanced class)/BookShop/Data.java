package bookshop.Data;

public class Data {
	static int id = 1;

	class Books
	{
		private int itemId;
		private String title, authors, genre;
		private double rate;
		
		Books(String title, String authors, String genre, double rate)
		{
			itemId = id++;
			this.title = title;
			this.authors = authors;
			this.genre = genre;
			this.rate = rate;
		}
		
		public String toString()
		{
			String ret = "(" + itemId + ") " + "\"" + title + "\" by " + authors + ", " + genre + ", $" + rate;
			return ret;
		}
	}
	
	class Album
	{
		private int itemId;
		private String title, artist, genre;
		private double duration, rate;
		
		Album(String title, String artist, String genre, double rate, double duration)
		{
			itemId = id++;
			this.title = title;
			this.artist = artist;
			this.genre = genre;
			this.rate = rate;
			this.duration = duration;
		}
		
		public String toString()
		{
			String ret = "(" + itemId + ") " + "\"" + title + "\" by " + artist + ", " + duration + " minutes of " + genre + ", $" + rate;
			return ret;
		}
	}
}