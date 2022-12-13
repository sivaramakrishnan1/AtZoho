package BookShop;

public class Data {
	static int id = 1;
	private String title, genre;
	private double rate;

	Data(String title, String genre, double rate)
	{
		this.title = title;
		this.genre = genre;
		this.rate = rate;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public double getRate() {
		return rate;
	}
}

class Books extends Data
{
	private int itemId;
	private String authors;
	
	Books(String title, String authors, String genre, double rate)
	{
		super(title, genre, rate);
		itemId = id++;
		this.authors = authors;
	}
	
	@Override
	public String toString()
	{
		String ret = "(" + itemId + ") " + "\"" + getTitle() + "\" by " + authors + ", " + getGenre() + ", $" + getRate();
		return ret;
	}
}

class Album extends Data
{
	private int itemId;
	private String artist;
	private double duration;
	
	Album(String title, String artist, String genre, double rate, double duration)
	{
		super(title, genre, rate);
		itemId = id++;
		this.artist = artist;
		this.duration = duration;
	}
	
	@Override
	public String toString()
	{
		String ret = "(" + itemId + ") " + "\"" + getTitle() + "\" by " + artist + ", " + duration + " minutes of " + getGenre() + ", $" + getRate();
		return ret;
	}
}