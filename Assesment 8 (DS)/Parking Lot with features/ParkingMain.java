package Parking;
import java.util.Scanner;

class ParkingMain implements Runnable
{
	static int chooser = 0;
	static Lot lot = null;
	
	public static void main(String[] args)
	{
		ParkingMain parking = new ParkingMain();
		System.out.println("1. Numerical CLI\n2. Coding CLI");
		Scanner s = new Scanner(System.in);
		
		switch(s.nextInt())
		{
			case 1 : parking.menu(); break;
			case 2 : parking.menu2(); break;
			default : System.out.println("Invalid");
		}
		
	}
	
	@Override
	public void run()
	{		
		switch(chooser)
		{
			case 0 : lot.freeCount(0); lot.freeCount(1); lot.freeCount(2); break;
			case 1 : lot.freeSlots(0); lot.freeSlots(1); lot.freeSlots(2); break;
			case 2 : lot.occupiedSlots(0); lot.occupiedSlots(1); lot.occupiedSlots(2); break;
		}
		chooser++;
	}
	
	public void menu2()
	{
		Scanner s = new Scanner(System.in);
		boolean loop = true;
		
		String lotName = "Command: ";
		while (loop) {
			System.out.print(lotName);
			String[] cmd = (s.nextLine()).split(" ");
			switch(cmd[0])
			{
				case "create_parking_lot" :
				{
					lotName = "\n" + cmd[1] + ":\\> ";
					lot = new Lot(cmd[1],  Integer.parseInt(cmd[2]),  Integer.parseInt(cmd[3]));
					break;
				}
				
				case "display":
				{
					if(lot == null) {System.out.println("LOT_NOT_FOUND"); break;}
					switch(cmd[1])
					{
						case "all": 
						{
							ParkingMain main = new ParkingMain();
							main.run();
							main.run();
							main.run();
							main = null;
							chooser = 0;
							break;
						}
						
						case "free_count" :
						{
							switch(intType(cmd[2]))
							{
								case 1 : lot.freeCount(0); break;
								case 2 : lot.freeCount(1); break;
								case 3 : lot.freeCount(2); break;
								default : System.out.println("COMMAND_INVALID");
							}
							break;
						}
						case "free_slots" : 
						{
							switch(intType(cmd[2]))
							{
								case 1 : lot.freeSlots(0); break;
								case 2 : lot.freeSlots(1); break;
								case 3 : lot.freeSlots(2); break;
								default : System.out.println("COMMAND_INVALID");
							}
							break;
						}
						case "occupied_slots" :
						{
							switch(intType(cmd[2]))
							{
								case 1 : lot.occupiedSlots(0); break;
								case 2 : lot.occupiedSlots(1); break;
								case 3 : lot.occupiedSlots(2); break;
								default : System.out.println("COMMAND_INVALID");
							}
							break;
						}
						default : System.out.println("COMMAND_INVALID");
					}
					break;
				}
				
				case "park_vehicle" :
				{
					if(lot == null) {System.out.println("LOT_NOT_FOUND"); break;}
					Vehicle v = new Vehicle(intType(cmd[1])-1,cmd[2], cmd[3]);					
					lot.parkVehicle(v);
					break;
				}
				
				case "unpark_vehicle" :
				{
					if(lot == null) {System.out.println("LOT_NOT_FOUND"); break;}
					int floor = Integer.parseInt((cmd[1].split("_"))[1]);
					int slot = Integer.parseInt((cmd[1].split("_"))[2]);
					lot.unparkVehicle(floor, slot);
					break;
				}			
				
				case "exit" : {
					loop = false;
					break;
				}
				
				default : System.out.println("COMMAND_INVALID");
			}
		}		
	}
	
	public int intType(String type)
	{
		switch(type)
		{
			case "TRUCK" : return 1;
			case "BIKE" : return 2;
			case "CAR" : return 3;
			default : return 3;
		}
	}
	
	public void menu()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the lot name: ");
		String lotName = s.next();
		
		System.out.println("Enter number of floors and slots: ");
		int floors = s.nextInt(), slots = s.nextInt();
		
		Lot lot = new Lot(lotName, floors, slots);
		
		System.out.println("Lot created for " + lotName + "\n\n");
		
		int choice = 0;
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\nThe Parking Lot : " + lotName);
			System.out.println("1. Free count \n2. Free slots \n3. Occupied slots \n4. Park vehicle \n5. Un-park vehicle\n6. Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1 :
				{
					System.out.println("Enter the type of vehicle: \n1. Truck\n2. Bike \n3. Car");
					lot.freeCount(s.nextInt() -1);
					break;
				}
				
				case 2 :
				{
					System.out.println("Enter the type of vehicle: \n1. Truck\n2. Bike \n3. Car");
					lot.freeSlots(s.nextInt() -1);
					break;
				}
				
				case 3 :
				{
					System.out.println("Enter the type of vehicle: \n1. Truck\n2. Bike \n3. Car");
					lot.occupiedSlots(s.nextInt() -1);
					break;
				}
				
				case 4:
				{
					System.out.println("Enter the type of vehicle: \n1. Truck\n2. Bike \n3. Car");
					int type = s.nextInt();
					
					System.out.println("Enter the vehicle Number: ");
					String num = s.next();
					
					System.out.println("Enter the vehicle Color: ");
					String col = s.next();
					
					Vehicle v = new Vehicle(type-1, num, col);
					
					lot.parkVehicle(v);
					break;
				}
				
				case 5:
				{
					System.out.println("Enter the ticket name pricisely: ");
					lot.unparkVehicle(s.next());
					break;
				}
				
				case 6:
				{
					System.out.println("Thank you");
					loop = false;
				}
			}
		}
	}
}