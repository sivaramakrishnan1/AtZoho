import java.util.*;

class temp1
{
	public static void main(String args[])
	{
		Students s1 = new Students(2, "Siva");
		Students s2 = new Students(1, "Yaar");
		Students s3 = new Students(0, "Ivan");
		
		// method 1 : 
		TreeSet<Students> t = new TreeSet<>((Students a, Students b) -> a.roll - b.roll);
		// TreeSet<Students> t = new TreeSet<>(new Students());
		
		t.add(s1);
		t.add(s2);
		t.add(s3);
		
		System.out.println(t);
		// Collections.sort(t, new Comparer());
		System.out.println(t);

	}
}

// The class which have only one function which is a overriden function 
// of an interface, is called as Helper class

/* class Comparer implements Comparator<Students> 
{
	public int compare(Students a, Students b)
	{
		return a.roll - b.roll;
	}
} */

class Students implements Comparator<Students> 
{
	int roll;
	String name;	
	Students(){}	
	Students(int roll, String str)
	{
		this.roll = roll;
		this.name = str;
	}
	public String toString()
	{
		return this.roll + " - " + this.name;
	}
	
	public int compare(Students a, Students b)
	{
		return a.roll - b.roll;
	}
}