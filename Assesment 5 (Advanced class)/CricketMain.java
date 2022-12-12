import java.util.Scanner;
import java.util.Random;

class CricketMain {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the team name :  ");
		String name = s.next();
		
		System.out.println("Enter the team players name :  ");
		String[] arr = new String[10];
		
		for(int i=0 ; i < 10 ; i++)
			arr[i] = s.next();
		
		System.out.println("Select the captain :  ");
		int captain = s.nextInt();
		
		Team t1 = new Team(name, captain, arr);

		System.out.println("Enter the team name :  ");
		name = s.next();
		
		System.out.println("Enter the team players name :  ");		
		for(int i=0 ; i < 10 ; i++)
			arr[i] = s.next();
		
		System.out.println("Select the captain :  ");
		captain = s.nextInt();
		
		Team t2 = new Team(name, captain, arr);
		
		String c1 = t1.getCaptainName(), c2 = t2.getCaptainName();
		if(c1 == null) {
			System.out.println("Select the captain :  ");
			captain = s.nextInt();
			t1.setCaptain(captain);
		}
		
		if(c2 == null) {
			System.out.println("Select the captain :  ");
			captain = s.nextInt();
			t2.setCaptain(captain);
		}			
			
		System.out.println("It is time to toss " );
		int toss = 0;
			
		Random r = new Random();
		do {
			toss = r.nextInt();
		} while(toss > 2 && toss < 1);
		
		int loop = 0;
		do {
			loop = r.nextInt(11);
		} while(loop < 5);
		
		for(int i = 0 ; i < loop ; i++)
		{
			if(i == loop -1)
			{
				System.out.println((toss == 1) ? "Heads" : "Tails");
				break;
			}
			try {
			Thread.sleep(250);
			System.out.println("[Heads]");
			Thread.sleep(250);
			System.out.println("[Tails]");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		s.close();
	}
}

class Team {
	String name;
	int captain;
	String[] players = new String[10];
	
	Team(String name, int captain, String[] players) {
		this.name = name;
		if(captain > 0 && captain < 11) {
			this.captain = captain;
		}
		this.players = players;
	}
	
	public String setCaptain(int captain) {
		if(captain > 0 && captain < 11) {
			this.captain = captain;
			return players[captain];
		}
		return null;
	}
	
	public String getCaptainName() {
		if(captain >= 0 && captain <= 10)
			return players[captain-1];
		else
			return null;
	}
}