package Parking;

class Lot
{
	private String lotName;
	private Floor[] floors;
	
	Lot(String name, int floorCount, int slotCount) 
	{
		this.lotName = name;
		floors = new Floor[floorCount];
		
		for(int i = 0 ; i < floorCount ; i++)
		{
			floors[i] = new Floor(slotCount);
		}
	}
	
	public void freeCount(int type)
	{
		for(int i = 0 ; i < floors.length ; i++)
		{
			String t = intTypeToString(type);
			System.out.println("No. of free slots for " + t + " on Floor " + i + " : " + floors[i].freeCount(type));
		}
	}
	
	public void freeSlots(int type)
	{
		for(int i = 0 ; i < floors.length ; i++)
		{
			floors[i].freeSlots(type, i);
			System.out.println();
		}
	}
	
	public void parkVehicle(Vehicle v)
	{
		for(int i = 0 ; i < floors.length ; i++)
		{
			if(floors[i].parkVehicle(v, lotName+"_"+(i+1)))
				return;
		}
		
		System.out.println("Parking Lot is Full");
	}
	
	public void unparkVehicle(int floor, int slot)
	{
		if(floors[floor-1].unparkVehicle(slot))
			return;
			
		System.out.println("No such ticket/vehicle found");
	}
	
	public void unparkVehicle(String ticket)
	{
		String[] part = ticket.split("_");
		for(String s: part)
		{
			System.out.println(s);
		}
		
		if(floors[Integer.parseInt(part[1]) -1].unparkVehicle(ticket, Integer.parseInt(part[2])))
				return;
			
		System.out.println("No such ticket/vehicle found");
	}
	
	public void occupiedSlots(int type)
	{
		for(int i = 0 ; i < floors.length ; i++)
		{
			floors[i].occupiedSlots(type, i);
			System.out.println();
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
}