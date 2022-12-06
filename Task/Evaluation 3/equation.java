import java.util.Scanner;

class equation
{
	static int[] stack = new int[50];
	public static void main(String a[])
	{
		Scanner s = new Scanner(System.in);
		
		int val = 0, size = s.nextInt(), num = 0, ptr = -1;
		String[] exp = new String[size];
		
		for(int i=0 ; i<size ; i++)
		{
			exp[i] = s.next();
		}
				
		for(int i = 0 ; i < exp.length ; i++) 
		{
			if(exp[i].charAt(0) >= '0' && exp[i].charAt(0) <= '9')
			{				
				val = parsed(exp[i]);
				printStack(stack, ptr);
				stack[++ptr] = val;	
			}
			else
			{
				System.out.println(exp[i]);
				System.out.println("In cal");
				switch(exp[i].charAt(0))
				{
					case '+' : 
					{
						stack[ptr-1] = stack[ptr-1] + stack[ptr];
						printStack(stack, ptr);
						ptr--;
						break;
					}
					
					case '-' : 
					{
						stack[ptr-1] = stack[ptr-1] - stack[ptr];
						printStack(stack, ptr);
						ptr--;
						break;
					}
					case '*' : 
					{
						stack[ptr-1] = stack[ptr-1] * stack[ptr];
						printStack(stack, ptr);
						ptr--;
						break;
					}
					case '/' : 
					{
						stack[ptr-1] = stack[ptr-1] / stack[ptr];
						printStack(stack, ptr);
						ptr--;
						break;
					}
					default : 
					printStack(stack, ptr);
					
				}
			}
		}
		
		System.out.println(stack[0]);
	}
	
	public static void printStack(int[] arr, int lim)
	{
		for(int i=0 ; i <= lim ; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int parsed(String str)
	{
		int num = 0;
		
		for(int i=0 ; i<str.length() ; i++)
		{
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
			{
				num = (num * 10) + (str.charAt(i) - '0');
			}
		}
		
		if(str.charAt(0) == '-')
			num *= -1;
		
		return num;
	}		
}
