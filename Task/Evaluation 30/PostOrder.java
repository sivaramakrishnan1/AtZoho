import java.util.Scanner;

class PostOrder
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) {
			arr[i] = s.nextInt();
			
		}
		
		for(int i = 0 ; i < size ; i++) {
			System.out.print(((arr[i] == -1) ? "" : arr[i] + " "));
		}
		s.close();		
	}
}