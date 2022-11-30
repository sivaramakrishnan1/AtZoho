import java.util.Scanner;

class addBase 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);	
		int op1 = s.nextInt();
		int op2 = s.nextInt();
		int base = s.nextInt();
		int ans = op1 + op2;
		
		if(base == 10) 
		{ 
			System.out.println("Answer " + ans); 
			return; 
		}
		int realAns = 0, lim = 1, carry = 0, add = 0;
		/* if(base == 2)
		{
			System.out.println(binaryAdd(op1, op2));
		} */
			
		while(ans>0)
		{
			add += (ans%10) % base;
			carry = (ans%10) / base;
			if(add >= base)
			{
				carry = add / base;
				add = add % base;
			}
			realAns += add * lim;
			lim *= 10;
			add = carry;
			ans /= 10;
		}
		if(carry != 0)
		{
			realAns += carry * lim;
		}
		System.out.println(realAns);
		
		s.close();		
		
	}
}	
		
/* import java.util.Scanner;

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
			// System.out.println(op1 + "\t" + op2 + "\t" + curr1 + "\t" + curr2 + "\t" + tot + "\t" + carry+ "\t" + lim);

			tot += ((curr1 + curr2 + carry) % base) * lim;
			
			carry = (curr1 + curr2 + carry>= base) ? (curr1 + curr2 + carry)/base : 0;
			lim *= 10;
			op1 /= 10;
			op2 /= 10;
		}
		System.out.println("Answer " + tot); 
		s.close();		
	}
} */