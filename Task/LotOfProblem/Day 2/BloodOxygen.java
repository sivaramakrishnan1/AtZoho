import java.util.Scanner;

class BloodOxygen
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		float[][] oxy = new float[3][3];
		
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
				oxy[i][j] = s.nextFloat();
		
		for(int i = 0 ; i < 3 ; i++)
		{
			float sum = 0;
			for(int j = 0 ; j < 3 ; j++)
				sum += oxy[j][i];
			oxy[0][i] = sum / 3;
		}
		
		String res = "";
		float max = 0;
		
		for(int i = 0 ; i < 3 ; i++)
		{
			if(max < oxy[0][i]) 
			{ 
				res = "Trainee Number : " + i + "\n";
				max = oxy[i][0];
			}	
			else if(max == oxy[0][i]) 
				res += "Trainee Number : " + i + "\n";
		}
		
		System.out.println(res);
	}
}