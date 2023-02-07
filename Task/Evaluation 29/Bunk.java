import java.util.List;
import java.util.ArrayList;

class Bunk
{
	String id = "";
	private int petrolCapacity, dieselCapacity, petrolHolding, dieselHolding;
	float petrolPrice, dieselPrice, petrolRevenue, dieselRevenue;
	private List<Bill> bills = new ArrayList<>();
	
	Bunk(String id, int petrolCapacity, float petrolPrice, int dieselCapacity, float dieselPrice)
	{
		this.id = id;
		this.petrolCapacity = petrolCapacity;
		this.petrolHolding = this.petrolCapacity;
		
		this.dieselCapacity = dieselCapacity;
		this.dieselHolding = this.dieselCapacity;
	
		this.petrolPrice = petrolPrice;
		this.dieselPrice = dieselPrice;
		
		System.out.println("Created Bunk with " + this.id + " with " + this.petrolCapacity + " petrol and " + this.dieselCapacity + " diesel capacity.");
	}
	
	public void view()
	{
		System.out.println(String.format("| Bunk ID: %10s | Current Holding Petrol: %10s | Current Holding Diesel : %10s |", id, petrolHolding, dieselHolding));
		System.out.println(String.format("| Petrol Revenu from sales : Rs. %15s |\n| Diesel Revenue from sales : Rs. %15s |", petrolRevenue, dieselRevenue));
		System.out.println(String.format("| Petrol : Rs. %10s | Diesel : Rs. %10s |", petrolPrice, dieselPrice));
	}
	
	public void view(String field, String querry)
	{
		switch(field)
		{
			
		}		
	}
	
	public void refill()
	{
		petrolHolding = petrolCapacity;
		dieselHolding = dieselCapacity;
	}
	
	public void fillPetrol(String regno, String vtype, int filled)
	{
		if(petrolHolding - filled > -1) {
			bills.add(new Bill(regno, true, vtype, filled, filled * petrolPrice));
			petrolHolding -= filled;
			petrolRevenue += filled * petrolPrice;
			System.out.println("Filled ");
			return;
		} else {
			System.out.println("Not enough PETROL to fill at the moment, please kindly revisit");
		}
	}
	
	public void fillDiesel(String regno, String vtype, int filled)
	{
		if(dieselHolding - filled > -1) {
			bills.add(new Bill(regno, false, vtype, filled, filled * dieselPrice));
			dieselHolding -= filled;
			dieselRevenue += filled * dieselPrice;
			return;
		}

		System.out.println("Not enough DIESEL to fill at the moment, please kindly revisit");
		
	}
	
	public void find(String regno)
	{
		String result = "";
		for(Bill b : bills)
		{
			if(b.regno.equals(regno))
				result += b.toString();
		}
		
		if(result.equals(""))
		{
			System.out.println("No vehicle found for registration number : regno");
			return;
		}
		
		System.out.println("\nFound " + regno + "\nHistory : \n" 
		+ "+-----------------+---------+-----------+-------+------------+--------------------------+\n"
		+ "|          Reg.No |    Type |   Vehicle | Litre |       Price|                     Time |\n"
		+ "+-----------------+---------+-----------+-------+------------+--------------------------+\n"
		+ result
		+ "+-----------------+---------+-----------+-------+------------+--------------------------+\n");		
	}
	
	public void alter(boolean isPetrol, float price)
	{
		if(isPetrol) {
			this.petrolPrice = price;
			System.out.println("Petrol price changed successfully.");
			return;
		}
		
		this.dieselPrice = price;
		System.out.println("Diesel price changed successfully.");
	}
	
	private List<Bill> filterType(int type)
	{
		List<Bill> newBill = new ArrayList<>();
		
		switch(type)
		{
			case 1:
			for(Bill b : bills)
				if(b.vtype.equals("BIKE")) newBill.add(b);
			break;
			
			case 2:
			for(Bill b : bills)
				if(b.vtype.equals("CAR")) newBill.add(b);
			break;
			
			case 3:
			for(Bill b : bills)
				if(b.vtype.equals("TRUCK")) newBill.add(b);
			break;
		}
		
		return newBill;
	}
	
	public void printFilter(int type)
	{
		List<Bill> filBill = filterType(type);
		
		System.out.println("\nFound " + regno + "\nHistory : \n" 
		+ "+-----------------+---------+-----------+-------+------------+--------------------------+\n"
		+ "|          Reg.No |    Type |   Vehicle | Litre |       Price|                     Time |\n"
		+ "+-----------------+---------+-----------+-------+------------+--------------------------+\n");
		for(Bill b : filBill)
			System.out.println(b.toString());
		System.out.println("+-----------------+---------+-----------+-------+------------+--------------------------+\n");		
	
		
	}
	
	public void filter(String querry)
	{
		int num = 0, mode = 0;
		for(int i = querry.length() ; i > -1 ; i--)
		{
			if(i == 0)
			{
				if(querry.charAt(0) == '<') mode = -1;
				else if(querry.charAt(0) == '>') mode = 1;
				else mode = 0;
				
				num *= 10;
				num += querry.charAt(i) - '0';
			}
		}
		
		switch(mode)
		{
			case -1:
			for(Bill b : bills)
				if(b.filled < num) System.out.println(b.toString());
			break;
			
			case 0:
			for(Bill b : bills)
				if(b.filled == num) System.out.println(b.toString());
			break;
			
			case 1:
			for(Bill b : bills)
				if(b.filled > num) System.out.println(b.toString());
			break;
		}
		
	}
	
	public void hybridFilter(String querry, int type)
	{
		int num = 0, mode = 0;
		for(int i = querry.length() ; i > -1 ; i--)
		{
			if(i == 0)
			{
				if(querry.charAt(0) == '<') mode = -1;
				else if(querry.charAt(0) == '>') mode = 1;
				else mode = 0;
				
				num *= 10;
				num += querry.charAt(i) - '0';
			}
		}
		
		List<Bill> filBill = filterType(type);
		switch(mode)
		{
			case -1:
			for(Bill b : filBill)
				if(b.filled < num) System.out.println(b.toString());
			break;
			
			case 0:
			for(Bill b : filBill)
				if(b.filled == num) System.out.println(b.toString());
			break;
			
			case 1:
			for(Bill b : filBill)
				if(b.filled > num) System.out.println(b.toString());
			break;
		}
		
	}
}