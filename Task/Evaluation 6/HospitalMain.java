package Hospital;

import java.util.Scanner;
import Hospital.HospitalTiming;

class HospitalMain
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		HospitalTiming[] time = new HospitalTiming[5];
		
		for(int i = 0 ; i < 4 ; i++)
		{
			System.out.println("Enter the name of patient :");
			String name = s.next();
			
			System.out.println("Enter the hour and minutes of arrival :");
			int arrHour = s.nextInt();
			int arrMin = s.nextInt();
			
			System.out.println("Enter the doctor time of the patient :");
			int docTime = s.nextInt();
			
			if(i != 0)
			{
				time[i] = new HospitalTiming(name, arrHour, arrMin, docTime, time[i-1]);
			}
			else 
			{
				time[i] = new HospitalTiming(name, arrHour, arrMin, docTime, new HospitalTiming());
			}
		}
		
		System.out.println("\n\n\nPID\t\tName\t\tDocTime\t\tOutTime\t\tWaiting time");
		for(int i = 0 ; i < 4 ; i++)
		{
			System.out.println(time[i].toString());
		}
		
		s.close();
	}
}