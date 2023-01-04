import java.util.Scanner;
import java.util.HashMap;

class Roman
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		Roman obj = new Roman();
		System.out.println(obj.romanToInt(str));
	}
	
	public int romanToInt(String str) {
		int sum = 0, prev = 1001;		
		for(int i = 0 ; i < str.length() ; i++) {
			int val = get(str.charAt(i));
			sum += val;
			if(prev < val)
				sum -= 2 * prev;
			prev = val;
		}
		return sum;
    }

	public int get(char c)
	{
		switch(c){
			case 'I' : return 1;
			case 'V' : return 5;
			case 'X' : return 10;
			case 'L' : return 50;
			case 'C' : return 100;
			case 'D' : return 500;
			case 'M' : return 1000;
		}
		return 0;
	}
}