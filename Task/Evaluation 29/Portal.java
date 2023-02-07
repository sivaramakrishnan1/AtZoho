import java.util.Scanner;

class Portal
{
	static Scanner s = new Scanner(System.in);
	Bunk bunk;
	
	public void download()
	{
		
	}
	
	public void upload()
	{	
		
	}
	
	public static void start()
	{
		Portal p = new Portal();
		p.portal();
		s.close();
	}	
	
	public void portal()
	{
		String bunkId = "\n//> : ";
		
		out : while(true)
		{
			System.out.print(bunkId);
			String[] cmd = (s.nextLine()).split(" ");
			
			if(cmd.length < 0) continue;
			
			switch(cmd[0])
			{
				case "create_bunk" : 
					bunk = new Bunk(cmd[1], Integer.parseInt(cmd[2]), Float.parseFloat(cmd[3]), Integer.parseInt(cmd[3]), Float.parseFloat(cmd[4]));
					bunkId = "\n" + cmd[1] + "//> : ";
					break;
				
				case "fill" : 
					if(cmd[1].equals("tankfill"))
					{
						System.out.println(Integer.parseInt(cmd[5]) - Integer.parseInt(cmd[6]));
						
						if(cmd[2].equals("PETROL")) bunk.fillPetrol(cmd[3], cmd[4], ((Integer.parseInt(cmd[5])) - (Integer.parseInt(cmd[6]))));
						else bunk.fillDiesel(cmd[3], cmd[4], (Integer.parseInt(cmd[5]) - Integer.parseInt(cmd[6])));
						continue;
					}
					
					if(cmd[2].equals("PETROL")) bunk.fillPetrol(cmd[3], cmd[4], Integer.parseInt(cmd[5]));
					else bunk.fillDiesel(cmd[3], cmd[4], Integer.parseInt(cmd[5]));
					break;
				
				case "alter":
				bunk.alter(cmd[1].equals("PETROL"), Float.parseFloat(cmd[2]));
				break;
				
				case "filter":
				if(cmd[1].equals("type"))
				{
					switch(cmd[2]) {
						case "BIKE" : bunk.printFilter(1); break;
						case "CAR" : bunk.printFilter(2); break;
						case "TRUCK" : bunk.printFilter(3); break;
						default : System.out.println("Invalid command, try \"HELP\" command");
					}
					continue;
				}
				
				bunk.filter(cmd[2]);
				break;				
				
				case "find": bunk.find(cmd[1]); break;
				
				case "refill" : bunk.refill(); break;
				
				case "exit" : break out;
			}
		}
	}
	
}