import java.util.Scanner;

class addBase 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);		
		System.out.println("Enter two numbers  and the base: ");
		int op1 = s.nextInt();
		int op2 = s.nextInt();
		int base = s.nextInt();
		
		if(base == 10) 
		{ 
			System.out.println("Answer " + (op1 + op2)); 
			return; 
		}
		if(base == 2)
		{
			binary(
		System.out.println("op1\top2\tcur1\tcur2\ttot\tcarr\tlim");
		
		int tot = 0, lim = 1, carry = 0;
		while(op1 > 0 || op2 > 0)
		{			

			if(op1 == 0) 
			{
				tot += (op2 + carry) * lim;
				break;
			}
			else if(op2 == 0)
			{
				tot += (op1 + carry) * lim;
				break;
			}	
			int curr1 = op1 % 10, curr2 = op2 % 10;
			System.out.println(op1 + "\t" + op2 + "\t" + curr1 + "\t" + curr2 + "\t" + tot + "\t" + carry+ "\t" + lim);

			tot += ((curr1 + curr2 + carry) % base) * lim;
			
			carry = (curr1 + curr2 + carry>= base) ? (curr1 + curr2 + carry)/base : 0;
			lim *= 10;
			op1 /= 10;
			op2 /= 10;
		}
		System.out.println("Answer " + tot); 
		s.close();		
	}
}