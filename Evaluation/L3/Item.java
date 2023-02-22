class Item
{
	int prodId;
	String prodName;
	double price;
	
	Item(int id, String name, double price)
	{
		this.prodId = id;
		this.prodName = name;
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return String.format("%5s%15s%10s", prodId, prodName, price);
	}
}