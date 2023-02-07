import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bill
{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM YYYY : hh mm ss a");
	static LocalDateTime ldt = LocalDateTime.now();
	
	String regno, time;
	boolean isPetrol;
	String vtype; // bike = 0; car = 1 ; truck = 2
	int filled;
	float amount;
	
	Bill(String regno, boolean isPetrol, String vtype, int filled, float amount) 
	{
		this.regno = regno;
		this.isPetrol = isPetrol;
		this.vtype = vtype;
		this.filled = filled;
		this.amount = amount;
		this.time = ldt.format(dtf);
	}
	
	public String toString() {
		return String.format("| %15s | %7s | %9s | %5s | %10s | %20s |\n", regno, ((isPetrol) ? "PETROL" : "DIESEL"), vtype, filled, amount, time);
	}
}