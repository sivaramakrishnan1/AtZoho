class Book {
	private String title, author;
	double price;
	
	Book(String title, Author author, double price) {
		this.title = title;
		this.author = author.toString();
		this.price = price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() { 
		return this.author;
	}
	
	public double getPrice() { 
		return this.price;
	}
	
	@Override
	public String toString() {
		String res = "\nBook title: " + title + "\nAuthor: " + author + "\nPrice: " + price;
		return res;
	}
}