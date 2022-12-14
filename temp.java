// import java.util.Scanner;
import java.util.*;

class temp
{
	public static void main(String args[])
	{
		int a = 15;
		int[] arr = {1};
		List<Integer> li = new ArrayList<>();
		li.add(25);
		String str = "aa";
		
		add(a);
		addArr(arr);
		addList(li);
		System.out.println("Declaration " + str.hashCode());
		addStr(str);
		
		System.out.println(a);
		System.out.println(arr[0]);
		System.out.println(li);
		System.out.println(str);

	}
	
	public static void add(int a)
	{
		a += 10;
	}
	
	public static void addArr(int[] arr)
	{
		arr[0]++;
	}
	
	public static void addList(List<Integer> list)
	{
		list.add(20);
	}
	
	public static void addStr(String str)
	{
		System.out.println("Before change " + str.hashCode());
		str += "bb";
		System.out.println("After change " + str.hashCode());
	}
}