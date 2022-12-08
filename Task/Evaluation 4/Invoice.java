class Invoice
{
	private String number, description;
	private int quantity;
	private double price;
	
	Invoice(String number, String description, int quantity, double price)
	{
		this.number = number;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public void setNumber(String n)
	{
		number = n;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String d)
	{
		description = d;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int q)
	{
		quantity = q;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(int p)
	{
		price = p;
	}
	
	public double getInvoiceAmount()
	{
		return price * (double)quantity;
	}
}