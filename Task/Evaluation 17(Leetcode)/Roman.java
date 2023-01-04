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
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
		
		int[] num = new int[str.length()];
		
		for(int i = 0 ; i < str.length() ; i++)
			num[i] = map.get(str.charAt(i));
		
		int sum = num[0];
		// MCMXCIV
		//1000 100 1000 10 100 1 5
		
		for(int i = 1 ; i < str.length() ; i++) {
			System.out.println(num[i+1] + " " + sum);

			if(i == str.length() - 1)
			{
				if(num[i-1] < num[i]) sum -= num[i-1];
				sum += num[i];
				break;
			}
			if(num[i] < num[i+1])
				sum -= num[i];
			sum += num[i+1];	
		}
		
		return sum;
    }
}