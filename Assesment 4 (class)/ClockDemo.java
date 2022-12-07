import java.util.Scanner;

class ClockDemo
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		// the first clock
		System.out.println("Enter the seconds only for the first clock : ");
		Clock firstClock = new Clock(s.nextInt());
		
		// clock increase 10 second
		for(int i = 0 ; i < 10 ; i++) {
			firstClock.tick();
			System.out.println(firstClock.toString());
		}
		
		// the second clock
		System.out.println("Enter the Hours, Minutes, and Seconds : ");
		Clock secondClock = new Clock(s.nextInt(), s.nextInt(), s.nextInt());
		
		// clock increase 10 second
		for(int i = 0 ; i < 10 ; i++) {
			secondClock.tickDown();
			System.out.println(secondClock.toString());
		}
		
		// adding second clock time to first clock time
		firstClock.addClock(secondClock);
		System.out.println("First clock " + firstClock.toString());
		System.out.println("Second clock " + secondClock.toString());	
		
		
		Clock thirdClock = firstClock;
		
		thirdClock.subtractClock(secondClock);
		System.out.println("Third clock " + thirdClock.toString());
		
		s.close();
	}
}