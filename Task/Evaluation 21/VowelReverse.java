import java.util.Scanner;

class VowelReverse
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no. of. Test cases : ");
		int T = s.nextInt();
		char[] str;
		for(int k = 0 ; k < T ; k++)
		{
			str = (s.next()).toCharArray();
			int last = str.length -1;
			
			for(int i = 0 ; i < last ; i++) 
				if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
					while(last > i) {
						if(str[last] == 'a' || str[last] == 'e' || str[last] == 'i' || str[last] == 'o' || str[last] == 'u') {
							char temp = str[last];
							str[last] = str[i];
							str[i] = temp;
							last--;
							break;
						}
						last--;
					}
			System.out.println(String.valueOf(str));
		}
	}
}