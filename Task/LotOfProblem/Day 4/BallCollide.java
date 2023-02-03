import java.util.Scanner;

class BallCollide
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[] direction = new int[size], strength = new int[size];
		
		for(int i = 0 ; i < size ; i++) direction[i] = s.nextInt();
		for(int i = 0 ; i < size ; i++) strength[i] = s.nextInt();
		s.close();
		
		int[] res = getFinalist(direction, strength);
		for(int i = 0 ; i < size ; i++) if(res[i] != 0) System.out.print(res[i] + " ");
	}
	
	public static int[] getFinalist(int[] direction, int[] strength)
	{
		for(int i = 1 ; i < direction.length ; i++)
		{
			int lastLeft = -1, firstRight = -1;
			
			for(int j = 0 ; j < direction.length ; j++)
			{
				if(lastLeft != -1 && firstRight != -1) break;
				if(direction[j] == 1 && firstRight == -1) firstRight = j;
				if(direction[j] == -1) lastLeft = j;
			}
			
			if(lastLeft < firstRight) break;
			if(lastLeft == -1 || firstRight == -1) break;
			
			for(int j = 0 ; j < direction.length ; j++)
			{
				if(j + i < direction.length)
				{
					if(direction[j] == -1 || direction[j+i] == 1) continue;
					if(strength[j] == strength[j+i]) 
					{
						direction[j] = 0;
						direction[j+i] = 0;
						strength[j] = 0;
						strength[j+i] = 0;
					} else if(strength[j] < strength[j+i]) {
						direction[j] = 0;
						strength[j] = 0;
					} else {
						direction[j+i] = 0;
						strength[j+i] = 0;
					}
				}
			}
			
			for(int j = direction.length - 1 ; j > -1 ; j--)
			{
				if(j - i > -1)
				{
					if(direction[j] == 1 || direction[j-i] == -1) continue;
					if(strength[j] == strength[j-i]) 
					{
						direction[j] = 0;
						direction[j-i] = 0;
						strength[j] = 0;
						strength[j-i] = 0;
					} else if(strength[j] < strength[j-i]) {
						direction[j] = 0;
						strength[j] = 0;
					} else {
						direction[j-i] = 0;
						strength[j-i] = 0;
					}
				}
			}
		}
		
		for(int i = 0 ; i < direction.length ; i++)
			if(direction[i] != 0) direction[i] = i+1;
		
		return direction;
	}
}