import java.util.Date;
import java.text.DateFormat;

/* 
getDateInstance = gets date related contents
getTimeInstance = gets time relate contents

format : 
DateFormat.LONG - a long value of the date
DateFormat.MEDIUM - a medium value of the date
DateFormat.SHORT - a short value of the date

! DONT FORGET TO 
add the Date object to the format()

 */

class dateAndTime
{
	public static void main(String args[])
	{
		Date d = new Date();
		
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(d));
		System.out.println(DateFormat.getTimeInstance(DateFormat.SHORT).format(d));
	}
}
