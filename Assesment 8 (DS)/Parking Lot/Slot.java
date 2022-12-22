class Slot
{
	private boolean isfree = true;
	private Vehicle v = null;
	private int type;
	
	public boolean isFree()
	{
		return isfree;
	}
	
	public String getTicket()
	{
		if(!this.isFree())
			return v.getTicket();
		return "";
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public boolean parkVehicle(Vehicle v, String ticket)
	{
		if(isfree)
		{
			this.v = v;
			this.v.setTicket(ticket);
			this.isfree = false;
			return true;
		}
		return false;
	}
	
	public boolean unparkVehicle()
	{
		if(!isfree)
		{
			v = null;
			this.isfree = true;
			return true;
		}
		return false;
	}
}