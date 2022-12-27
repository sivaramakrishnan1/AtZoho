import java.util.Scanner;

class NumToString 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		String[] number = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String[] tens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		
		String text = "";
		int num = s.nextInt();
		
		if(num == 0) {
			System.out.println("Zero");
			return;
		}
		int limit = 100;
		
		while(num > 0) {
			if(num > 999999)
			{
				text += number[(num / 1000000) - 1] + " Million ";
				num %= 1000000;
			}
			else if(num > 999)
			{
				// text += number[(num/1000) -1] + " Thousand ";
				int val = num / 1000;
				System.out.println(val);
				if(val > 99)
				{
					text += number[(val/100)-1] + " hundred";
					val %= 100;
				}
				if(val > 19)
				{
					text += tens[(val/10)+8] + " ";
					val %= 10;
				}
				if(val > 9)
				{
					text += tens[(val%10)] + " ";
					val %= 10;
				}
				else if(val > 0)
				{
					text += number[(val/1)-1] + " ";
					val = 0;
				}
				num %= 1000;
				text += "thousand ";
			}
			else if(num > 99)
			{
				text += number[(num/100)-1] + " hundred ";
				num %= 100;
			}
			else if(num > 19)
			{
				text += tens[(num/10)+8] + " ";
				num %= 10;
			}
			else if(num > 9)
			{
				text += tens[(num%10)] + " ";
				num %= 10;
				break;
			}
			else if(num > 0)
			{
				text += number[(num/1)-1] + " ";
				num = 0;
				break;
			}
			System.out.println(text);
		}
		
		System.out.println(text);
	}
	
	public static void add(String str, String[] strs)
	{
		String[] copy = new String[strs.length + 1];
		for(int i = 0 ; i < strs.length ; i++)
		{
			copy[i] = strs[i];
		}
		
		strs = copy;
		copy[copy.length-1] = str;
	}
}

/* 
0 - One
1 - Two
2 - Three
3 - Four
4 - Five
5 - Six
6 - Seven
7 - Eight
8 - Nine
9 - Ten
10 - Eleven
11 - Twelve
12 - Thirteen
13 - Fourteen
14 - Fifteen
15 - Sixteen
16 - Seventeen
17 - Eighteen
18 - Nineteen
19 - Twenty
20 - Thirty
21 - Fourty
22 - Fifty
23 - Sixty
24 - Seventy
25 - Eighty
26 - Ninty
27 - Hundred 100
28 - Thousand 1000
29 - Million 1 000 000
*/