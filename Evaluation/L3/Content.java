class Content
{
	int contentId, invoiceId;
	String prodName;
	double price, total, quantity;
	
	Content(int contentId, int invoiceId, String prodName, double price, double quantity)
	{
		this.contentId = contentId;
		this.invoiceId = invoiceId;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
		total = quantity * price;
	}
	
	@Override
	public String toString()
	{
		return String.format("|%15s|%10s|%5s|%10s|", prodName, price, quantity, total);	
	}
}