import java.util.Scanner;

class anyNumber
{
	static String str = "";
	public static void main(String args[])
	{
		Scanner s  = new Scanner(System.in);
		int lim = s.nextInt();
		int arr[] = new int[100];
		arr[0] = 3;
		arr[1] = 4;
		int k = 1;
		
		for(int i=0 ; k < lim ; i++)
		{
			arr[++k] = (arr[i]*10)+3;
			arr[++k] = (arr[i]*10)+4;
		}
		
		for(int i : arr) {
			if(i == 0) break;
			System.out.println(i);
		}
		s.close();
	}
	
	
}