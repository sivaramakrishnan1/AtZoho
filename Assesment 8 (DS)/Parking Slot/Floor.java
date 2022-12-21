class Floor
{
	private Slot[] slots;
	
	Floor(int slotNumber)
	{
		if(slotNumber > -1) 
		{
			slots = new Slot[slotNumber];	
			
			for(int i = 0 ; i < slotNumber ; i++)
			{
				slots[i] = new Slot();
				if(i == 0) slots[i].setType(0);
				else if(i == 1 || i == 2) slots[i].setType(1);
				else slots[i].setType(2);
			}
		}
	}
	
	public String intTypeToString(int type)
	{
		if(type == 0) 
			return "Truck";
		else if(type == 1)
			return "Bike";
		else 
			return "Car";
	}
	
	public boolean parkVehicle(Vehicle v, String ticket)
	{
		int type = v.getType();
		
		for(int i = 0 ; i < slots.length ; i++)
		{
			if(slots[i].getType() == type && slots[i].isFree()){
				if(slots[i].parkVehicle(v, ticket +"_"+(i+1)))
					System.out.println("Parked Vehicle. Ticket ID: " + ticket +"_"+(i+1));
				return true;
			}
		}
		return false;
	}
	
	public boolean unparkVehicle(String ticket, int atSlot)
	{
		for(int i = 0 ; i < slots.length ; i++)
		{
			System.out.println(!slots[i].isFree() + " " + slots[i].getTicket() + " " + ticket);
			if(!slots[i].isFree() && (slots[i].getTicket().intern()).equals(ticket.intern()))
			{
				if(slots[atSlot-1].unparkVehicle())
				{
					System.out.println("Unparked Vehicle");
					return true;
				}
			}
		}
				
		return false;
	}
	
	public boolean unparkVehicle(int slot)
	{
		if(slots[slot-1].unparkVehicle())
		{
			System.out.println("Unparked Vehicle");
			return true;
		}
		
		return false;
	}
	
	public int freeCount(int type)
	{
		int count = 0;
		
		for(int i = 0 ; i < slots.length ; i++)
		{
			if(slots[i].isFree() && slots[i].getType() == type) count++;			
		}
		return count;
	}
	
	public void freeSlots(int type, int floorNum)
	{
		String t = intTypeToString(type);
		
		System.out.print("Free slots for " + t + " on Floor " + floorNum + " : ");
		
		for(int i = 0 ; i < slots.length ; i++)
		{
			if(slots[i].isFree() && slots[i].getType() == type) 
				System.out.print((i+1) + " ");			
		}
	}
	
	public void occupiedSlots(int type, int floorNum)
	{
		String t = intTypeToString(type);
		
		System.out.print("Occupied slots for " + t + " on Floor " + floorNum + " : ");
		
		for(int i = 0 ; i < slots.length ; i++)
		{
			if(!(slots[i].isFree()) && slots[i].getType() == type)
				System.out.print(i + " ");			
		}
	}
}