import java.util.Scanner;
// 1234 + 23 - 546
class expression
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String exp = s.next();
		int[] nums =new int[10];
		char[] opr = new char[10];
		int n = 0, i = 0, o = 0 , in = 0;
		
		while(i < exp.length())
		{
			if(exp.charAt(i) >= '0' && exp.charAt(i) <= '9')
			{
				while(i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
					n = n * 10 + (exp.charAt(i) - '0');
					i++;
				}/* 
				for(int j : nums) System.out.print(j + " " );
				System.out.print("\n"); */
				nums[in++] = n;
				n = 0;
			}
			else if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/')
			{
				opr[o++] = exp.charAt(i);
				i++;
			}
			else i++;
		}
		
		
		int val = nums[0];
		n = 0;
		
		for(n = 1 ; n < nums.length; n++)
		{
			switch(opr[n-1]) 
			{
			case '+' :
				val += nums[n];
				break;
				
			case '-' :
				val -= nums[n];
				break;
				
			case '*' :
				val *= nums[n];
				break;
			
			case '.' :
				val /= nums[n];
				break;
				
			default : 
				System.out.println(nums[n] + opr[n-1]);
				break;
			}
		}
		System.out.println(val);
		s.close();
	}
}