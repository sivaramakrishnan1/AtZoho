class Vehicle 
{
	private int type = -1;
	private String number = "", color = "", ticket = "";
	
	Vehicle(int t, String n, String c)
	{
		this.type = t;
		this.number = n;
		this.color = c;
	}
	
	public int getType()
	{
		return type;
	}
	
	public String getTicket()
	{
		return ticket;
	}
	
	public void setTicket(String ticket)
	{
		this.ticket = ticket;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return type + " : " + number + " : " + color + " ";
	}
}