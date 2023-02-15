import java.util.Scanner;

class Subset
{
	int count = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size of the array : ");
		int size = s.nextInt();
		
		System.out.println("Enter elements of the array : ");
		int[] arr = new int[size];
		
		Subset obj = new Subset();
		
		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		
		/* for(int i = 0 ; i < size ; i++)  */obj.printSubsets(arr, -1, "");
		
	}
	
	public void printSubsets(int[] arr, int pos, String subsets)
	{
		if(pos >= arr.length) return;
		
		count++;
		
		System.out.println("Possibility (" + count + ") = " + subsets);

		for(int i = pos+1 ; i < arr.length ; i++)
			printSubsets(arr, i, subsets + arr[i] + ", ");
	}
}