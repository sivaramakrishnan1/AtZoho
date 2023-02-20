import java.util.List;
import java.util.ArrayList;

class User
{
	int zid;
	String email;
	private String name, number, password, H_id;
	private double RCurrency, ZCurrency; 
	List<String> transactions = new ArrayList<>();
	
	User(String hid, String name, String email, String number, String password, double RCurrency)
	{
		this.H_id = hid; 
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = encrypt(password);
		this.RCurrency = RCurrency;
	}
	
	private String encrypt(String password)
	{
		String enc = "";
		
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(password.charAt(i) == 'z') enc += "a";
			else if(password.charAt(i) == 'Z') enc += "Z";
			else if(password.charAt(i) == '9') enc += "0";
			else enc += (char)(password.charAt(i) + 1) + "";
		}
		
		return enc;
	}
	
	public boolean authentication(String password)
	{
		return this.password.equals(encrypt(password));
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public double getRCurrencyBalance()
	{
		return this.RCurrency;
	}
	
	public double getZCurrencyBalance()
	{
		return this.ZCurrency;
	}
	
	public void withdrawRCurrency(double value)
	{
		if(RCurrency - value < 0) {
			System.out.println("INSUFFICIENT BALANCE!");
			return;
		}
		
		this.RCurrency -= value;
	}
	
	public void withdrawZCurrency(double value)
	{
		if(ZCurrency - value < 0) {
			System.out.println("INSUFFICIENT BALANCE!");
			return;
		}
		
		this.ZCurrency -= value;
	}
	
	public void depositRCurrency(double value)
	{
		if(value < 0) {
			System.out.println("CANNOT DEPOSIT THAT AMOUNT");
			return;
		}
		
		this.RCurrency += value;
	}
	
	public void depositZCurrency(double value)
	{
		if(value < 0) {
			System.out.println("CANNOT DEPOSIT THAT AMOUNT");
			return;
		}
		
		this.ZCurrency += value;
	}
	
	@Override
	public String toString()
	{
		return String.format("Name : %-20s | email : %-20s | Phone number : %-10s | RCurrency : %-10s | ZCurrency : %-10s", name, email, number, RCurrency, ZCurrency);
	}
}